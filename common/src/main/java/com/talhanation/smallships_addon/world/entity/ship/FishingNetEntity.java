package com.talhanation.smallships_addon.world.entity.ship;

import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships_addon.config.AddonConfig;
import com.talhanation.smallships_addon.world.entity.AddonEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * The trawl net of a {@link FishingBoatEntity}, as a standalone entity.
 *
 * It is a box in the water and nothing else: it cannot be hit, picked, pushed
 * or walked into. The boat puts it out while its net is lowered and takes it
 * away again when the net is hauled in.
 *
 * Built like a ShipPartEntity. Position is never sent over the network - the
 * net only carries the entity id of its boat plus its own local offset, and
 * the boat places it every tick on both sides, see FishingBoatEntity#tickNet
 * and #tickClientHull.
 *
 * Everything the net DOES happens on the server, in here:
 * - small water animals inside the box are killed where they are
 * - every item inside the box goes into the hold of the boat, the drops of
 *   those animals included
 * - every so often it brings up a catch of its own from the fishing loot
 *   table, and sooner while the boat tows it along
 */
public class FishingNetEntity extends Entity {
    public static final String ID = "fishing_net";

    private static final EntityDataAccessor<Integer> PARENT_ID = SynchedEntityData.defineId(FishingNetEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> LOCAL_V = SynchedEntityData.defineId(FishingNetEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> LOCAL_Y = SynchedEntityData.defineId(FishingNetEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> LOCAL_H = SynchedEntityData.defineId(FishingNetEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> NET_WIDTH = SynchedEntityData.defineId(FishingNetEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> NET_HEIGHT = SynchedEntityData.defineId(FishingNetEntity.class, EntityDataSerializers.FLOAT);

    /**
     * Ticks between two sweeps of the box. Short on purpose: a boat at full
     * way covers more than a block in this time, and a fish the box has
     * passed over between two sweeps is a fish that got away.
     */
    private static final int SWEEP_INTERVAL = 5;
    /** how far past the box drifting items are still taken - a drop lies where the animal was, and that may be on the edge */
    private static final double ITEM_REACH = 0.5D;
    /** ticks between two looks at whether the net has been towed on, see tickTowBonus */
    private static final int TOW_CHECK_INTERVAL = 3 * 20;
    /**
     * Blocks the net has to be away from where it was at the last look to
     * count as towed. A boat lying at anchor still bobs a little, and that
     * is not fishing ground covered.
     */
    private static final double TOW_MIN_DISTANCE = 1.0D;

    /** server side: ticks left until the net brings up its next catch */
    private int catchTime;
    /** server side: where the net was at the last tow check */
    @Nullable private Vec3 lastTowPosition;

    public FishingNetEntity(EntityType<? extends FishingNetEntity> entityType, Level level) {
        super(entityType, level);
        // unlike a ShipPartEntity the net WANTS this flag: nothing may hit it,
        // and AbstractHurtingProjectile#canHitEntity refuses every entity that
        // carries it. It costs nothing, tick() below never simulates anything
        this.noPhysics = true;
    }

    public static FishingNetEntity factory(EntityType<? extends FishingNetEntity> entityType, Level level) {
        return new FishingNetEntity(entityType, level);
    }

    public FishingNetEntity(FishingBoatEntity ship, ShipPartEntity.Definition definition) {
        this(AddonEntityTypes.FISHING_NET, ship.level());
        this.entityData.set(PARENT_ID, ship.getId());
        this.entityData.set(LOCAL_V, definition.v());
        this.entityData.set(LOCAL_Y, definition.y());
        this.entityData.set(LOCAL_H, definition.h());
        this.entityData.set(NET_WIDTH, definition.width());
        this.entityData.set(NET_HEIGHT, definition.height());
        this.refreshDimensions();
        this.follow(ship);
        this.catchTime = getCatchTime();
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(PARENT_ID, -1);
        this.entityData.define(LOCAL_V, 0.0F);
        this.entityData.define(LOCAL_Y, 0.0F);
        this.entityData.define(LOCAL_H, 0.0F);
        this.entityData.define(NET_WIDTH, 1.0F);
        this.entityData.define(NET_HEIGHT, 1.0F);
    }

    /**
     * Server only, and never a movement: the boat carries the net itself, see
     * FishingBoatEntity#tickNet. The client has nothing to do in here, so it
     * does not matter whether it runs this tick or skips it.
     */
    @Override
    public void tick() {
        if (this.level().isClientSide()) return;

        FishingBoatEntity ship = this.getParent();
        // a net without its boat would go on fishing for nobody, and one that
        // was hauled in has no business in the water
        if (ship == null || ship.isRemoved() || !ship.isNetOut()) {
            this.discard();
            return;
        }

        // a net that hangs in the air or lies on the beach catches nothing
        if (!this.isNetInWater()) return;

        if (this.level().getGameTime() % SWEEP_INTERVAL == 0L) {
            this.catchFish();
            this.collectItems(ship);
        }

        this.tickTowBonus();

        if (--this.catchTime <= 0) {
            this.catchTime = getCatchTime();
            this.spawnFishingLoot(ship);
        }
    }

    /**
     * Places the net at its local offset, turned with the boats' yaw. Called
     * by the boat every tick on both sides.
     */
    public void follow(Ship ship) {
        Vec3 local = new Vec3(this.entityData.get(LOCAL_V), this.entityData.get(LOCAL_Y), this.entityData.get(LOCAL_H))
                .yRot(-ship.getYRot() * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F));
        this.setPos(ship.getX() + local.x, ship.getY() + local.y, ship.getZ() + local.z);
        this.setYRot(ship.getYRot());
    }

    /**
     * The net takes no position from the network, for the same reason a
     * ShipPartEntity does not: vanilla sends a rounded one whenever the
     * synched data changes, and the boat knows better where its net is.
     */
    @Override
    public void lerpTo(double x, double y, double z, float yRot, float xRot, int steps, boolean teleport) {
    }

    @Nullable
    public FishingBoatEntity getParent() {
        int id = this.entityData.get(PARENT_ID);
        return id != -1 && this.level().getEntity(id) instanceof FishingBoatEntity ship ? ship : null;
    }

    /* ---------------- catching ---------------- */

    /**
     * Asked for the middle of the box and not through Entity#isInWater: that
     * flag is kept up to date by Entity#baseTick, which the net never runs.
     */
    private boolean isNetInWater() {
        return this.level().getFluidState(BlockPos.containing(this.getBoundingBox().getCenter())).is(FluidTags.WATER);
    }

    /**
     * Kills every water animal in the box that is small enough for the mesh.
     * Asked for the hitbox and not for a list of species, so the fish of
     * other mods are caught as well, and a dolphin swims through.
     *
     * The animal dies the ordinary way and drops what it always drops - the
     * item sweep right after this picks that up.
     */
    private void catchFish() {
        float maxSize = AddonConfig.fishingBoatNetMaxFishSize.get().floatValue();
        List<WaterAnimal> fishes = this.level().getEntitiesOfClass(WaterAnimal.class, this.getBoundingBox(), fish -> fish.isAlive() && fish.getBbWidth() <= maxSize && fish.getBbHeight() <= maxSize);
        for (WaterAnimal fish : fishes) {
            fish.kill();
        }
    }

    /**
     * Stows every item in the box in the hold. What does not fit stays in the
     * water with the count that is left, so a full hold loses nothing.
     */
    private void collectItems(FishingBoatEntity ship) {
        List<ItemEntity> items = this.level().getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate(ITEM_REACH), ItemEntity::isAlive);
        for (ItemEntity itemEntity : items) {
            ItemStack itemStack = itemEntity.getItem();
            ItemStack rest = ship.addToHold(itemStack);

            if (rest.isEmpty()) itemEntity.discard();
            // only on a real change, setItem is synched to everyone watching
            else if (rest.getCount() != itemStack.getCount()) itemEntity.setItem(rest);
        }
    }

    /**
     * Every TOW_CHECK_INTERVAL ticks: is the net still where it was at the
     * last look? If not, the boat has towed it over new ground, and the wait
     * for the next catch gets a little shorter.
     *
     * A position compared across three seconds and not a speed read every
     * tick: a boat with a player at the helm is moved by his packets, the
     * server never sees it move inside its own tick.
     */
    private void tickTowBonus() {
        if (this.level().getGameTime() % TOW_CHECK_INTERVAL != 0L) return;

        Vec3 position = this.position();
        if (this.lastTowPosition != null && position.distanceToSqr(this.lastTowPosition) > TOW_MIN_DISTANCE * TOW_MIN_DISTANCE) {
            this.catchTime -= AddonConfig.fishingBoatNetTowBonus.get() * 20;
        }
        this.lastTowPosition = position;
    }

    /**
     * The catch the net brings up by itself: one roll on the vanilla fishing
     * loot table, straight into the hold. Deeper water fishes better.
     *
     * Skipped while the hold has no free slot - the net is simply full then,
     * and the next catch waits its full time again.
     */
    private void spawnFishingLoot(FishingBoatEntity ship) {
        if (!(this.level() instanceof ServerLevel serverLevel)) return;
        if (!ship.hasFreeHoldSlot()) return;

        float luckFromDepth = Math.min(25, this.getWaterDepth()) / 10.0F;
        float luck = 0.1F + luckFromDepth;

        LootParams lootParams = (new LootParams.Builder(serverLevel))
                .withParameter(LootContextParams.ORIGIN, this.position())
                .withParameter(LootContextParams.TOOL, ItemStack.EMPTY)
                .withLuck(luck)
                .create(LootContextParamSets.FISHING);
        LootTable lootTable = serverLevel.getServer().getLootData().getLootTable(BuiltInLootTables.FISHING);
        List<ItemStack> list = lootTable.getRandomItems(lootParams);

        for (ItemStack itemStack : list) {
            ItemStack rest = ship.addToHold(itemStack);
            // a table that hands out more than the last free slot takes
            if (!rest.isEmpty()) ship.spawnAtLocation(rest);
        }

        this.level().playSound(null, this.getX(), ship.getY(), this.getZ(), SoundEvents.FISHING_BOBBER_SPLASH, this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat());
    }

    /** @return how many blocks of water lie under the net, itself included */
    private int getWaterDepth() {
        BlockPos pos = this.blockPosition();
        int depth = 0;

        while (this.level().getBlockState(pos.below(depth + 1)).is(Blocks.WATER)) {
            depth++;
            if (depth > 64) break;
        }

        return depth + 1;
    }

    private static int getCatchTime() {
        return AddonConfig.fishingBoatNetCatchTime.get() * 20;
    }

    /* ---------------- size ---------------- */

    @Override
    public @NotNull EntityDimensions getDimensions(@NotNull Pose pose) {
        return EntityDimensions.fixed(this.entityData.get(NET_WIDTH), this.entityData.get(NET_HEIGHT));
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> accessor) {
        // the size lives in the synched data, so the client only learns it with
        // the spawn packet - without this the box stays at the registered default
        if (NET_WIDTH.equals(accessor) || NET_HEIGHT.equals(accessor)) this.refreshDimensions();
        super.onSyncedDataUpdated(accessor);
    }

    /* ---------------- not a body ---------------- */

    /**
     * Not pickable, so no crosshair, no arrow and no cannon ball ever finds
     * the net: they all go through a raytrace that asks this first.
     */
    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    /** whatever still reaches the net - an explosion, a sweep attack - does nothing to it */
    @Override
    public boolean hurt(@NotNull DamageSource damageSource, float amount) {
        return false;
    }

    /* ---------------- lifecycle ---------------- */

    /**
     * Never saved. The boat puts its net out again on every load from its own
     * NET_OUT flag, and a saved net would only come back as an orphan: the
     * parent link is an entity id that does not survive a restart.
     */
    @Override
    public boolean shouldBeSaved() {
        return false;
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }
}

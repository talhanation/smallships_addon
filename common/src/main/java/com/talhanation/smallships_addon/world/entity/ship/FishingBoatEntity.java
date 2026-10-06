package com.talhanation.smallships_addon.world.entity.ship;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.ShipUpgrade;
import com.talhanation.smallships.world.entity.ship.abilities.Ability;
import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import com.talhanation.smallships_addon.config.AddonConfig;
import com.talhanation.smallships_addon.world.entity.AddonEntityTypes;
import com.talhanation.smallships_addon.world.item.AddonItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;


/**
 * Fishing Boat - small single masted boat that drags a trawl net astern.
 *
 * A ship class is written exactly like the main mods' own ships: extend Ship or
 * ContainerShip and implement the abilities you want (Sailable, Seatable, ...).
 *
 * What is its own here is the net: a key press on the client flips NET_OUT on
 * the server, and while it is set the boat keeps a {@link FishingNetEntity}
 * alive that does the catching. The net only stays out while someone is
 * aboard to work it, see hasNetCrew.
 */
public class FishingBoatEntity extends ContainerShip implements Sailable, Seatable, Ability, Leashable {
    // registry path of the entity, the items and the dockyard recipe
    public static final String ID = "fishing_boat";

    /**
     * Whether the net is in the water. Synched data and not a field: the key
     * is pressed on one client, the net is worked on the server, and everyone
     * who looks at the boat has to see the same net - the model draws it from
     * this.
     */
    public static final EntityDataAccessor<Boolean> NET_OUT = SynchedEntityData.defineId(FishingBoatEntity.class, EntityDataSerializers.BOOLEAN);

    // how many of each upgrade item this hull needs at the dockyard
    private static final Map<ShipUpgrade, Integer> UPGRADE_COSTS = Map.of(
            ShipUpgrade.IRON_SCANTLINGS, 2,
            ShipUpgrade.COTTON_SAILS, 2,
            ShipUpgrade.COPPER_PLATING, 2
    );

    private static final int ORIGINAL_CONTAINER_SIZE = AddonConfig.fishingBoatContainerSize.get();

    /**
     * Client: how far around the boat its net is looked for, in blocks. It
     * arrives where the servers' boat is, and the boat on this side may still
     * be a few blocks behind that.
     */
    private static final double NET_SEARCH_RADIUS = 16.0D;

    /**
     * The live net. The server creates it, see tickNet; the client only ever
     * finds the one it was sent, see collectNet.
     */
    @Nullable private FishingNetEntity fishingNet;

    public FishingBoatEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private FishingBoatEntity(Level level, double d, double e, double f) {
        this(AddonEntityTypes.FISHING_BOAT, level);
        this.setPos(d, e, f);
        this.xo = d;
        this.yo = e;
        this.zo = f;
    }

    // the factory ShipType is registered with - does NOT add the entity to the world
    public static FishingBoatEntity summon(Level level, double d, double e, double f) {
        return new FishingBoatEntity(level, d, e, f);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(NET_OUT, false);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setNetOut(tag.getBoolean("NetOut"));
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("NetOut", this.isNetOut());
    }

    @Override
    public void tick() {
        super.tick();
        // last, after everything in there that may still have moved her
        if (!this.level().isClientSide()) this.tickNet();
    }

    /**
     * Client: carries the net along, on the same path the hull parts take and
     * for the same reason - a client is free to skip an entity tick, see
     * Ship#tickClientHull.
     */
    @Override
    public void tickClientHull() {
        super.tickClientHull();
        this.collectNet();
        if (this.fishingNet != null) this.fishingNet.follow(this);
    }

    @Override
    public void remove(@NotNull RemovalReason removalReason) {
        // the net must never outlive its boat, same rule as for the hull parts.
        // Only the server decides that: on the client the boat may just have
        // left the tracking range
        if (!this.level().isClientSide() && this.fishingNet != null) this.fishingNet.discard();
        this.fishingNet = null;
        super.remove(removalReason);
    }

    @Override
    public Map<ShipUpgrade, Integer> getUpgradeCosts() {
        return UPGRADE_COSTS;
    }

    // defined via SmallShipsConfig#defineAttributes, so the values are synced from the server
    @Override
    public SmallShipsConfig.ShipAttributes getConfiguredAttributes() {
        return AddonConfig.fishingBoatAttributes;
    }

    @Override
    public @NotNull Item getDropItem() {
        // respect the main mods' item drop switch
        if (!SmallShipsConfig.Server.shipGeneralDoItemDrop.get()) return ItemStack.EMPTY.getItem();
        return AddonItems.FISHING_BOAT_ITEMS.get(this.getVariant());
    }

    @Override
    public BiomeModifierType getBiomeModifierType() {
        return AddonConfig.fishingBoatBiome.get();
    }

    /* ---------------- collision parts ---------------- */
    // hitbox parts along the keel: hull(v, y, h, width, height), mast(v, h, thickness, height);
    // v = forward (positive = bow), h = sideways. Masts also define how many sails the ship has.
    private static final List<ShipPartEntity.Definition> PARTS = List.of(
            ShipPartEntity.Definition.hull(-1.75F, 0.0F, 0.0F, 1.75F, 1.25F),//back
            ShipPartEntity.Definition.hull(1.75F, 0.0F, 0.0F, 1.75F, 1.25F),//front
            ShipPartEntity.Definition.mast(0.0F, 0.0F, 0.30F, 10.75F)//mast
    );

    @Override
    public List<ShipPartEntity.Definition> getParts() {
        return PARTS;
    }

    /* ---------------- seats ---------------- */

    // seats: driver/passenger(id, v, y, h) - ids must be unique, y is on top of the deck
    private static final float deck = 0.3F;
    private static final List<ShipSeat> SEATS = List.of(
            ShipSeat.driver(0, -1.50F, deck, 0.0F),
            ShipSeat.passenger(1, -0.5F,deck, 0.0F),
            ShipSeat.passenger(2, 0.5F, deck,0.0F),
            ShipSeat.passenger(3, 1.5F, deck,0.0F),
            ShipSeat.passenger(3, 2.25F, deck,0.0F)
    );

    @Override
    public List<ShipSeat> getSeats() {
        return SEATS;
    }

    /* ---------------- net ---------------- */

    // the box the net fishes in, in the same frame as the parts above:
    // hull(v, y, h, width, height). It hangs astern and below the waterline -
    // tune it to where the model draws the net, F3 + B shows it while it is out
    private static final ShipPartEntity.Definition NET = ShipPartEntity.Definition.hull(0F, -0.50F, -2.0F, 2.5F, 2.5F);

    public boolean isNetOut() {
        return this.getData(NET_OUT);
    }

    public void setNetOut(boolean out) {
        this.setData(NET_OUT, out);
    }

    /**
     * @return whether someone is aboard who works the net: a player, or an
     * entity listed in the fishingBoatNetCrewEntities config - which is how a
     * Workers fisherman counts without this class knowing that mod. Any seat
     * will do, the net is not worked from the helm alone.
     */
    public boolean hasNetCrew() {
        for (Entity passenger : this.getPassengers()) {
            if (passenger instanceof Player) return true;

            String id = EntityType.getKey(passenger.getType()).toString();
            if (AddonConfig.fishingBoatNetCrewEntities.get().contains(id)) return true;
        }
        return false;
    }

    /**
     * Lowers the net or hauls it in. Server side, called by the key packet -
     * and public, so a mod that puts a fisherman aboard can call it as well.
     */
    public void toggleNet() {
        if (this.isSinking() || this.isSunken() || this.isInDockyardWork()) return;

        boolean out = !this.isNetOut();
        // an empty boat does not fish, see tickNet
        if (out && !this.hasNetCrew()) return;

        this.setNetOut(out);
        this.playNetSound(out);
    }

    private void playNetSound(boolean out) {
        if (out) this.playSound(SoundEvents.FISHING_BOBBER_THROW, 1.0F, 0.6F);
        else this.playSound(SoundEvents.FISHING_BOBBER_RETRIEVE, 1.0F, 0.6F);
    }

    /**
     * Server: keeps the net entity in step with NET_OUT and carries it along.
     *
     * The net is never saved, so this also covers a world load - the flag
     * comes back from the save data and the net is simply put out again.
     */
    private void tickNet() {
        // a hull that goes down takes her net with her
        if (this.isNetOut() && (this.isSinking() || this.isSunken())) this.setNetOut(false);

        // nobody aboard who works it: the net comes in, the way the canvas
        // does without a helmsman. Checked every tick instead of only on
        // dismount, because the crew can leave in many ways that never pass
        // through getDismountLocation - death, a teleport, a disconnect or a
        // /kill. A net left out behind an empty boat would fish for nobody.
        if (this.isNetOut() && !this.hasNetCrew()) {
            this.setNetOut(false);
            this.playNetSound(false);
        }

        if (this.fishingNet != null && this.fishingNet.isRemoved()) this.fishingNet = null;

        if (!this.isNetOut()) {
            if (this.fishingNet != null) {
                this.fishingNet.discard();
                this.fishingNet = null;
            }
            return;
        }

        if (this.fishingNet == null) {
            this.fishingNet = new FishingNetEntity(this, NET);
            this.level().addFreshEntity(this.fishingNet);
        }
        this.fishingNet.follow(this);
    }

    /**
     * Client: finds the net the server sent for this boat. Looked for only
     * while it is missing, and only twice a second. Timed by the world clock,
     * the boats' own tick count stands still while its tick is skipped.
     */
    private void collectNet() {
        if (this.fishingNet != null && this.fishingNet.isRemoved()) this.fishingNet = null;
        if (this.fishingNet != null || !this.isNetOut()) return;
        if (this.level().getGameTime() % 10L != 0L) return;

        List<FishingNetEntity> nets = this.level().getEntitiesOfClass(FishingNetEntity.class, this.getBoundingBox().inflate(NET_SEARCH_RADIUS), candidate -> candidate.getParent() == this);
        if (!nets.isEmpty()) this.fishingNet = nets.get(0);
    }

    /* ---------------- Cargo ---------------- */

    /**
     * Stows a stack in the hold: matching stacks are topped up first, what is
     * left takes the free slots. The stack handed in is not touched.
     *
     * @return what did not fit, EMPTY if all of it went in
     */
    public ItemStack addToHold(ItemStack itemStack) {
        ItemStack rest = itemStack.copy();

        for (int i = 0; i < this.getContainerSize() && !rest.isEmpty(); i++) {
            ItemStack slot = this.getItem(i);
            if (slot.isEmpty() || !ItemStack.isSameItemSameTags(slot, rest)) continue;

            int space = Math.min(slot.getMaxStackSize(), this.getMaxStackSize()) - slot.getCount();
            if (space <= 0) continue;

            int amount = Math.min(space, rest.getCount());
            slot.grow(amount);
            rest.shrink(amount);
        }

        for (int i = 0; i < this.getContainerSize() && !rest.isEmpty(); i++) {
            if (!this.getItem(i).isEmpty()) continue;
            this.setItem(i, rest.split(Math.min(rest.getCount(), this.getMaxStackSize())));
        }

        // topping up a stack goes past setItem, and the fill state hangs off this
        this.setChanged();
        return rest;
    }

    /** @return whether there is at least one empty slot left in the hold */
    public boolean hasFreeHoldSlot() {
        for (ItemStack itemStack : this.getItemStacks()) {
            if (itemStack.isEmpty()) return true;
        }
        return false;
    }

    /* ---------------- Leash ---------------- */

    @Override
    public @Nullable Vec3 applyLeashOffset() {
        return new Vec3(0.0, this.getEyeHeight(), this.getBbWidth() * 0.1F);
    }

    /* ---------------- water particles ---------------- */
    @Override
    public void waterSplash() {
        // bow wave particles while the ship is moving
        Vec3 vector3d = this.getViewVector(0.0F);
        float f0 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * 0.55F;
        float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * 0.55F;
        float f2 = 1.9F - this.random.nextFloat() * 0.7F;
        for (int i = 0; i < 2; ++i) {
            this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.4D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.4D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);

            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.7D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.level().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.7D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
        }
    }

    /* ---------------- wind profile ---------------- */
    // speed multipliers for head, side and tail wind
    @Override
    public float getHeadWindMultiplier() {
        return 0.90F;
    }

    @Override
    public float getSideWindMultiplier() {
        return 1.00F;
    }

    @Override
    public float getTailWindMultiplier() {
        return 0.60F;
    }
}

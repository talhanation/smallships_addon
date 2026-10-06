package com.talhanation.smallships_addon.world.entity.ship;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.ShipUpgrade;
import com.talhanation.smallships.world.entity.ship.abilities.Ability;
import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import com.talhanation.smallships.world.entity.ship.abilities.Paddleable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import com.talhanation.smallships_addon.config.AddonConfig;
import com.talhanation.smallships_addon.world.entity.AddonEntityTypes;
import com.talhanation.smallships_addon.world.item.AddonItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
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
 * Rowing Boat - no sail, driven by oars only (Paddleable), so the wind does not matter.
 *
 * A ship class is written exactly like the main mods' own ships: extend Ship or
 * ContainerShip and implement the abilities you want (Sailable, Seatable, ...).
 */
public class RowingBoatEntity extends ContainerShip implements Seatable, Paddleable, Ability, Leashable {
    // registry path of the entity, the items and the dockyard recipe
    public static final String ID = "rowing_boat";

    // how many of each upgrade item this hull needs at the dockyard
    private static final Map<ShipUpgrade, Integer> UPGRADE_COSTS = Map.of(
            ShipUpgrade.IRON_SCANTLINGS, 0,
            ShipUpgrade.COTTON_SAILS, 0,
            ShipUpgrade.COPPER_PLATING, 0
    );

    private static final int ORIGINAL_CONTAINER_SIZE = AddonConfig.rowingBoatContainerSize.get();

    public RowingBoatEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private RowingBoatEntity(Level level, double d, double e, double f) {
        this(AddonEntityTypes.ROWING_BOAT, level);
        this.setPos(d, e, f);
        this.xo = d;
        this.yo = e;
        this.zo = f;
    }

    // the factory ShipType is registered with - does NOT add the entity to the world
    public static RowingBoatEntity summon(Level level, double d, double e, double f) {
        return new RowingBoatEntity(level, d, e, f);
    }

    @Override
    public boolean isEffectedByCargoPenalty() {
        // cargo never slows this boat down
        return false;
    }

    @Override
    public Map<ShipUpgrade, Integer> getUpgradeCosts() {
        return UPGRADE_COSTS;
    }

    // defined via SmallShipsConfig#defineAttributes, so the values are synced from the server
    @Override
    public SmallShipsConfig.ShipAttributes getConfiguredAttributes() {
        return AddonConfig.rowingBoatAttributes;
    }

    @Override
    public @NotNull Item getDropItem() {
        // respect the main mods' item drop switch
        if (!SmallShipsConfig.Server.shipGeneralDoItemDrop.get()) return ItemStack.EMPTY.getItem();
        return AddonItems.ROWING_BOAT_ITEMS.get(this.getVariant());
    }

    @Override
    public BiomeModifierType getBiomeModifierType() {
        return AddonConfig.rowingBoatBiome.get();
    }

    // hitbox parts along the keel: hull(v, y, h, width, height), mast(v, h, thickness, height);
    // v = forward (positive = bow), h = sideways. Masts also define how many sails the ship has.
    private static final List<ShipPartEntity.Definition> PARTS = List.of(
            ShipPartEntity.Definition.hull(-1.5F, 0.0F, 0.0F, 1.5F, 1.25F),//back
            ShipPartEntity.Definition.hull(1.5F, 0.0F, 0.0F, 1.5F, 1.25F)//front
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
            ShipSeat.passenger(3, 1.5F, deck,0.0F)
    );

    @Override
    public List<ShipSeat> getSeats() {
        return SEATS;
    }

    @Override
    public void waterSplash() {
        // bow wave particles while the ship is moving
        Vec3 vector3d = this.getViewVector(0.0F);
        float f0 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * 0.6F;
        float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * 0.6F;
        float f2 = 1.8F - this.random.nextFloat() * 0.7F;
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
        return 1.00F;
    }

    @Override
    public float getSideWindMultiplier() {
        return 1.00F;
    }

    @Override
    public float getTailWindMultiplier() {
        return 1.00F;
    }


    @Override
    public float getOarFactor() {
        // fraction of max speed reached under oars alone, 1.0 = full speed
        return 1.00F;
    }

    @Override
    public @Nullable Vec3 applyLeashOffset() {
        return new Vec3(0.0, this.getEyeHeight(), this.getBbWidth() * 0.1F);
    }
}

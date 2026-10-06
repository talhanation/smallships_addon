package com.talhanation.smallships_addon.world.entity.ship;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.ShipUpgrade;
import com.talhanation.smallships.world.entity.ship.abilities.*;
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
 * Early Caravel - small lateen rigged coaster: good close to the wind, slow downwind.
 *
 * A ship class is written exactly like the main mods' own ships: extend Ship or
 * ContainerShip and implement the abilities you want (Sailable, Seatable, ...).
 */
public class EarlyCaravelEntity extends ContainerShip implements Bannerable, Sailable, Seatable, Ability, Leashable {
    // registry path of the entity, the items and the dockyard recipe
    public static final String ID = "early_caravel";

    // how many of each upgrade item this hull needs at the dockyard
    private static final Map<ShipUpgrade, Integer> UPGRADE_COSTS = Map.of(
            ShipUpgrade.IRON_SCANTLINGS, 2,
            ShipUpgrade.COTTON_SAILS, 2,
            ShipUpgrade.COPPER_PLATING, 2
    );

    private static final int ORIGINAL_CONTAINER_SIZE = AddonConfig.earlyCaravelContainerSize.get();

    public EarlyCaravelEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private EarlyCaravelEntity(Level level, double d, double e, double f) {
        this(AddonEntityTypes.EARLY_CARAVEL, level);
        this.setPos(d, e, f);
        this.xo = d;
        this.yo = e;
        this.zo = f;
    }

    // the factory ShipType is registered with - does NOT add the entity to the world
    public static EarlyCaravelEntity summon(Level level, double d, double e, double f) {
        return new EarlyCaravelEntity(level, d, e, f);
    }

    @Override
    public Map<ShipUpgrade, Integer> getUpgradeCosts() {
        return UPGRADE_COSTS;
    }

    // defined via SmallShipsConfig#defineAttributes, so the values are synced from the server
    @Override
    public SmallShipsConfig.ShipAttributes getConfiguredAttributes() {
        return AddonConfig.earlyCaravelAttributes;
    }

    @Override
    public @NotNull Item getDropItem() {
        // respect the main mods' item drop switch
        if (!SmallShipsConfig.Server.shipGeneralDoItemDrop.get()) return ItemStack.EMPTY.getItem();
        return AddonItems.EARLY_CARAVEL_ITEMS.get(this.getVariant());
    }

    @Override
    public BiomeModifierType getBiomeModifierType() {
        return AddonConfig.earlyCaravelBiome.get();
    }

    /* ---------------- collision parts ---------------- */
    // hitbox parts along the keel: hull(v, y, h, width, height), mast(v, h, thickness, height);
    // v = forward (positive = bow), h = sideways. Masts also define how many sails the ship has.
    private static final List<ShipPartEntity.Definition> PARTS = List.of(
            ShipPartEntity.Definition.hull(-2.0F, 0.0F, 0.0F, 2.0F, 1.25F),//back
            ShipPartEntity.Definition.hull(2.5F, 0.0F, 0.0F, 2.5F, 1.25F),//middle front
            ShipPartEntity.Definition.hull(3.7F, 1.00F, 0.0F, 0.75F, 1.6F),//front tip
            ShipPartEntity.Definition.mast(0.9F, 0.0F, 0.30F, 10.75F)//mast
    );

    @Override
    public List<ShipPartEntity.Definition> getParts() {
        return PARTS;
    }

    /* ---------------- seats ---------------- */

    // seats: driver/passenger(id, v, y, h) - ids must be unique, y is on top of the deck
    private static final float deck = 0.3F;
    private static final List<ShipSeat> SEATS = List.of(
            ShipSeat.driver(0, -2.3F, deck,0.7F),
            ShipSeat.passenger(1, -2.3F,deck, -0.7F),

            ShipSeat.passenger(2, -1.3F, deck,0.7F),
            ShipSeat.passenger(3, -1.3F, deck,-0.7F),

            ShipSeat.passenger(4, 0.3F,deck, 0.7F),
            ShipSeat.passenger(5, 0.3F, deck,-0.7F),

            ShipSeat.passenger(6, 1.3F, deck,0.7F),
            ShipSeat.passenger(7, 1.3F, deck,-0.7F)
    );

    @Override
    public List<ShipSeat> getSeats() {
        return SEATS;
    }

    /* ---------------- Cargo ---------------- */
    @Override
    public boolean isEffectedByCargoPenalty() {
        // cargo never slows this ship down
        return false;
    }

    /* ---------------- Leash ---------------- */

    @Override
    public @Nullable Vec3 applyLeashOffset() {
        return new Vec3(0.0, this.getEyeHeight(), this.getBbWidth() * 0.1F);
    }
    /* ---------------- water partociles ---------------- */
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
        return 1.00F;
    }

    @Override
    public float getSideWindMultiplier() {
        return 1.05F;
    }

    @Override
    public float getTailWindMultiplier() {
        return 0.65F;
    }
}

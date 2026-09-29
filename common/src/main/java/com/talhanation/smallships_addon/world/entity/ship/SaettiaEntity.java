package com.talhanation.smallshipsaddon.world.entity.ship;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.ShipUpgrade;
import com.talhanation.smallships.world.entity.ship.abilities.Ability;
import com.talhanation.smallships.world.entity.ship.abilities.Bannerable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import com.talhanation.smallshipsaddon.config.AddonConfig;
import com.talhanation.smallshipsaddon.world.entity.AddonEntityTypes;
import com.talhanation.smallshipsaddon.world.item.AddonItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Saettia - the small lateen rigged Mediterranean coaster, warm water twin of
 * the {@link CrayerEntity}.
 *
 * Same size, same crew, same cargo, same hull strength - and a completely
 * different ship to sail. Where the Crayer hangs a square sail that wants the
 * wind behind it, the Saettia carries one enormous lateen sail on a short raked
 * mast: she claws to windward where the northern hull cannot go at all, and
 * crawls once the wind gets behind her.
 *
 * That contrast is the point of shipping two example ships rather than one: the
 * two wind profiles sum to exactly the same total, so nothing here is "better",
 * only spent on a different axis.
 */
public class SaettiaEntity extends ContainerShip implements Bannerable, Sailable, Seatable, Ability {
    public static final String ID = "saettia";

    /**
     * Cheap in iron and dear in canvas, the same trade her recipe makes: a
     * frame first Mediterranean hull needs few fastenings, but that one lateen
     * sail is the largest single piece of cloth on any ship this size.
     */
    private static final Map<ShipUpgrade, Integer> UPGRADE_COSTS = Map.of(
            ShipUpgrade.IRON_SCANTLINGS, 2,
            ShipUpgrade.COTTON_SAILS, 2,
            ShipUpgrade.COPPER_PLATING, 2
    );

    private static final int ORIGINAL_CONTAINER_SIZE = AddonConfig.saettiaContainerSize.get();

    public SaettiaEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private SaettiaEntity(Level level, double d, double e, double f) {
        this(AddonEntityTypes.SAETTIA, level);
        this.setPos(d, e, f);
        this.xo = d;
        this.yo = e;
        this.zo = f;
    }

    /**
     * The factory ShipType is registered with. The entity is NOT added to the
     * world here - the dockyard does that, and the build preview reuses this
     * very method for a throwaway client dummy.
     */
    public static SaettiaEntity summon(Level level, double d, double e, double f) {
        return new SaettiaEntity(level, d, e, f);
    }

    @Override
    public Map<ShipUpgrade, Integer> getUpgradeCosts() {
        return UPGRADE_COSTS;
    }

    /**
     * The attribute block lives in the ADDONS own config spec, but it was
     * defined through SmallShipsConfig#defineAttributes, so it travels in the
     * server snapshot like every built-in ship.
     */
    @Override
    public SmallShipsConfig.ShipAttributes getConfiguredAttributes() {
        return AddonConfig.saettiaAttributes;
    }

    @Override
    public @NotNull Item getDropItem() {
        // an addon cannot add to the main mods' config spec, but it should still
        // respect the switches that already exist there
        if (!SmallShipsConfig.Server.shipGeneralDoItemDrop.get()) return ItemStack.EMPTY.getItem();
        return AddonItems.SAETTIA_ITEMS.get(this.getVariant());
    }

    /**
     * WARM, like the Dhow: this hull belongs to the summer Mediterranean and
     * loses nothing there, while the Crayer is indifferent to the water it
     * sails in.
     */
    @Override
    public BiomeModifierType getBiomeModifierType() {
        return AddonConfig.saettiaBiome.get();
    }

    /* ---------------- collision parts ---------------- */

    /**
     * Slimmer and a touch longer than the Crayer for the same cargo: a
     * Mediterranean coaster was built for a tideless sea with real quays, so it
     * had no reason to be beamy enough to sit upright on a beach.
     *
     * The single mast definition is what gives her one sail - mass, collision,
     * preview scale and sail health all come off this same list.
     */
    private static final List<ShipPartEntity.Definition> PARTS = List.of(
            ShipPartEntity.Definition.hull(-1.70F, 0.0F, 0.0F, 1.9F, 1.3F),//back
            ShipPartEntity.Definition.hull(-0.30F, 0.0F, 0.0F, 1.9F, 1.3F),//center back
            ShipPartEntity.Definition.hull(1.10F, 0.0F, 0.0F, 1.8F, 1.3F),//center front
            ShipPartEntity.Definition.hull(2.30F, 0.0F, 0.0F, 1.6F, 1.3F),//front
            ShipPartEntity.Definition.hull(3.10F, 0.55F, 0.0F, 0.7F, 1.1F),//front tip

            ShipPartEntity.Definition.mast(-0.30F, 0.0F, 0.25F, 7.5F)//mast, stepped well forward and raked
    );

    @Override
    public List<ShipPartEntity.Definition> getParts() {
        return PARTS;
    }

    /* ---------------- seats ---------------- */

    /**
     * Four stations, same as the Crayer. No gunner or carriage seats, because
     * this ship carries no guns - the seat types that map to a cannon slot only
     * make sense on a Cannonable hull.
     */
    private static final float deck = 0.3F;
    private static final List<ShipSeat> SEATS = List.of(
            ShipSeat.driver(0, -2.20F, deck, 0.0F),
            ShipSeat.passenger(1, -1.20F, deck, 0.45F),
            ShipSeat.passenger(2, -1.20F, deck, -0.45F),
            ShipSeat.passenger(3, 1.60F, deck, 0.0F)
    );

    @Override
    public List<ShipSeat> getSeats() {
        return SEATS;
    }

    @Override
    public void waterSplash() {
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

    /**
     * The lateen profile, the Caravels' shape scaled down to one sail: a
     * triangular sail set fore and aft can be trimmed to a real angle of
     * attack, so it drives to windward instead of merely being pushed. What it
     * loses is the run before the wind, where a square sail simply bags out and
     * a lateen has to be swung awkwardly across the mast.
     *
     * The three multipliers sum to the same 2.70 as the {@link CrayerEntity}.
     * Neither ship is stronger - the wind axis they spend it on is the whole
     * difference, and that is exactly what these two examples exist to show.
     */
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

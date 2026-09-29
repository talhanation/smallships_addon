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
 * Crayer - the small single masted coastal trader, the entry class below the Cog.
 *
 * The crayer was the workhorse of the medieval North Sea and Channel coast:
 * one mast, one square sail, a crew of four or five, hauling wool, salt, wine
 * and stone between ports that had no harbour to speak of. It was built cheap
 * and sailed hard, the kind of hull a port owned several of and nobody wrote
 * home about. Deliberately the WEAKEST hull in the fleet, and the ship a player
 * uses before they can afford a Cog.
 *
 * That also makes it the simplest possible example of a ship class: the only
 * abilities it carries are the ones every sailing ship needs.
 *
 * A ship class is written exactly the way the main mods' own ships are: extend
 * Ship or ContainerShip, implement the abilities you want, fill in the abstract
 * methods. Nothing here is addon specific except where the attributes come
 * from, see {@link AddonConfig}.
 */
public class CrayerEntity extends ContainerShip implements Bannerable, Sailable, Seatable, Ability {
    public static final String ID = "crayer";

    /**
     * Cheap to improve, because everything it is improving is small - fitting
     * for a hull whose whole point was being affordable. Leaving an upgrade out
     * of the map is what makes it fall back to the default cost, so a new
     * upgrade in the main mod never breaks this ship.
     */
    private static final Map<ShipUpgrade, Integer> UPGRADE_COSTS = Map.of(
            ShipUpgrade.IRON_SCANTLINGS, 2,
            ShipUpgrade.COTTON_SAILS, 1,
            ShipUpgrade.COPPER_PLATING, 2
    );

    private static final int ORIGINAL_CONTAINER_SIZE = AddonConfig.crayerContainerSize.get();

    public CrayerEntity(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level, ORIGINAL_CONTAINER_SIZE);
    }

    private CrayerEntity(Level level, double d, double e, double f) {
        this(AddonEntityTypes.CRAYER, level);
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
    public static CrayerEntity summon(Level level, double d, double e, double f) {
        return new CrayerEntity(level, d, e, f);
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
        return AddonConfig.crayerAttributes;
    }

    @Override
    public @NotNull Item getDropItem() {
        // an addon cannot add to the main mods' config spec, but it should still
        // respect the switches that already exist there
        if (!SmallShipsConfig.Server.shipGeneralDoItemDrop.get()) return ItemStack.EMPTY.getItem();
        return AddonItems.CRAYER_ITEMS.get(this.getVariant());
    }

    @Override
    public BiomeModifierType getBiomeModifierType() {
        return AddonConfig.crayerBiome.get();
    }

    /* ---------------- collision parts ---------------- */

    /**
     * A short, beamy hull and one mast. The crayer was built to take the ground
     * at low tide and load off an open beach, so it is broad and shallow rather
     * than long. Vanilla entity boxes have a SQUARE footprint, so the length of
     * a ship is never one long part but several short ones.
     *
     * The mast definition does double duty: the mass, the collision, the
     * preview scale AND the number of sails all come off this list, so the
     * single mast below is what gives the Crayer its one sail.
     */
    private static final List<ShipPartEntity.Definition> PARTS = List.of(
            ShipPartEntity.Definition.hull(-1.40F, 0.0F, 0.0F, 2.2F, 1.4F),//back
            ShipPartEntity.Definition.hull(0.10F, 0.0F, 0.0F, 2.0F, 1.4F),//center
            ShipPartEntity.Definition.hull(1.50F, 0.0F, 0.0F, 1.8F, 1.4F),//front
            ShipPartEntity.Definition.hull(2.40F, 0.60F, 0.0F, 0.7F, 1.2F),//front tip

            ShipPartEntity.Definition.mast(0.10F, 0.0F, 0.25F, 7.0F)//mast
    );

    @Override
    public List<ShipPartEntity.Definition> getParts() {
        return PARTS;
    }

    /* ---------------- seats ---------------- */

    /**
     * Four stations: helmsman plus three, about the crew a real crayer sailed
     * with. No gunner or carriage seats, because this ship carries no guns -
     * the seat types that map to a cannon slot only make sense on a Cannonable
     * hull.
     */
    private static final float deck = 0.3F;
    private static final List<ShipSeat> SEATS = List.of(
            ShipSeat.driver(0, -1.90F, deck, 0.0F),
            ShipSeat.passenger(1, -0.80F, deck, 0.55F),
            ShipSeat.passenger(2, -0.80F, deck, -0.55F),
            ShipSeat.passenger(3, 1.10F, deck, 0.0F)
    );

    @Override
    public List<ShipSeat> getSeats() {
        return SEATS;
    }

    @Override
    public void waterSplash() {
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

    /**
     * The same shape as the Cog - one square sail that wants the wind behind it -
     * only weaker in every zone. Same rig, less of it: a small sail on a short
     * mast simply catches less, so the Crayer neither suffers as much nor gains
     * as much, and ends up slower than a Cog on every course. Coastal skippers
     * worked the tides rather than the wind for exactly this reason.
     */
    @Override
    public float getHeadWindMultiplier() {
        return 0.25F;
    }

    @Override
    public float getSideWindMultiplier() {
        return 1.05F;
    }

    @Override
    public float getTailWindMultiplier() {
        return 1.40F;
    }
}

package com.talhanation.smallshipsaddon.world.entity.ship;

import com.talhanation.smallships.api.ShipRegistry;
import com.talhanation.smallships.api.ShipType;
import com.talhanation.smallshipsaddon.SmallShipsAddon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

/**
 * THE contact point with the main mod. One register call per ship and they show
 * up in the dockyard - no change inside SmallShips, no patch, no mixin.
 *
 * The recipes below are only the fallbacks. What players actually pay comes
 * from data/smallships_addon/dockyard_recipes/<ship>.json, which pack makers
 * can override like any other data pack file. Keep both in sync when tuning.
 */
public class AddonShipTypes {

    /**
     * Crayer - the cold water entry hull, 150 health, 54 cargo, no guns.
     * Half a Cogs' timber, a third of its iron and barely half its build time,
     * because that is what a crayer was: cheap coastal freight, one small square
     * sail on a short mast, a hull a village boatbuilder could put up on an open
     * beach without a shipyard. This is what a player builds before they can
     * afford a Cog.
     */
    public static final ShipType CRAYER = ShipRegistry.register(ShipType.builder(id(CrayerEntity.ID), CrayerEntity::summon)
            .buildTime(100 * 20)
            .ingredient(ItemTags.PLANKS, 96)
            .ingredient(Items.WHITE_WOOL, 20)
            .ingredient(Items.STRING, 8)
            .ingredient(Items.IRON_NUGGET, 12)
            .build());

    /**
     * Saettia - the warm water entry hull, same size and same price bracket.
     * The same timber and the same build time as the Crayer, but the cost is
     * spent the other way round: a frame first Mediterranean hull is fastened
     * with far less iron than a nailed northern one, while a single lateen sail
     * carries more cloth than a small square rig and its yard demands heavy
     * halyards. Half the iron, over half again the canvas and rope.
     */
    public static final ShipType SAETTIA = ShipRegistry.register(ShipType.builder(id(SaettiaEntity.ID), SaettiaEntity::summon)
            .buildTime(100 * 20)
            .ingredient(ItemTags.PLANKS, 96)
            .ingredient(Items.WHITE_WOOL, 32)
            .ingredient(Items.STRING, 14)
            .ingredient(Items.IRON_NUGGET, 6)
            .build());

    /**
     * Loads this class and with it registers the ship types. Must be called
     * after the configs are loaded, because ShipRegistry reads the dockyard
     * whitelist from them.
     */
    public static void init() {
    }

    private static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsAddon.MOD_ID, path);
    }
}

package com.talhanation.smallships_addon.world.entity.ship;

import com.talhanation.smallships.api.ShipRegistry;
import com.talhanation.smallships.api.ShipType;
import com.talhanation.smallships_addon.SmallShipsAddonMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

/**
 * The contact point with the main mod: one ShipRegistry.register call per ship
 * and it shows up in the dockyard.
 *
 * The recipes below are only fallbacks. What players actually pay comes from
 * data/smallships_addon/dockyard_recipes/<ship>.json, which data packs can
 * override. Keep both in sync.
 */
public class AddonShipTypes {

    public static final ShipType EARLY_COG = ShipRegistry.register(ShipType.builder(id(EarlyCogEntity.ID), EarlyCogEntity::summon)
            .buildTime(100 * 20)
            .ingredient(ItemTags.PLANKS, 78)
            .ingredient(Items.WHITE_WOOL, 24)
            .ingredient(Items.STRING, 8)
            .ingredient(Items.IRON_NUGGET, 9)
            .build());


    public static final ShipType EARLY_CARAVEL = ShipRegistry.register(ShipType.builder(id(EarlyCaravelEntity.ID), EarlyCaravelEntity::summon)
            .buildTime(100 * 20)
            .ingredient(ItemTags.PLANKS, 78)
            .ingredient(Items.WHITE_WOOL, 32)
            .ingredient(Items.STRING, 8)
            .ingredient(Items.IRON_NUGGET, 6)
            .build());

    public static final ShipType ROWING_BOAT = ShipRegistry.register(ShipType.builder(id(RowingBoatEntity.ID), RowingBoatEntity::summon)
            .buildTime(500)
            .ingredient(ItemTags.PLANKS, 24)
            .build());

    public static final ShipType FISHING_BOAT = ShipRegistry.register(ShipType.builder(id(FishingBoatEntity.ID), FishingBoatEntity::summon)
            .buildTime(80 * 20)
            .ingredient(ItemTags.PLANKS, 64)
            .ingredient(Items.WHITE_WOOL, 16)
            .ingredient(Items.STRING, 32)
            .ingredient(Items.IRON_NUGGET, 6)
            .build());

    // loads this class and with it registers the ship types - call after the configs are loaded
    public static void init() {
    }

    private static ResourceLocation id(String path) {
        return new ResourceLocation(SmallShipsAddonMod.MOD_ID, path);
    }
}

package com.talhanation.smallships_addon.world.item;

import com.talhanation.smallships.api.ShipItems;
import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCaravelEntity;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCogEntity;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import com.talhanation.smallships_addon.world.entity.ship.RowingBoatEntity;

/**
 * The ship items of this addon - one line per ship. SmallShips registers one
 * item per wood type under this addons' mod id ({@code smallships_addon:oak_early_cog}
 * and so on), finds them again in Ship#getDropItem and puts them into its
 * creative tab. No item classes, no item register per loader.
 *
 * Has to be called EARLY: from the mod constructor on Forge, in onInitialize on
 * Fabric - see ShipItems. Not from SmallShipsAddonMod#init, which runs on
 * Forge in FMLCommonSetupEvent, when Forge takes no more items.
 *
 * What stays with the addon are the resources: the item models in
 * assets/smallships_addon/models/item and the item names in the lang files.
 */
public class AddonItems {

    public static void register() {
        ShipItems.register(SmallShipsAddonMod.MOD_ID, EarlyCogEntity.ID, EarlyCogEntity::summon);
        ShipItems.register(SmallShipsAddonMod.MOD_ID, EarlyCaravelEntity.ID, EarlyCaravelEntity::summon);
        ShipItems.register(SmallShipsAddonMod.MOD_ID, RowingBoatEntity.ID, RowingBoatEntity::summon);
        ShipItems.register(SmallShipsAddonMod.MOD_ID, FishingBoatEntity.ID, FishingBoatEntity::summon);
    }
}

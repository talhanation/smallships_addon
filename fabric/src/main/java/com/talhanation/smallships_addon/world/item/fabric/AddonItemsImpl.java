package com.talhanation.smallships_addon.world.item.fabric;

import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCogEntity;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import com.talhanation.smallships_addon.world.entity.ship.RowingBoatEntity;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCaravelEntity;
import com.talhanation.smallships_addon.world.item.AddonItems;
import com.talhanation.smallships_addon.world.item.EarlyCogItem;
import com.talhanation.smallships_addon.world.item.FishingBoatItem;
import com.talhanation.smallships_addon.world.item.RowingBoatItem;
import com.talhanation.smallships_addon.world.item.EarlyCaravelItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ExpectPlatform target for AddonItems#getItem.
 *
 * The ship items are added to a VANILLA creative tab. An addon must not try to
 * write into the main mods' own tab - that tab is built from the smallships
 * namespace only.
 */
public class AddonItemsImpl {
    private static final Map<String, Item> entries = new HashMap<>();

    public static Item getItem(String id) {
        return entries.get(id);
    }

    static {
        for (Boat.Type type : Boat.Type.values()) {
            register(AddonItems.itemId(type, EarlyCogEntity.ID), new EarlyCogItem(type, new Item.Properties().stacksTo(1)));
            register(AddonItems.itemId(type, EarlyCaravelEntity.ID), new EarlyCaravelItem(type, new Item.Properties().stacksTo(1)));
            register(AddonItems.itemId(type, RowingBoatEntity.ID), new RowingBoatItem(type, new Item.Properties().stacksTo(1)));
            register(AddonItems.itemId(type, FishingBoatEntity.ID), new FishingBoatItem(type, new Item.Properties().stacksTo(1)));
        }

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            List<ItemStack> shipItems = new ArrayList<>();
            for (Boat.Type type : Boat.Type.values()) {
                shipItems.add(new ItemStack(getItem(AddonItems.itemId(type, EarlyCogEntity.ID))));
                shipItems.add(new ItemStack(getItem(AddonItems.itemId(type, EarlyCaravelEntity.ID))));
                shipItems.add(new ItemStack(getItem(AddonItems.itemId(type, RowingBoatEntity.ID))));
                shipItems.add(new ItemStack(getItem(AddonItems.itemId(type, FishingBoatEntity.ID))));
            }
            output.acceptAll(shipItems);
        });
    }

    private static void register(String id, Item item) {
        entries.put(id, Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(SmallShipsAddonMod.MOD_ID, id), item));
    }
}

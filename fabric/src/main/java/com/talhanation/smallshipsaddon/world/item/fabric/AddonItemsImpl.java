package com.talhanation.smallshipsaddon.world.item.fabric;

import com.talhanation.smallshipsaddon.SmallShipsAddon;
import com.talhanation.smallshipsaddon.world.entity.ship.CrayerEntity;
import com.talhanation.smallshipsaddon.world.entity.ship.SaettiaEntity;
import com.talhanation.smallshipsaddon.world.item.AddonItems;
import com.talhanation.smallshipsaddon.world.item.CrayerItem;
import com.talhanation.smallshipsaddon.world.item.SaettiaItem;
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
            register(AddonItems.itemId(type, CrayerEntity.ID), new CrayerItem(type, new Item.Properties().stacksTo(1)));
            register(AddonItems.itemId(type, SaettiaEntity.ID), new SaettiaItem(type, new Item.Properties().stacksTo(1)));
        }

        // read through getItem, NOT through AddonItems: that class is still
        // running its own static block when this one is loaded from it
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            List<ItemStack> shipItems = new ArrayList<>();
            for (Boat.Type type : Boat.Type.values()) {
                shipItems.add(new ItemStack(getItem(AddonItems.itemId(type, CrayerEntity.ID))));
                shipItems.add(new ItemStack(getItem(AddonItems.itemId(type, SaettiaEntity.ID))));
            }
            output.acceptAll(shipItems);
        });
    }

    private static void register(String id, Item item) {
        entries.put(id, Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(SmallShipsAddon.MOD_ID, id), item));
    }
}

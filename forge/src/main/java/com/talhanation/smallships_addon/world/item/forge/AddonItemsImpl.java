package com.talhanation.smallships_addon.world.item.forge;

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
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @ExpectPlatform target for AddonItems#getItem.
 *
 * The ship items are added to a VANILLA creative tab. An addon must not try to
 * write into the main mods' own tab - that tab is built from the smallships
 * namespace only.
 */
@Mod.EventBusSubscriber(modid = SmallShipsAddonMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddonItemsImpl {
    private static final Map<String, RegistryObject<Item>> entries = new HashMap<>();

    public static Item getItem(String id) {
        return entries.get(id).get();
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SmallShipsAddonMod.MOD_ID);

    static {
        for (Boat.Type type : Boat.Type.values()) {
            register(AddonItems.itemId(type, EarlyCogEntity.ID), () -> new EarlyCogItem(type, new Item.Properties().stacksTo(1)));
            register(AddonItems.itemId(type, EarlyCaravelEntity.ID), () -> new EarlyCaravelItem(type, new Item.Properties().stacksTo(1)));
            register(AddonItems.itemId(type, RowingBoatEntity.ID), () -> new RowingBoatItem(type, new Item.Properties().stacksTo(1)));
            register(AddonItems.itemId(type, FishingBoatEntity.ID), () -> new FishingBoatItem(type, new Item.Properties().stacksTo(1)));
        }
    }

    private static void register(String id, Supplier<Item> itemSupplier) {
        entries.put(id, ITEMS.register(id, itemSupplier));
    }

    @SubscribeEvent
    public static void onBuildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() != CreativeModeTabs.TOOLS_AND_UTILITIES) return;
        for (Boat.Type type : Boat.Type.values()) {
            event.accept(getItem(AddonItems.itemId(type, EarlyCogEntity.ID)));
            event.accept(getItem(AddonItems.itemId(type, EarlyCaravelEntity.ID)));
            event.accept(getItem(AddonItems.itemId(type, RowingBoatEntity.ID)));
            event.accept(getItem(AddonItems.itemId(type, FishingBoatEntity.ID)));
        }
    }
}

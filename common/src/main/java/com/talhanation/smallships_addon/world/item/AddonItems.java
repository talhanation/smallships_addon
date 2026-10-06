package com.talhanation.smallships_addon.world.item;

import com.talhanation.smallships_addon.world.entity.ship.EarlyCogEntity;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import com.talhanation.smallships_addon.world.entity.ship.RowingBoatEntity;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCaravelEntity;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * One ship item per wood type and ship, like the main mods' ModItems.
 * The maps are what the ships hand back in getDropItem.
 */
public class AddonItems {

    public static final Map<Boat.Type, Item> EARLY_COG_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> EARLY_CARAVEL_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> ROWING_BOAT_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> FISHING_BOAT_ITEMS = new HashMap<>(Boat.Type.values().length);

    // filled here and not in a static block: the items do not exist yet when this class loads
    public static void init() {
        for (Boat.Type type : Boat.Type.values()) {
            EARLY_COG_ITEMS.put(type, getItem(itemId(type, EarlyCogEntity.ID)));
            EARLY_CARAVEL_ITEMS.put(type, getItem(itemId(type, EarlyCaravelEntity.ID)));
            ROWING_BOAT_ITEMS.put(type, getItem(itemId(type, RowingBoatEntity.ID)));
            FISHING_BOAT_ITEMS.put(type, getItem(itemId(type, FishingBoatEntity.ID)));
        }
    }

    /** Registry name of a ship item, e.g. {@code dark_oak_early_cog}. */
    public static String itemId(Boat.Type type, String shipId) {
        return type.getName().replaceAll("[^a-z0-9_.-]", "_") + "_" + shipId;
    }

    // implemented per loader in world/item/forge and world/item/fabric
    @ExpectPlatform
    public static Item getItem(String id) {
        throw new AssertionError();
    }
}

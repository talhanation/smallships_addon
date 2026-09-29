package com.talhanation.smallshipsaddon.world.item;

import com.talhanation.smallshipsaddon.world.entity.ship.CrayerEntity;
import com.talhanation.smallshipsaddon.world.entity.ship.SaettiaEntity;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Items of this addon: one ship item per wood variant and ship, exactly like
 * the main mods' ModItems. The maps are what the ships' getDropItem hands back.
 */
public class AddonItems {

    public static final Map<Boat.Type, Item> CRAYER_ITEMS = new HashMap<>(Boat.Type.values().length);
    public static final Map<Boat.Type, Item> SAETTIA_ITEMS = new HashMap<>(Boat.Type.values().length);

    static {
        for (Boat.Type type : Boat.Type.values()) {
            CRAYER_ITEMS.put(type, getItem(itemId(type, CrayerEntity.ID)));
            SAETTIA_ITEMS.put(type, getItem(itemId(type, SaettiaEntity.ID)));
        }
    }

    public static void init() {
    }

    /** The registry name of a ship item, e.g. {@code dark_oak_crayer}. */
    public static String itemId(Boat.Type type, String shipId) {
        return type.getName().replaceAll("[^a-z0-9_.-]", "_") + "_" + shipId;
    }

    @ExpectPlatform
    public static Item getItem(String id) {
        throw new AssertionError();
    }
}

package com.talhanation.smallships_addon;

import com.talhanation.smallships_addon.config.AddonConfig;
import com.talhanation.smallships_addon.network.AddonPackets;
import com.talhanation.smallships_addon.world.entity.AddonEntityTypes;
import com.talhanation.smallships_addon.world.entity.ship.AddonShipTypes;
import com.talhanation.smallships_addon.world.item.AddonItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example addon for SmallShips: three ships added purely through the SmallShips
 * API, without a single change inside the main mod. Copy this project, rename
 * MOD_ID and the packages, and replace the ships with your own.
 */
public class SmallShipsAddonMod {
    public static final String MOD_ID = "smallships_addon";
    public static final Logger LOGGER = LoggerFactory.getLogger(SmallShipsAddonMod.MOD_ID);
    public SmallShipsAddonMod() {
        // the config spec has to exist before anything reads a value from it
        AddonConfig.register();
    }

    /**
     * Shared init, called from both loader entry points once the configs are
     * loaded. Order matters: entity types, then items, then the ship types that
     * reference both. The packets depend on none of them.
     */
    public static void init() {
        AddonPackets.registerPackets();
        AddonEntityTypes.init();
        AddonItems.init();
        AddonShipTypes.init();
    }
}

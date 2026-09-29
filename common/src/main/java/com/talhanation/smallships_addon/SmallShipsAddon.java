package com.talhanation.smallshipsaddon;

import com.talhanation.smallshipsaddon.config.AddonConfig;
import com.talhanation.smallshipsaddon.world.entity.AddonEntityTypes;
import com.talhanation.smallshipsaddon.world.entity.ship.AddonShipTypes;
import com.talhanation.smallshipsaddon.world.item.AddonItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Reference addon for SmallShips: adds a single ship, the Crayer, without a
 * single change inside the main mod.
 *
 * The main mod only ever sees this addon through three entry points:
 * ShipRegistry for the ship itself and its dockyard recipe, ShipRenderRegistry
 * for the sail and banner layers on the client, and SmallShipsConfig
 * #defineAttributes so the ships' attributes travel in the server snapshot.
 * Everything else - entity type, item, renderer, model, textures - is
 * registered by the addon itself, the same way any mod registers its own
 * content.
 *
 * Copy this module, rename MOD_ID and the package, and replace the Crayer.
 */
public class SmallShipsAddon {
    public static final String MOD_ID = "smallships_addon";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public SmallShipsAddon() {
        // the spec has to be registered before anything reads a value from it
        AddonConfig.register();
    }

    /**
     * Shared init, called from both loader entry points AFTER the entity types
     * and items exist AND after the configs are loaded. CrayerEntity reads its
     * container size in a static field and ShipRegistry reads the dockyard
     * whitelist, so the order matters.
     */
    public static void init() {
        AddonEntityTypes.init();
        AddonItems.init();
        AddonShipTypes.init();
    }
}

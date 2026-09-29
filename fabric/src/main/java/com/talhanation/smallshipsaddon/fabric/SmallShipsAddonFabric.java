package com.talhanation.smallshipsaddon.fabric;

import com.talhanation.smallshipsaddon.SmallShipsAddon;
import net.fabricmc.api.ModInitializer;

/**
 * Fabric entry point.
 *
 * Fabric loads the configs before onInitialize runs, so everything can be
 * registered right here in order - no enqueueWork, no deferred registry. The
 * constructor registers the addons' own config spec, init() then registers
 * entity types, items and finally the ship type.
 */
public class SmallShipsAddonFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        new SmallShipsAddon();
        SmallShipsAddon.init();
    }
}

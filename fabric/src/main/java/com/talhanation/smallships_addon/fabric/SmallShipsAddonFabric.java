package com.talhanation.smallships_addon.fabric;

import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.network.fabric.AddonPacketsImpl;
import com.talhanation.smallships_addon.world.item.AddonItems;

import com.talhanation.smallships_addon.update.UpdateChecker;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

/**
 * Fabric entry point.
 *
 * Fabric loads the configs before onInitialize runs, so everything can be
 * registered right here in order - no enqueueWork, no deferred registry. The
 * constructor registers the addons' own config spec, the ship items go through
 * SmallShips, init() then registers entity types and finally the ship types.
 */
public class SmallShipsAddonFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        new SmallShipsAddonMod();
        AddonItems.register();
        SmallShipsAddonMod.init();
        // after init: the packets are only known once AddonPackets#registerPackets ran
        AddonPacketsImpl.registerServerReceivers();

        // update check: the server config is only loaded once the server is up
        ServerLifecycleEvents.SERVER_STARTED.register(server -> UpdateChecker.onServerStarted());
    }
}

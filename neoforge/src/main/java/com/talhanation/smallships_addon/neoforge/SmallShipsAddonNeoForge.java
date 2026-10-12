package com.talhanation.smallships_addon.neoforge;

import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.neoforge.events.UpdateEvents;
import com.talhanation.smallships_addon.network.neoforge.AddonPacketsImpl;
import com.talhanation.smallships_addon.world.entity.neoforge.AddonEntityTypesImpl;
import com.talhanation.smallships_addon.world.item.AddonItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

/**
 * NeoForge entry point.
 *
 * Two phases, and the split matters:
 *
 * The CONSTRUCTOR registers the addons' own config spec - NeoForge only accepts
 * a spec while a mod is being constructed, so this cannot wait.
 *
 * The SHIP TYPES go into FMLCommonSetupEvent#enqueueWork: NeoForge dispatches mod
 * construction in parallel and the configs are not loaded yet at that point.
 * ShipRegistry reads the dockyard whitelist and EarlyCogEntity reads its container
 * size, so registering too early would read defaults.
 *
 * The client side hooks itself in: ClientModBus and ClientGameBus are event bus
 * subscribers for the client dist only.
 */
@Mod(SmallShipsAddonMod.MOD_ID)
public class SmallShipsAddonNeoForge {

    public SmallShipsAddonNeoForge(IEventBus modBus) {
        AddonEntityTypesImpl.ENTITY_TYPES.register(modBus);
        // the ship items go through SmallShips, and only take them here in the
        // constructor - see AddonItems
        AddonItems.register();

        modBus.addListener(this::commonSetup);
        modBus.addListener(AddonPacketsImpl::registerPayloadHandlers);

        NeoForge.EVENT_BUS.register(new UpdateEvents());

        new SmallShipsAddonMod();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(SmallShipsAddonMod::init);
    }
}

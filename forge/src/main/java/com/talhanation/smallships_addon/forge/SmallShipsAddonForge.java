package com.talhanation.smallships_addon.forge;

import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.forge.client.ClientModBus;
import com.talhanation.smallships_addon.forge.events.UpdateEvents;
import com.talhanation.smallships_addon.world.entity.forge.AddonEntityTypesImpl;
import com.talhanation.smallships_addon.world.item.forge.AddonItemsImpl;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Forge entry point.
 *
 * Two phases, and the split matters:
 *
 * The CONSTRUCTOR registers the addons' own config spec - Forge only accepts a
 * spec while a mod is being constructed, so this cannot wait.
 *
 * The SHIP TYPES go into FMLCommonSetupEvent#enqueueWork: Forge dispatches mod
 * construction in parallel and the configs are not loaded yet at that point.
 * ShipRegistry reads the dockyard whitelist and EarlyCogEntity reads its container
 * size, so registering too early would read defaults.
 */
@Mod(SmallShipsAddonMod.MOD_ID)
public class SmallShipsAddonForge {

    public SmallShipsAddonForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        AddonEntityTypesImpl.ENTITY_TYPES.register(modBus);
        AddonItemsImpl.ITEMS.register(modBus);

        modBus.addListener(this::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modBus.register(new ClientModBus()));

        MinecraftForge.EVENT_BUS.register(new UpdateEvents());

        new SmallShipsAddonMod();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(SmallShipsAddonMod::init);
    }
}

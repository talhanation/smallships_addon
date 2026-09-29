package com.talhanation.smallshipsaddon.forge;

import com.talhanation.smallshipsaddon.SmallShipsAddon;
import com.talhanation.smallshipsaddon.forge.client.ClientModBus;
import com.talhanation.smallshipsaddon.world.entity.forge.AddonEntityTypesImpl;
import com.talhanation.smallshipsaddon.world.item.forge.AddonItemsImpl;
import net.minecraftforge.api.distmarker.Dist;
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
 * ShipRegistry reads the dockyard whitelist and CrayerEntity reads its container
 * size, so registering too early would read defaults.
 */
@Mod(SmallShipsAddon.MOD_ID)
public class SmallShipsAddonForge {

    public SmallShipsAddonForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        AddonEntityTypesImpl.ENTITY_TYPES.register(modBus);
        AddonItemsImpl.ITEMS.register(modBus);

        modBus.addListener(this::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modBus.register(new ClientModBus()));

        new SmallShipsAddon();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(SmallShipsAddon::init);
    }
}

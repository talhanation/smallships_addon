package com.talhanation.smallships_addon.forge.client;

import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.client.UpdateNotifier;
import com.talhanation.smallships_addon.client.option.AddonKeyEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = SmallShipsAddonMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeBus {
    @SubscribeEvent
    static void initRegisterInputEvents(InputEvent.Key event) {
        AddonKeyEvent.onKeyInput(Minecraft.getInstance());
    }

    @SubscribeEvent
    static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        UpdateNotifier.tick(Minecraft.getInstance());
    }
}

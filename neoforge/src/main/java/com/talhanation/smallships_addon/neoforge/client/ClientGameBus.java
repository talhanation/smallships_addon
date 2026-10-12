package com.talhanation.smallships_addon.neoforge.client;

import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.client.UpdateNotifier;
import com.talhanation.smallships_addon.client.option.AddonKeyEvent;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = SmallShipsAddonMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ClientGameBus {
    @SubscribeEvent
    static void initRegisterInputEvents(InputEvent.Key event) {
        AddonKeyEvent.onKeyInput(Minecraft.getInstance());
    }

    @SubscribeEvent
    static void onClientTick(ClientTickEvent.Post event) {
        UpdateNotifier.tick(Minecraft.getInstance());
    }
}

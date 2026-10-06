package com.talhanation.smallships_addon.network;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.network.packet.ServerboundToggleFishingNetPacket;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;

/**
 * The addons' own packets, on the addons' own channel.
 *
 * An addon can NOT hang its packets onto the main mods' channel: forge numbers
 * the messages of a channel in registration order and puts that index on the
 * wire, so a packet squeezed in from outside would depend on which mod happens
 * to register first - on the client AND on the server. The packets themselves
 * are still plain {@link ModPacket}s, written exactly like the main mods' own.
 *
 * Serverbound only so far. A packet to the client needs the client side detour
 * the main mods' ModPacketsImpl takes, see there.
 */
public class AddonPackets {
    public static void registerPackets() {
        registerPacket(ServerboundToggleFishingNetPacket.ID, ServerboundToggleFishingNetPacket.class, ServerboundToggleFishingNetPacket::read);
    }

    /**
     * Append new packets at the end of the list above, the order is part of
     * the protocol on forge.
     *
     * @param type the CONCRETE packet class. Forge looks its codec up by
     *             message.getClass(); fabric addresses packets by id and ignores it.
     */
    // implemented per loader in network/forge and network/fabric
    @ExpectPlatform
    public static void registerPacket(ResourceLocation id, Class<? extends ModPacket> type, ModPacket.Reader reader) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void clientSendPacket(ModPacket packet) {
        throw new AssertionError();
    }

    public static ResourceLocation id(String id) {
        return new ResourceLocation(SmallShipsAddonMod.MOD_ID, id);
    }
}

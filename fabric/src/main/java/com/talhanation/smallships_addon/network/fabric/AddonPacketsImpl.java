package com.talhanation.smallships_addon.network.fabric;

import com.talhanation.smallships.network.ModPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.resources.ResourceLocation;

/**
 * @ExpectPlatform target for AddonPackets. Built like the main mods'
 * ModPacketsImpl, but the receiver is registered right away: fabric addresses
 * a packet by its channel id, so nothing has to be collected first.
 */
@SuppressWarnings("unused")
public class AddonPacketsImpl {

    /** The packet class is ignored here, only forge needs it for its own message table. */
    public static void registerPacket(ResourceLocation id, Class<? extends ModPacket> type, ModPacket.Reader reader) {
        ServerPlayNetworking.registerGlobalReceiver(id, (server, player, handler, buf, responseSender) -> {
            // the buffer is only valid on the network thread, so it has to be
            // read out here - only the finished packet crosses over to the
            // main thread
            ModPacket packet = reader.read(buf);
            server.execute(() -> packet.handler(player));
        });
    }

    @Environment(EnvType.CLIENT)
    public static void clientSendPacket(ModPacket packet) {
        AddonPacketsClientHelper.clientSendPacket(packet);
    }
}

package com.talhanation.smallships_addon.network.forge;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships_addon.network.AddonPackets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

/**
 * @ExpectPlatform target for AddonPackets. Built like the main mods'
 * ModPacketsImpl, on a channel of the addons' own.
 */
public class AddonPacketsImpl {
    private static final String PROTOCOL_VERSION = "1";

    /** forge numbers its messages, one index per registered packet class */
    private static int index;

    static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            AddonPackets.id("channel"),
            () -> PROTOCOL_VERSION,
            NetworkRegistry.acceptMissingOr(PROTOCOL_VERSION),
            NetworkRegistry.acceptMissingOr(PROTOCOL_VERSION));

    /**
     * ONE registration per packet class, forge looks the codec up with
     * message.getClass(). The packet id never goes on the wire here, unlike on
     * fabric: forge already identifies the message by its index.
     */
    public static void registerPacket(ResourceLocation id, Class<? extends ModPacket> type, ModPacket.Reader reader) {
        registerTyped(type, reader);
    }

    @SuppressWarnings("unchecked")
    private static <T extends ModPacket> void registerTyped(Class<? extends ModPacket> type, ModPacket.Reader reader) {
        CHANNEL.registerMessage(index++, (Class<T>) type,
                (packet, buf) -> packet.write(buf),
                buf -> (T) reader.read(buf),
                (packet, contextSupplier) -> {
                    NetworkEvent.Context context = contextSupplier.get();
                    context.enqueueWork(() -> {
                        // getSender is null on the client, which is exactly
                        // how a spoofed serverbound packet arrives there
                        ServerPlayer sender = context.getSender();
                        if (sender != null) packet.handler(sender);
                    });
                    context.setPacketHandled(true);
                });
    }

    public static void clientSendPacket(ModPacket packet) {
        CHANNEL.sendToServer(packet);
    }
}

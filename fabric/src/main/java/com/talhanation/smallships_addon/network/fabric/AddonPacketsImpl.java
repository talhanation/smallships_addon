package com.talhanation.smallships_addon.network.fabric;

import com.talhanation.smallships.network.ModPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @ExpectPlatform target for AddonPackets. Built like the main mods'
 * ModPacketsImpl: the payload types are registered right away, the receivers
 * once all packets are known - the server ones from the main entry point, the
 * client ones from the client entry point.
 */
@SuppressWarnings("unused")
public class AddonPacketsImpl {
    private static final List<CustomPacketPayload.Type<ModPacket>> clientReceivers = new ArrayList<>();
    private static final List<CustomPacketPayload.Type<ModPacket>> serverReceivers = new ArrayList<>();

    public static void registerPacket(CustomPacketPayload.Type<ModPacket> type, StreamCodec<RegistryFriendlyByteBuf, ModPacket> codec, ModPacket.Side side) {
        switch (side) {
            case CLIENTBOUND -> {
                PayloadTypeRegistry.playS2C().register(type, codec);

                clientReceivers.add(type);
            }
            case SERVERBOUND -> {
                PayloadTypeRegistry.playC2S().register(type, codec);

                serverReceivers.add(type);
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static void registerClientReceivers() {
        AddonPacketsClientHelper.registerClientReceivers(clientReceivers);
    }

    public static void registerServerReceivers() {
        for (CustomPacketPayload.Type<ModPacket> type : serverReceivers) {
            // fabric runs the handler on the server thread already
            ServerPlayNetworking.registerGlobalReceiver(type, (packet, context) -> {
                Player player = context.player();
                packet.handler(player);
            });
        }
    }

    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        ServerPlayNetworking.send(player, packet);
    }

    @Environment(EnvType.CLIENT)
    public static void clientSendPacket(ModPacket packet) {
        AddonPacketsClientHelper.clientSendPacket(packet);
    }
}

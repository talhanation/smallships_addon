package com.talhanation.smallships_addon.network.neoforge;

import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.network.ModPacket;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import java.util.ArrayList;
import java.util.List;

/**
 * @ExpectPlatform target for AddonPackets. Built like the main mods'
 * ModPacketsImpl: registerPacket only collects, the payloads are handed to
 * NeoForge in RegisterPayloadHandlersEvent on the addons' own mod bus.
 */
public class AddonPacketsImpl {
    private static final String PROTOCOL_VERSION = "1";

    private static final List<Pair<CustomPacketPayload.Type<ModPacket>, StreamCodec<RegistryFriendlyByteBuf, ModPacket>>> serverboundPackets = new ArrayList<>();
    private static final List<Pair<CustomPacketPayload.Type<ModPacket>, StreamCodec<RegistryFriendlyByteBuf, ModPacket>>> clientboundPackets = new ArrayList<>();

    public static void registerPacket(CustomPacketPayload.Type<ModPacket> type, StreamCodec<RegistryFriendlyByteBuf, ModPacket> codec, ModPacket.Side side) {
        switch (side) {
            case CLIENTBOUND -> clientboundPackets.add(new Pair<>(type, codec));
            case SERVERBOUND -> serverboundPackets.add(new Pair<>(type, codec));
        }
    }

    public static void registerPayloadHandlers(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(PROTOCOL_VERSION);

        for (Pair<CustomPacketPayload.Type<ModPacket>, StreamCodec<RegistryFriendlyByteBuf, ModPacket>> packet : serverboundPackets) {
            registrar.playToServer(packet.getFirst(), packet.getSecond(), (ModPacket payload, IPayloadContext context) -> payload.handler(context.player()));
        }

        for (Pair<CustomPacketPayload.Type<ModPacket>, StreamCodec<RegistryFriendlyByteBuf, ModPacket>> packet : clientboundPackets) {
            registrar.playToClient(packet.getFirst(), packet.getSecond(), (ModPacket payload, IPayloadContext context) -> payload.handler(context.player()));
        }
    }

    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        PacketDistributor.sendToPlayer(player, packet);
    }

    public static void clientSendPacket(ModPacket packet) {
        PacketDistributor.sendToServer(packet);
    }
}

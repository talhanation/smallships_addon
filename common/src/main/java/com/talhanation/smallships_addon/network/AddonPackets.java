package com.talhanation.smallships_addon.network;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.network.packet.ServerboundToggleFishingNetPacket;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

/**
 * The addons' own packets, under the addons' own mod id.
 *
 * Registered on their own and not through the main mods' ModPackets: neoforge
 * collects the payloads per mod and hands each mod its own registrar, so the
 * main mod only ever registers its own list. The packets themselves are still
 * plain {@link ModPacket}s, written exactly like the main mods' own - a TYPE
 * and a CODEC each.
 */
public class AddonPackets {
    public static void registerPackets() {
        registerNonPacket(ServerboundToggleFishingNetPacket.TYPE, ServerboundToggleFishingNetPacket.CODEC, ModPacket.Side.SERVERBOUND);
    }

    @SuppressWarnings("unchecked")
    private static <T extends ModPacket> void registerNonPacket(CustomPacketPayload.Type<T> type, StreamCodec<RegistryFriendlyByteBuf, T> codec, ModPacket.Side side) {
        registerPacket((CustomPacketPayload.Type<ModPacket>) type, (StreamCodec<RegistryFriendlyByteBuf, ModPacket>) codec, side);
    }

    // implemented per loader in network/neoforge and network/fabric
    @ExpectPlatform
    public static void registerPacket(CustomPacketPayload.Type<ModPacket> type, StreamCodec<RegistryFriendlyByteBuf, ModPacket> codec, ModPacket.Side side) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void clientSendPacket(ModPacket packet) {
        throw new AssertionError();
    }

    public static ResourceLocation id(String id) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsAddonMod.MOD_ID, id);
    }
}

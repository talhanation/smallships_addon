package com.talhanation.smallships_addon.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships_addon.network.AddonPackets;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public record ServerboundToggleFishingNetPacket() implements ModPacket {
    public static final Type<ServerboundToggleFishingNetPacket> TYPE = new Type<>(AddonPackets.id("server_toggle_fishing_net"));

    /** Carries nothing - the press itself is the whole message. */
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundToggleFishingNetPacket> CODEC = StreamCodec.unit(new ServerboundToggleFishingNetPacket());

    @Override
    public @NotNull Type<ServerboundToggleFishingNetPacket> type() {
        return TYPE;
    }

    /**
     * Checked again on the server: the boat is taken from where the sender
     * really sits, and only the helm works the net - the same rule the client
     * applies before it sends, which a modified client would not.
     */
    @Override
    public void handler(Player player) {
        if (player.getVehicle() instanceof FishingBoatEntity fishingBoat && player.equals(fishingBoat.getDriverAnySide())) {
            fishingBoat.toggleNet();
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}

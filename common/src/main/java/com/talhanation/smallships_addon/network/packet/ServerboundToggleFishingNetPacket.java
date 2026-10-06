package com.talhanation.smallships_addon.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships_addon.network.AddonPackets;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public record ServerboundToggleFishingNetPacket() implements ModPacket {
    public static final ResourceLocation ID = AddonPackets.id("server_toggle_fishing_net");

    public static ServerboundToggleFishingNetPacket read(FriendlyByteBuf buf) {
        return new ServerboundToggleFishingNetPacket();
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    /** Carries nothing - the press itself is the whole message. */
    @Override
    public void write(FriendlyByteBuf buf) {
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

package com.talhanation.smallships_addon.client.option;

import com.talhanation.smallships_addon.network.AddonPackets;
import com.talhanation.smallships_addon.network.packet.ServerboundToggleFishingNetPacket;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

/**
 * Reads the addons' keys, hooked from the platform specific events the main
 * mod uses for its own (Forge: InputEvent.Key, Fabric: END_CLIENT_TICK).
 *
 * The client only ever ASKS: the net is switched on the server and comes back
 * as synched entity data, so every player around sees the same net.
 */
public class AddonKeyEvent {

    public static void onKeyInput(Minecraft client) {
        Player player = client.player;
        if (player == null) return;
        boolean pressedNetKey = AddonGameOptions.NET_KEY.consumeClick();

        if (player.getVehicle() instanceof FishingBoatEntity fishingBoat) {
            if (player.equals(fishingBoat.getDriver())) { // is driver
                if (pressedNetKey) {
                    AddonPackets.clientSendPacket(new ServerboundToggleFishingNetPacket());
                }
            }
        }
    }
}

package com.talhanation.smallships_addon.update.fabric;

import com.talhanation.smallships_addon.SmallShipsAddonMod;
import net.fabricmc.loader.api.FabricLoader;

public class UpdateCheckerImpl {
    public static String getModVersion() {
        return FabricLoader.getInstance().getModContainer(SmallShipsAddonMod.MOD_ID)
                .map(container -> container.getMetadata().getVersion().getFriendlyString())
                .orElse("0");
    }
}

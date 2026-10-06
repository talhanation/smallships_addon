package com.talhanation.smallships_addon.update.forge;

import com.talhanation.smallships_addon.SmallShipsAddonMod;
import net.minecraftforge.fml.ModList;

public class UpdateCheckerImpl {
    public static String getModVersion() {
        return ModList.get().getModContainerById(SmallShipsAddonMod.MOD_ID)
                .map(container -> container.getModInfo().getVersion().toString())
                .orElse("0");
    }
}

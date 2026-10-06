package com.talhanation.smallships_addon.client.option;

import com.talhanation.smallships.client.option.ModGameOptions;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

/**
 * Key mappings of this addon. They are registered in the loader modules
 * (forge ClientModBus / fabric client entry point) and read in AddonKeyEvent.
 */
public class AddonGameOptions {
    // the main mods' category on purpose, so every ship key sits in one block of the controls screen
    public static final KeyMapping NET_KEY = new KeyMapping("key.smallships_addon.fishing_net", GLFW.GLFW_KEY_N, ModGameOptions.keyMappingCategory);
}

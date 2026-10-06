package com.talhanation.smallships_addon.client;

import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.config.AddonConfig;
import com.talhanation.smallships_addon.update.UpdateChecker;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;

/**
 * Client side of the update check: tells the player in chat that a new version
 * is out, once every time he joins a world.
 *
 * Joining is noticed from the client tick instead of from a login event - there
 * is no such event both loaders share. The tick is hooked in the loader modules
 * (forge ClientForgeBus / fabric client entry point). Kept apart from
 * {@link UpdateChecker} because this class touches Minecraft, which a dedicated
 * server must never load.
 */
public class UpdateNotifier {
    /** whether there was a player last tick, so the tick it appears in is the join */
    private static boolean wasInWorld;
    /** a failed check is reported once per game start, not on every join */
    private static boolean failureLogged;

    public static void tick(Minecraft minecraft) {
        boolean inWorld = minecraft.player != null;
        if (inWorld && !wasInWorld) onJoinWorld(minecraft);
        wasInWorld = inWorld;
    }

    private static void onJoinWorld(Minecraft minecraft) {
        if (!AddonConfig.clientUpdateCheckerEnable.get()) return;
        // the result arrives on the fetch thread, the chat belongs to the
        // client thread - and by then the player may have left again
        UpdateChecker.check().thenAccept(result -> minecraft.execute(() -> {
            switch (result.status()) {
                case OUTDATED -> {
                    if (minecraft.player != null) showMessage(minecraft, result);
                }
                case FAILED -> {
                    if (!failureLogged) SmallShipsAddonMod.LOGGER.error("Small Ships Addon could not check for updates!");
                    failureLogged = true;
                }
                default -> {}
            }
        }));
    }

    private static void showMessage(Minecraft minecraft, UpdateChecker.Result result) {
        minecraft.gui.getChat().addMessage(Component.translatable("chat.smallships_addon.update.available",
                result.latestVersion(), result.currentVersion()).withStyle(ChatFormatting.GOLD));

        Component here = Component.translatable("chat.smallships_addon.update.here").withStyle(style -> style
                .withColor(ChatFormatting.BLUE)
                .withUnderlined(true)
                .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, result.homepage()))
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.literal(result.homepage()))));
        minecraft.gui.getChat().addMessage(Component.translatable("chat.smallships_addon.update.download", here)
                .withStyle(ChatFormatting.GREEN));
    }
}

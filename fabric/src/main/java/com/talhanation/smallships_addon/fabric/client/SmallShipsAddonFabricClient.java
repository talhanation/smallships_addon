package com.talhanation.smallships_addon.fabric.client;

import com.talhanation.smallships_addon.client.AddonClientInitializer;
import com.talhanation.smallships_addon.client.UpdateNotifier;
import com.talhanation.smallships_addon.client.model.EarlyCogModel;
import com.talhanation.smallships_addon.client.model.FishingBoatModel;
import com.talhanation.smallships_addon.client.model.RowingBoatModel;
import com.talhanation.smallships_addon.client.model.EarlyCaravelModel;
import com.talhanation.smallships_addon.client.option.AddonGameOptions;
import com.talhanation.smallships_addon.client.option.AddonKeyEvent;
import com.talhanation.smallships_addon.client.renderer.entity.EarlyCogRenderer;
import com.talhanation.smallships_addon.client.renderer.entity.FishingBoatRenderer;
import com.talhanation.smallships_addon.client.renderer.entity.FishingNetRenderer;
import com.talhanation.smallships_addon.client.renderer.entity.RowingBoatRenderer;
import com.talhanation.smallships_addon.client.renderer.entity.EarlyCaravelRenderer;
import com.talhanation.smallships_addon.world.entity.AddonEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class SmallShipsAddonFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(EarlyCogModel.LAYER_LOCATION, EarlyCogModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(EarlyCaravelModel.LAYER_LOCATION, EarlyCaravelModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(RowingBoatModel.LAYER_LOCATION, RowingBoatModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(FishingBoatModel.LAYER_LOCATION, FishingBoatModel::createBodyLayer);


        EntityRendererRegistry.register(AddonEntityTypes.EARLY_COG, EarlyCogRenderer::new);
        EntityRendererRegistry.register(AddonEntityTypes.EARLY_CARAVEL, EarlyCaravelRenderer::new);
        EntityRendererRegistry.register(AddonEntityTypes.ROWING_BOAT, RowingBoatRenderer::new);
        EntityRendererRegistry.register(AddonEntityTypes.FISHING_BOAT, FishingBoatRenderer::new);

        EntityRendererRegistry.register(AddonEntityTypes.FISHING_NET, FishingNetRenderer::new);

        AddonClientInitializer.init();

        KeyBindingHelper.registerKeyBinding(AddonGameOptions.NET_KEY);

        ClientTickEvents.END_CLIENT_TICK.register(AddonKeyEvent::onKeyInput);
        ClientTickEvents.END_CLIENT_TICK.register(UpdateNotifier::tick);
    }
}

package com.talhanation.smallships_addon.forge.client;

import com.talhanation.smallships_addon.client.AddonClientInitializer;
import com.talhanation.smallships_addon.client.model.EarlyCogModel;
import com.talhanation.smallships_addon.client.model.FishingBoatModel;
import com.talhanation.smallships_addon.client.model.RowingBoatModel;
import com.talhanation.smallships_addon.client.model.EarlyCaravelModel;
import com.talhanation.smallships_addon.client.option.AddonGameOptions;
import com.talhanation.smallships_addon.client.renderer.entity.EarlyCogRenderer;
import com.talhanation.smallships_addon.client.renderer.entity.FishingBoatRenderer;
import com.talhanation.smallships_addon.client.renderer.entity.FishingNetRenderer;
import com.talhanation.smallships_addon.client.renderer.entity.RowingBoatRenderer;
import com.talhanation.smallships_addon.client.renderer.entity.EarlyCaravelRenderer;
import com.talhanation.smallships_addon.world.entity.AddonEntityTypes;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientModBus {

    @SubscribeEvent
    public void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(EarlyCogModel.LAYER_LOCATION, EarlyCogModel::createBodyLayer);
        event.registerLayerDefinition(EarlyCaravelModel.LAYER_LOCATION, EarlyCaravelModel::createBodyLayer);
        event.registerLayerDefinition(RowingBoatModel.LAYER_LOCATION, RowingBoatModel::createBodyLayer);
        event.registerLayerDefinition(FishingBoatModel.LAYER_LOCATION, FishingBoatModel::createBodyLayer);
    }

    @SubscribeEvent
    public void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AddonEntityTypes.EARLY_COG, EarlyCogRenderer::new);
        event.registerEntityRenderer(AddonEntityTypes.EARLY_CARAVEL, EarlyCaravelRenderer::new);
        event.registerEntityRenderer(AddonEntityTypes.ROWING_BOAT, RowingBoatRenderer::new);
        event.registerEntityRenderer(AddonEntityTypes.FISHING_BOAT, FishingBoatRenderer::new);

        event.registerEntityRenderer(AddonEntityTypes.FISHING_NET, FishingNetRenderer::new);
    }

    @SubscribeEvent
    public void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(AddonGameOptions.NET_KEY);
    }

    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(AddonClientInitializer::init);
    }
}

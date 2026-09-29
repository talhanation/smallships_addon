package com.talhanation.smallshipsaddon.forge.client;

import com.talhanation.smallshipsaddon.client.AddonClientInitializer;
import com.talhanation.smallshipsaddon.client.model.CrayerModel;
import com.talhanation.smallshipsaddon.client.model.SaettiaModel;
import com.talhanation.smallshipsaddon.client.renderer.entity.CrayerRenderer;
import com.talhanation.smallshipsaddon.client.renderer.entity.SaettiaRenderer;
import com.talhanation.smallshipsaddon.world.entity.AddonEntityTypes;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client side: the entity renderers and their model layers are registered
 * by the addon itself, only the sail layers go through the main mods' registry.
 */
public class ClientModBus {

    @SubscribeEvent
    public void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CrayerModel.LAYER_LOCATION, CrayerModel::createBodyLayer);
        event.registerLayerDefinition(SaettiaModel.LAYER_LOCATION, SaettiaModel::createBodyLayer);
    }

    @SubscribeEvent
    public void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AddonEntityTypes.CRAYER, CrayerRenderer::new);
        event.registerEntityRenderer(AddonEntityTypes.SAETTIA, SaettiaRenderer::new);
    }

    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(AddonClientInitializer::init);
    }
}

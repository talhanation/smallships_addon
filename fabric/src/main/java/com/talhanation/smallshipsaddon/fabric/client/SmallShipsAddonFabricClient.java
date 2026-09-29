package com.talhanation.smallshipsaddon.fabric.client;

import com.talhanation.smallshipsaddon.client.AddonClientInitializer;
import com.talhanation.smallshipsaddon.client.model.CrayerModel;
import com.talhanation.smallshipsaddon.client.model.SaettiaModel;
import com.talhanation.smallshipsaddon.client.renderer.entity.CrayerRenderer;
import com.talhanation.smallshipsaddon.client.renderer.entity.SaettiaRenderer;
import com.talhanation.smallshipsaddon.world.entity.AddonEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

/**
 * Fabric client side: same three steps as on Forge, just without an event bus.
 */
public class SmallShipsAddonFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(CrayerModel.LAYER_LOCATION, CrayerModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(SaettiaModel.LAYER_LOCATION, SaettiaModel::createBodyLayer);

        EntityRendererRegistry.register(AddonEntityTypes.CRAYER, CrayerRenderer::new);
        EntityRendererRegistry.register(AddonEntityTypes.SAETTIA, SaettiaRenderer::new);

        AddonClientInitializer.init();
    }
}

package com.talhanation.smallships_addon.client;

import com.talhanation.smallships.api.client.ShipRenderRegistry;
import com.talhanation.smallships_addon.client.model.sail.EarlyCogSailModel;
import com.talhanation.smallships_addon.client.model.sail.EarlyCaravelSailModel;
import com.talhanation.smallships_addon.client.model.sail.FishingBoatSailModel;
import com.talhanation.smallships_addon.client.model.sail.banner.*;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCogEntity;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCaravelEntity;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;

/**
 * Client side hooks into the main mod. The shared ShipRenderer looks these up by
 * ship class; every layer is optional, a ship without one simply renders
 * without it (the Rowing Boat has no sail).
 *
 * Entity renderers and model layers are registered in the loader modules
 * (forge ClientModBus / fabric client entry point), not here.
 */
public class AddonClientInitializer {
    public static void init() {
        // also available: registerSailBanner / registerMastBanner
        ShipRenderRegistry.registerSail(EarlyCogEntity.class, new EarlyCogSailModel());
        ShipRenderRegistry.registerSail(EarlyCaravelEntity.class, new EarlyCaravelSailModel());
        ShipRenderRegistry.registerSail(FishingBoatEntity.class, new FishingBoatSailModel());

        ShipRenderRegistry.registerSailBanner(EarlyCogEntity.class, new EarlyCogSailBannerModel());
        ShipRenderRegistry.registerMastBanner(EarlyCogEntity.class, new EarlyCogMastBannerModel());

        ShipRenderRegistry.registerSailBanner(EarlyCaravelEntity.class, new EarlyCaravelSailBannerModel());
        ShipRenderRegistry.registerMastBanner(EarlyCaravelEntity.class, new EarlyCaravelMastBannerModel());
    }
}

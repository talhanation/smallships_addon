package com.talhanation.smallshipsaddon.client;

import com.talhanation.smallships.api.client.ShipRenderRegistry;
import com.talhanation.smallshipsaddon.client.model.sail.CrayerSailModel;
import com.talhanation.smallshipsaddon.client.model.sail.SaettiaSailModel;
import com.talhanation.smallshipsaddon.world.entity.ship.CrayerEntity;
import com.talhanation.smallshipsaddon.world.entity.ship.SaettiaEntity;

/**
 * Shared client init. These layers are the ONLY thing the main mod needs from
 * an addon on the client - the shared ShipRenderer looks them up by ship class,
 * and every one of them is optional: a ship without a registered model simply
 * gets no such layer instead of crashing the renderer.
 *
 * <ul>
 * <li>{@code registerSail} - the sail, dyed and torn by the sail damage state</li>
 * <li>{@code registerSailBanner} - a banner projected onto the sail cloth</li>
 * <li>{@code registerMastBanner} - a flag flying from the mast</li>
 * </ul>
 *
 * Neither ship here carries a banner model. Both would extend SailBannerModel
 * respectively MastBannerModel and follow the segment conventions documented
 * there.
 */
public class AddonClientInitializer {
    public static void init() {
        ShipRenderRegistry.registerSail(CrayerEntity.class, new CrayerSailModel());
        ShipRenderRegistry.registerSail(SaettiaEntity.class, new SaettiaSailModel());
    }
}

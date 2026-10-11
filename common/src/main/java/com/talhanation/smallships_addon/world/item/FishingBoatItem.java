package com.talhanation.smallships_addon.world.item;

import com.talhanation.smallships.world.item.ShipItem;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import net.minecraft.world.entity.vehicle.Boat;

/** The placeable item. ShipItem handles placing; only the ship factory is needed. */
public class FishingBoatItem extends ShipItem {
    public FishingBoatItem(Boat.Type type, Properties properties) {
        super(type, FishingBoatEntity::summon, properties);
    }
}

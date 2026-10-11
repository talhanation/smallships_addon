package com.talhanation.smallships_addon.world.item;

import com.talhanation.smallships.world.item.ShipItem;
import com.talhanation.smallships_addon.world.entity.ship.RowingBoatEntity;
import net.minecraft.world.entity.vehicle.Boat;

/** The placeable item. ShipItem handles placing; only the ship factory is needed. */
public class RowingBoatItem extends ShipItem {
    public RowingBoatItem(Boat.Type type, Properties properties) {
        super(type, RowingBoatEntity::summon, properties);
    }
}

package com.talhanation.smallships_addon.world.item;

import com.talhanation.smallships.world.item.ShipItem;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCogEntity;
import net.minecraft.world.entity.vehicle.Boat;

/** The placeable item. ShipItem handles placing; only the ship factory is needed. */
public class EarlyCogItem extends ShipItem {
    public EarlyCogItem(Boat.Type type, Properties properties) {
        super(type, EarlyCogEntity::summon, properties);
    }
}

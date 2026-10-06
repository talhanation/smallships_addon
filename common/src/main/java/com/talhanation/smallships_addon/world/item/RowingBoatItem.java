package com.talhanation.smallships_addon.world.item;

import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.item.ShipItem;
import com.talhanation.smallships_addon.world.entity.ship.RowingBoatEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/** The placeable item. ShipItem handles placing; only the ship factory is needed. */
public class RowingBoatItem extends ShipItem {
    public RowingBoatItem(Boat.Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected @NotNull Ship getShip(@NotNull Level level, double x, double y, double z) {
        return RowingBoatEntity.summon(level, x, y, z);
    }
}

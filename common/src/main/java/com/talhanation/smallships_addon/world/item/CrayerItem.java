package com.talhanation.smallshipsaddon.world.item;

import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.item.ShipItem;
import com.talhanation.smallshipsaddon.world.entity.ship.CrayerEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * ShipItem is public in the main mod, so an addon item is three lines.
 */
public class CrayerItem extends ShipItem {
    public CrayerItem(Boat.Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected @NotNull Ship getShip(@NotNull Level level, double x, double y, double z) {
        return CrayerEntity.summon(level, x, y, z);
    }
}

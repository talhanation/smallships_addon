package com.talhanation.smallships_addon.world.entity;

import com.talhanation.smallships_addon.world.entity.ship.EarlyCogEntity;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import com.talhanation.smallships_addon.world.entity.ship.FishingNetEntity;
import com.talhanation.smallships_addon.world.entity.ship.RowingBoatEntity;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCaravelEntity;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

/**
 * Entity types of this addon. The addon registers its own entities under its
 * own mod id - nothing is added to the main mods' registers.
 */
public class AddonEntityTypes {
    public static final EntityType<EarlyCogEntity> EARLY_COG = getEntityType(EarlyCogEntity.class);
    public static final EntityType<EarlyCaravelEntity> EARLY_CARAVEL = getEntityType(EarlyCaravelEntity.class);
    public static final EntityType<RowingBoatEntity> ROWING_BOAT = getEntityType(RowingBoatEntity.class);
    public static final EntityType<FishingBoatEntity> FISHING_BOAT = getEntityType(FishingBoatEntity.class);
    // not a ship: the box the fishing boat drags astern while its net is out
    public static final EntityType<FishingNetEntity> FISHING_NET = getEntityType(FishingNetEntity.class);
    public static void init() {
    }

    // implemented per loader in world/entity/forge and world/entity/fabric
    @ExpectPlatform
    public static <T extends Entity> EntityType<T> getEntityType(Class<T> entityClass) {
        throw new AssertionError();
    }
}

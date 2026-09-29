package com.talhanation.smallshipsaddon.world.entity;

import com.talhanation.smallshipsaddon.world.entity.ship.CrayerEntity;
import com.talhanation.smallshipsaddon.world.entity.ship.SaettiaEntity;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

/**
 * Entity types of this addon. Same @ExpectPlatform pattern the main mod uses -
 * an addon registers its own entities and does not touch ModEntityTypes.
 */
public class AddonEntityTypes {
    public static final EntityType<CrayerEntity> CRAYER = getEntityType(CrayerEntity.class);
    public static final EntityType<SaettiaEntity> SAETTIA = getEntityType(SaettiaEntity.class);

    public static void init() {
    }

    @ExpectPlatform
    public static <T extends Entity> EntityType<T> getEntityType(Class<T> entityClass) {
        throw new AssertionError();
    }
}

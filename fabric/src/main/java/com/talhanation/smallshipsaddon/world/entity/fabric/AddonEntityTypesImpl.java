package com.talhanation.smallshipsaddon.world.entity.fabric;

import com.talhanation.smallshipsaddon.SmallShipsAddon;
import com.talhanation.smallshipsaddon.world.entity.ship.CrayerEntity;
import com.talhanation.smallshipsaddon.world.entity.ship.SaettiaEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.HashMap;
import java.util.Map;

/**
 * @ExpectPlatform target for AddonEntityTypes#getEntityType. The class name and
 * the package suffix must match what Architectury expects:
 * <original package>.fabric.<original class>Impl
 */
public class AddonEntityTypesImpl {
    private static final Map<Class<? extends Entity>, EntityType<? extends Entity>> entries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends Entity> EntityType<T> getEntityType(Class<T> entityClass) {
        return (EntityType<T>) entries.get(entityClass);
    }

    private static <T extends Entity> EntityType<T> register(String id, EntityType<T> type) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SmallShipsAddon.MOD_ID, id), type);
    }

    static {
        entries.put(CrayerEntity.class, register(CrayerEntity.ID, EntityType.Builder.of(CrayerEntity::new, MobCategory.MISC)
                .sized(2.6F, 1.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));

        entries.put(SaettiaEntity.class, register(SaettiaEntity.ID, EntityType.Builder.of(SaettiaEntity::new, MobCategory.MISC)
                .sized(2.4F, 1.25F)
                .clientTrackingRange(20)
                .updateInterval(10)
                .build()));
    }
}

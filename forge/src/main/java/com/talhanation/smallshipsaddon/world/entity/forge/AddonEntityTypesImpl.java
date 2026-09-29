package com.talhanation.smallshipsaddon.world.entity.forge;

import com.talhanation.smallshipsaddon.SmallShipsAddon;
import com.talhanation.smallshipsaddon.world.entity.ship.CrayerEntity;
import com.talhanation.smallshipsaddon.world.entity.ship.SaettiaEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @ExpectPlatform target for AddonEntityTypes#getEntityType. The class name and
 * the package suffix must match what Architectury expects:
 * <original package>.forge.<original class>Impl
 */
public class AddonEntityTypesImpl {
    private static final Map<Class<? extends Entity>, RegistryObject<EntityType<? extends Entity>>> entries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends Entity> EntityType<T> getEntityType(Class<T> entityClass) {
        return (EntityType<T>) entries.get(entityClass).get();
    }

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SmallShipsAddon.MOD_ID);

    static {
        entries.put(CrayerEntity.class, ENTITY_TYPES.register(CrayerEntity.ID,
                () -> EntityType.Builder.of(CrayerEntity::new, MobCategory.MISC)
                        .sized(2.6F, 1.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)
                        .build(CrayerEntity.ID)));

        entries.put(SaettiaEntity.class, ENTITY_TYPES.register(SaettiaEntity.ID,
                () -> EntityType.Builder.of(SaettiaEntity::new, MobCategory.MISC)
                        .sized(2.4F, 1.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)
                        .build(SaettiaEntity.ID)));
    }
}

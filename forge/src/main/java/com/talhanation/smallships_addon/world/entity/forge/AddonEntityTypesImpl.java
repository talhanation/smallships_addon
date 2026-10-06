package com.talhanation.smallships_addon.world.entity.forge;

import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCogEntity;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import com.talhanation.smallships_addon.world.entity.ship.FishingNetEntity;
import com.talhanation.smallships_addon.world.entity.ship.RowingBoatEntity;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCaravelEntity;
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

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SmallShipsAddonMod.MOD_ID);

    static {
        entries.put(EarlyCogEntity.class, ENTITY_TYPES.register(EarlyCogEntity.ID,
                () -> EntityType.Builder.of(EarlyCogEntity::new, MobCategory.MISC)
                        .sized(3.25F, 1.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)
                        .build(EarlyCogEntity.ID)));

        entries.put(EarlyCaravelEntity.class, ENTITY_TYPES.register(EarlyCaravelEntity.ID,
                () -> EntityType.Builder.of(EarlyCaravelEntity::new, MobCategory.MISC)
                        .sized(3.25F, 1.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)
                        .build(EarlyCaravelEntity.ID)));

        entries.put(RowingBoatEntity.class, ENTITY_TYPES.register(RowingBoatEntity.ID,
                () -> EntityType.Builder.of(RowingBoatEntity::new, MobCategory.MISC)
                        .sized(1.5F, 1.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)
                        .build(RowingBoatEntity.ID)));

        entries.put(FishingBoatEntity.class, ENTITY_TYPES.register(FishingBoatEntity.ID,
                () -> EntityType.Builder.of(FishingBoatEntity::new, MobCategory.MISC)
                        .sized(2.25F, 1.25F)
                        .clientTrackingRange(20)
                        .setUpdateInterval(10)
                        .setShouldReceiveVelocityUpdates(true)
                        .build(FishingBoatEntity.ID)));

        // The size here is only the placeholder until the synched data arrives -
        // the net overrides getDimensions from the box its boat hands it.
        // updateInterval is deliberately high: the boat places its net on both
        // sides every tick, so position packets are pure overhead.
        // noSummon keeps players from spawning a net without a boat by command.
        entries.put(FishingNetEntity.class, ENTITY_TYPES.register(FishingNetEntity.ID,
                () -> EntityType.Builder.of(FishingNetEntity::factory, MobCategory.MISC)
                        .sized(1.0F, 1.0F)
                        .noSummon()
                        .clientTrackingRange(20)
                        .setUpdateInterval(Integer.MAX_VALUE)
                        .build(FishingNetEntity.ID)));
    }
}

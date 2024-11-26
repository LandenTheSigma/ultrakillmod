package com.ULTRAKILLMOD.init;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Entities.FleshPrison;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, ULTRAKILLMOD.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<FleshPrison>> FLESH_PRISON =
            ENTITY_TYPES.register("flesh_prison",
                    () -> EntityType.Builder.of(FleshPrison::new, MobCategory.MONSTER)
                            .sized(1f, 1f)
                            .build("flesh_prison"));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }

}

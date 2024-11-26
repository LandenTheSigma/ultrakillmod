package com.ULTRAKILLMOD.init.Entities;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Entities.models.FleshPrisonModel;
import com.ULTRAKILLMOD.init.EntityRegistry;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Objects;

public class EntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, ULTRAKILLMOD.MODID);

    public static final EntityType<FleshPrison> FLESH_PRISON =
            ENTITY_TYPES.register("flesh_prison",
                    () -> EntityType.Builder.of(FleshPrison::new, MobCategory.MONSTER)
                            .sized(1.0F, 2.5F) // Width and height of the entity
                            .build("flesh_prison")
            ).get();


    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}

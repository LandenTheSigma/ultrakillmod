package com.ULTRAKILLMOD.init.Entities;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Entities.entities.FleshPrison;
import com.ULTRAKILLMOD.init.Entities.client.MinosPrimeModel;
import com.ULTRAKILLMOD.init.Entities.entities.MinosPrime;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Entities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, ULTRAKILLMOD.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<FleshPrison>> FLESH_PRISON =
            ENTITY_TYPES.register("flesh_prison", () -> EntityType.Builder.of(FleshPrison::new, MobCategory.CREATURE)
                    .sized(3f,3f).build("flesh_prison"));
    public static final DeferredHolder<EntityType<?>, EntityType<MinosPrime>> MINOS_PRIME =
            ENTITY_TYPES.register("minos_prime", () -> EntityType.Builder.of(MinosPrime::new, MobCategory.CREATURE)
                    .sized(1.5f,3f).build("minos_prime"));



    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}

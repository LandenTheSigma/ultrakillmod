package com.ULTRAKILLMOD.init.Entities;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.EntityRegistry;
import jdk.jfr.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = ULTRAKILLMOD.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EntityEvents {
    @SubscribeEvent
    public static void initializeAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.FLESH_PRISON.get(), FleshPrison.createAttributes().build());
    }
}

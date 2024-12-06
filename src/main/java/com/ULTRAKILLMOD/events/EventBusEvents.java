package com.ULTRAKILLMOD.events;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Entities.Entities;
import com.ULTRAKILLMOD.init.Entities.entities.FleshPrison;
import com.ULTRAKILLMOD.init.Entities.client.MinosPrimeModel;
import com.ULTRAKILLMOD.init.Entities.entities.MinosPrime;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = ULTRAKILLMOD.MODID, bus = EventBusSubscriber.Bus.MOD)
public class EventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(Entities.FLESH_PRISON.get(), FleshPrison.createAttributes().build());
        event.put(Entities.MINOS_PRIME.get(), MinosPrime.createAttributes().build());
    }
}

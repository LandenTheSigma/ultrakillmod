package com.ULTRAKILLMOD.events;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Entities.client.FleshPrisonModel;
import com.ULTRAKILLMOD.init.Entities.client.MinosPrimeModel;
import com.ULTRAKILLMOD.init.Entities.client.ModelLayers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = ULTRAKILLMOD.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class EventBusClientEvents {
    @SubscribeEvent
    public static void RegisterLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelLayers.FLESH_PRISON_LAYER, FleshPrisonModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayers.MINOS_PRIME_LAYER, MinosPrimeModel::createBodyLayer);
    }
}

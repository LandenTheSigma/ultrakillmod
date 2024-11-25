package com.ULTRAKILLMOD;

import com.ULTRAKILLMOD.Client.SoundHandler;
import com.ULTRAKILLMOD.init.EntityRegistry;
import com.ULTRAKILLMOD.init.ItemRegistry;
import net.minecraft.ResourceLocationException;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ULTRAKILLMOD.MODID)
public class ULTRAKILLMOD {
    public static final String MODID = "ultrakillmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ULTRAKILLMOD(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        ItemRegistry.register(modEventBus);
        SoundHandler.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.COMBAT) {
            event.accept(ItemRegistry.REVOLVER);
        }
        if (event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.OP_BLOCKS) {
            event.accept(ItemRegistry.COIN);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }



    @SubscribeEvent
    public void onEntityFall(LivingFallEvent event) {
        event.setDistance(0.0F);
    }
}
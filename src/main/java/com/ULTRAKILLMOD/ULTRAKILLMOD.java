package com.ULTRAKILLMOD;

import com.ULTRAKILLMOD.Client.Keybinds;
import com.ULTRAKILLMOD.Client.handler.VFXHandler;
import com.ULTRAKILLMOD.init.BlockRegistry;
import com.ULTRAKILLMOD.init.CreativeModeTabs;
import com.ULTRAKILLMOD.init.Entities.Entities;
import com.ULTRAKILLMOD.init.Entities.client.FleshPrisonRenderer;
import com.ULTRAKILLMOD.init.Entities.client.MinosPrimeRenderer;
import com.ULTRAKILLMOD.init.ItemRegistry;
import com.ULTRAKILLMOD.init.Items.SoundRegistry;
import com.ULTRAKILLMOD.init.UltrakillmodTitleScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(ULTRAKILLMOD.MODID)
public class ULTRAKILLMOD {
    public static final String MODID = "ultrakillmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ULTRAKILLMOD(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        ItemRegistry.register(modEventBus);
        SoundRegistry.register(modEventBus);
        Entities.register(modEventBus);
        CreativeModeTabs.register(modEventBus);
        BlockRegistry.register(modEventBus);
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
            EntityRenderers.register(Entities.FLESH_PRISON.get(), FleshPrisonRenderer::new);
            EntityRenderers.register(Entities.MINOS_PRIME.get(), MinosPrimeRenderer::new);
        }
    }
    private static boolean firstScreenShown = false;
    @SubscribeEvent
    public void ClientTickEvent(ClientTickEvent.Pre event) {
        if (!firstScreenShown) {
            firstScreenShown=true;
            Minecraft.getInstance().setScreen(new UltrakillmodTitleScreen());
        }
    }

    @SubscribeEvent
    public void onEntityFall(LivingFallEvent event) {

    }
}
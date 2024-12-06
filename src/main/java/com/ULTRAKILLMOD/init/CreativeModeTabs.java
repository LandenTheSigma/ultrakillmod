package com.ULTRAKILLMOD.init;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ULTRAKILLMOD.MODID);

    public static final Supplier<CreativeModeTab> ULTRAKILL_WEAPONS = CREATIVE_MODE_TABS.register("ultrakill_weapons",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.REVOLVER.get()))
                    .title(Component.translatable("Ultrakill Weapons"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ItemRegistry.REVOLVER);
                        output.accept(ItemRegistry.SHOTGUN);
                        output.accept(ItemRegistry.RAILCANNON);
                        output.accept(ItemRegistry.COIN);
                        output.accept(ItemRegistry.NAILGUN);
                        output.accept(ItemRegistry.ROCKET_LAUNCHER);
                    }))
                    .build());

    public static final Supplier<CreativeModeTab> ULTRAKILL_BLOCKS = CREATIVE_MODE_TABS.register("ultrakill_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockRegistry.TERMINAL_UPPER))
                    .title(Component.translatable("Ultrakill Blocks"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(BlockRegistry.TERMINAL_UPPER);
                        output.accept(BlockRegistry.TERMINAL_LOWER);
                    }))
                    .build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}

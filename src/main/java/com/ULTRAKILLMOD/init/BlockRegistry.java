package com.ULTRAKILLMOD.init;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Blocks.Terminal_Lower;
import com.ULTRAKILLMOD.init.Blocks.Terminal_Upper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ULTRAKILLMOD.MODID);

    public static final DeferredBlock<Block> TERMINAL_LOWER = registerBlock("terminal_lower",
            () -> new Terminal_Lower(BlockBehaviour.Properties.of().strength(3f)));

    public static final DeferredBlock<Block> TERMINAL_UPPER = registerBlock("terminal_upper",
            () -> new Terminal_Upper(BlockBehaviour.Properties.of().strength(3f)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

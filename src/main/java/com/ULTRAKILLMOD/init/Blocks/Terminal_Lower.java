package com.ULTRAKILLMOD.init.Blocks;

import com.ULTRAKILLMOD.Client.UI.ItemInterface;
import com.ULTRAKILLMOD.Client.UI.TerminalMenu;
import com.ULTRAKILLMOD.init.BlockRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.phys.BlockHitResult;

import static net.minecraft.world.level.block.BarrelBlock.FACING;

public class Terminal_Lower extends Block {
    public Terminal_Lower(Properties properties) {
        super(properties);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide) {
            BlockPos abovePos = pos.above();
            if (level.getBlockState(abovePos).isAir()) {
                level.setBlock(abovePos, BlockRegistry.TERMINAL_UPPER.get().defaultBlockState(), 3); // Flag 3 for block update notifications
            }
        }
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!level.isClientSide) {
            BlockPos abovePos = pos.above();
            BlockState aboveState = level.getBlockState(abovePos);

            if (aboveState.is(BlockRegistry.TERMINAL_UPPER.get())) {
                level.destroyBlock(abovePos, true);
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        Minecraft minecraft = Minecraft.getInstance(); // Ensure it's client-side
        if (minecraft.screen == null) { // Open menu if no other screen is active
            minecraft.setScreen(new TerminalMenu(Component.literal("Terminal")));
        }

        return InteractionResult.SUCCESS;
    }
}


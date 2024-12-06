package com.ULTRAKILLMOD.init.Blocks;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class Terminal_Upper extends Block implements MenuProvider {
    public Terminal_Upper(Properties properties) {
        super(properties);
    }
    private static final Component TITLE = Component.translatable("container." + ULTRAKILLMOD.MODID + ".terminal");

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!level.isClientSide) {
            BlockPos abovePos = pos.below();
            BlockState aboveState = level.getBlockState(abovePos);

            if (aboveState.is(BlockRegistry.TERMINAL_LOWER.get())) {
                level.destroyBlock(abovePos, true);
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide) {
            BlockPos abovePos = pos.below();
            if (level.getBlockState(abovePos).isAir()) {
                level.setBlock(abovePos, BlockRegistry.TERMINAL_LOWER.get().defaultBlockState(), 3); // Flag 3 for block update notifications
            }
        }
    }

    @Override
    public Component getDisplayName() {
        return TITLE;
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }
}

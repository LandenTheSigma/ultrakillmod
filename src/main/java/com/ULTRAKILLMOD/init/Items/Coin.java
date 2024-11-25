package com.ULTRAKILLMOD.init.Items;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class Coin extends Item {
    public Coin(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            shootProjectile(level, player);

            //level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    //SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F);

            player.getCooldowns().addCooldown(this, 0);
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }

    private void shootProjectile(Level level, Player player) {
        var coin = new net.minecraft.world.entity.projectile.Snowball(level, player);
        coin.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
        coin.setDeltaMovement(0.0, 0.75, 0.0);

        level.addFreshEntity(coin);
    }
}

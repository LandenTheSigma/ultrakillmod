package com.ULTRAKILLMOD.init.Items;

import com.ULTRAKILLMOD.init.Bullets.ExplosiveBullet;
import com.ULTRAKILLMOD.init.Bullets.NormalBullet;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RocketLauncher extends Item {

    public RocketLauncher(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) { // Ensure this only happens on the server side
            // Simulate shooting logic
            shootProjectile(level, player);
            player.getCooldowns().addCooldown(this, 10);
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }

    private void shootProjectile(Level level, Player player) {
        var bullet = new ExplosiveBullet(level, player);
        bullet.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
        bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3F, 0F);
        level.addFreshEntity(bullet);
    }
}
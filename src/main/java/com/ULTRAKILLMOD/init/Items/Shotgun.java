package com.ULTRAKILLMOD.init.Items;

import com.ULTRAKILLMOD.init.Bullets.NormalBullet;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Shotgun extends Item {

    public Shotgun(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            for(int i = 0; i < 6; i++) {
                shootProjectile(level, player);
            }

            player.getCooldowns().addCooldown(this, 5);
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }

    private void shootProjectile(Level level, Player player) {
        var bullet = new NormalBullet(level, player);
        bullet.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
        bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 5F, 15F);
        level.addFreshEntity(bullet);
    }
}
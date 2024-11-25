package com.ULTRAKILLMOD.init.Items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class Revolver extends Item {

    public Revolver(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) { // Ensure this only happens on the server side
            // Simulate shooting logic
            shootProjectile(level, player);

            // Play a shooting sound
           // level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    //SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F);

            // Optionally, you can set a cooldown for the gun
            player.getCooldowns().addCooldown(this, 1);
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }

    private void shootProjectile(Level level, Player player) {
        // Create the snowball projectile
        var bullet = new net.minecraft.world.entity.projectile.Arrow(EntityType.ARROW, level);

        // Set the position slightly in front of the player's eyes
        bullet.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());

        // Make the snowball move in the direction the player is looking
        bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 5F, 0F);

        // Add the projectile to the world
        level.addFreshEntity(bullet);
    }
}
package com.ULTRAKILLMOD.init.Bullets;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;

public class ExplosiveBullet extends Fireball {
    public ExplosiveBullet(EntityType<? extends Fireball> entityType, Level level) {
        super(entityType, level);
    }

    public ExplosiveBullet(Level level, LivingEntity shooter) {
        super(EntityType.FIREBALL, level);
        this.setOwner(shooter);
    }

    @Override
    protected void onHit(HitResult result) {
        boolean doDiscard = true;
        if (result instanceof EntityHitResult entityHitResult) {
            if (entityHitResult.getEntity() == this.getOwner()) {
                doDiscard = false; // Don't discard when hitting the shooter
                return;
            }
        }

        // Trigger an explosion at the bullet's location
        if (doDiscard) {
            // Get the position of the hit
            double x = this.getX();
            double y = this.getY();
            double z = this.getZ();

            // Create the explosion
            this.level().explode(this, x, y, z, 4.0F, true, Level.ExplosionInteraction.TNT); // You can adjust the explosion strength

            this.discard();
        }

        super.onHit(result);
    }
}
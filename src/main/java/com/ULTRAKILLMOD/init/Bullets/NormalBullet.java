package com.ULTRAKILLMOD.init.Bullets;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class NormalBullet extends Arrow {
    public NormalBullet(EntityType<? extends Arrow> entityType, Level level) {
        super(entityType, level);
    }

    public NormalBullet(Level level, LivingEntity shooter) {
        super(EntityType.ARROW, level);
        this.setOwner(shooter);
    }

    @Override
    protected void onHit(HitResult result) {
        boolean doDiscard = true;
        if (result instanceof EntityHitResult entityHitResult) {
            if (entityHitResult.getEntity() == this.getOwner()) {
                doDiscard = false;
                return;
            }
        }

        super.onHit(result);

        if (doDiscard) {
            this.discard();
        }
    }
}

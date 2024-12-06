package com.ULTRAKILLMOD.init.Entities.entities;

import com.ULTRAKILLMOD.init.Entities.Entities;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class FleshPrison extends Monster {
    private final ServerBossEvent bossEvent;

    public FleshPrison(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        // Initialize the boss bar
        this.bossEvent = new ServerBossEvent(
                Component.literal("Flesh Prison"), // Title of the boss bar
                BossEvent.BossBarColor.RED,       // Color of the boss bar
                BossEvent.BossBarOverlay.PROGRESS // Style of the boss bar
        );
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0)
                .add(Attributes.FOLLOW_RANGE, 100)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1000000)
                .add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.GRAVITY, 0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        // Add the player to the boss bar when they see the entity
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        // Remove the player from the boss bar when they no longer see the entity
        this.bossEvent.removePlayer(player);
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void remove(RemovalReason reason) {
        super.remove(reason);

        if (!level().isClientSide()) {
            var minosPrime = Entities.MINOS_PRIME.get().create(level());
            if (minosPrime != null) {
                minosPrime.setPos(this.getX(), this.getY(), this.getZ());
                level().addFreshEntity(minosPrime);
            }
        }

        this.bossEvent.removeAllPlayers();
    }
}

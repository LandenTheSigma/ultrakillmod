package com.ULTRAKILLMOD.init.Entities.entities;

import com.ULTRAKILLMOD.init.Entities.animations.animations.minos_spawn;
import com.ULTRAKILLMOD.init.Items.SoundRegistry;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class MinosPrime extends Monster  {
    private final ServerBossEvent bossEvent;
    private long spawnTime; // Tracks the spawn time in game ticks
    private static final int INVINCIBILITY_DURATION = 45 * 20; // 40 seconds in ticks

    public final AnimationState idleAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;
    public static boolean isSpawning = false;

    public AnimationDefinition spawningAnimationDefinition = minos_spawn.spawn;

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide) {
            setupAnimationStates();
        }

        if (this.level().getGameTime() - this.spawnTime > 45) { // Example duration of 40 ticks
            this.isSpawning = false;
        }

        if(isSpawning) {
            this.setInvulnerable(true);
        }
        else {
            this.setInvulnerable(false);
        }
    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout<=0) {
            this.idleAnimationTimeout=this.random.nextInt(40)+80;
            this.idleAnimationState.start(this.tickCount);
            if (isSpawning) {

            }
        }
    }

    public MinosPrime(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);

        this.bossEvent = new ServerBossEvent(
                Component.literal("Minos Prime"),
                BossEvent.BossBarColor.BLUE,
                BossEvent.BossBarOverlay.PROGRESS
        );
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MOVEMENT_SPEED, 1)
                .add(Attributes.FOLLOW_RANGE, 100)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1000000)
                .add(Attributes.MAX_HEALTH, 500)
                .add(Attributes.GRAVITY, 3)
                .add(Attributes.ATTACK_DAMAGE, 10);
    }

    @Override
    protected void updateWalkAnimation(float partialTick) {
        super.updateWalkAnimation(partialTick);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1.0, 32.0f));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, ServerPlayer.class, true));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.5f));
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        if (this.getHealth() < this.getMaxHealth() * 0.5) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(1.5);
        }
    }

    @Override
    public void remove(RemovalReason reason) {
        super.remove(reason);
        this.bossEvent.removeAllPlayers();
        if (!this.level().isClientSide) {
            this.level().playSound(
                    null,
                    this.blockPosition(),
                    SoundRegistry.MINOS_JUDGEMENT.get(),
                    SoundSource.HOSTILE,
                    1.0F,
                    1.0F
            );
        }
    }

    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();
        if (!this.level().isClientSide) {
            // Play spawn sound
            this.level().playSound(
                    null,
                    this.blockPosition(),
                    SoundRegistry.MINOS_SPAWN.get(),
                    SoundSource.HOSTILE,
                    1.0F,
                    1.0F
            );
        }

        // Set spawning state and record spawn time
        this.isSpawning = true;
        this.spawnTime = this.level().getGameTime();

        // Start the spawn animation
        if (this.level().isClientSide) {
            this.idleAnimationState.start(this.tickCount);
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.level().getGameTime() - this.spawnTime < INVINCIBILITY_DURATION) {
            return false;
        }
        return super.hurt(source, amount);
    }

    @Override
    protected void applyGravity() {
        super.applyGravity();
    }

}

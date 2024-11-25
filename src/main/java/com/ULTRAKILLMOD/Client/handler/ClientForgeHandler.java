package com.ULTRAKILLMOD.Client.handler;

import com.ULTRAKILLMOD.Client.Keybinds;
import com.ULTRAKILLMOD.Client.SoundHandler;
import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ibm.icu.text.Normalizer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = ULTRAKILLMOD.MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ClientForgeHandler {
    private static boolean isTakingDamage = false;
    public static boolean isParrying = false;

    public static boolean isSliding = false;

    private static long lastParryTime = 0;
    private static final long PARRY_COOLDOWN = 5000;

    private static long lastDashTime = 0;
    private static final long DASH_COOLDOWN = 1000;

    private static int delayTicks = 0;
    private static float jumpCharge = 0f;

    @SubscribeEvent
    public static void onPlayerDamage(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        double originalHealth = entity.getHealth();

        if (entity instanceof Player) {
            isTakingDamage = true;

            delayTicks = 4;
            Minecraft.getInstance().execute(() -> {
                if (delayTicks > 0) {
                    delayTicks--;

                    if (isParrying) {
                        entity.setHealth((float) originalHealth);
                    }

                    if (delayTicks == 0) {
                        isTakingDamage = false;
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public static void clientTick(ClientTickEvent.Pre event) throws InterruptedException {
        Player player = Minecraft.getInstance().player;

        if (player == null) {
            return;
        }

        long currentTime = System.currentTimeMillis();
        if(Keybinds.INSTANCE.PARRY.isDown() && isTakingDamage) {
            if((currentTime - lastParryTime) < PARRY_COOLDOWN) {
                return;
            }

            isParrying = true;
            Keybinds.INSTANCE.PARRY.consumeClick();

            isTakingDamage = false;

            Thread.sleep(166);

            player.playSound(SoundHandler.PARRY.get());
        } else if (Keybinds.INSTANCE.PARRY.isDown() && !isTakingDamage) {
            lastParryTime = currentTime;
            isParrying = false;
        } else if (!Keybinds.INSTANCE.PARRY.isDown()) {
            isParrying = false;
        }

        if (Keybinds.INSTANCE.SLIDE.isDown() && player.isSprinting()) {
            isSliding = true;
            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 0, 5);
            player.addEffect(effectInstance);
            player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2);
        } else if (!Keybinds.INSTANCE.SLIDE.isDown()) {
            isSliding = false;
            player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
            player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
        }

        if (Keybinds.INSTANCE.CROUCH.isDown()) {
            if (player.onGround()) {
                jumpCharge += 0.5f;
            }
            else if(!player.onGround()) {
                player.travel(new Vec3(0,-0.3,0));
                jumpCharge = 0f;
            }
        }

        if(!Keybinds.INSTANCE.CROUCH.isDown()) {
            jumpCharge = 0f;
            player.removeEffect(MobEffects.JUMP);
        }

        if (Keybinds.INSTANCE.JUMP.isDown() && player.onGround() && jumpCharge > 0.5f) {
            MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.JUMP, 1, (int) jumpCharge);
            player.addEffect(effectInstance);
            jumpCharge = 0f;
        }

        if (Keybinds.INSTANCE.DASH.isDown() && currentTime - lastDashTime > DASH_COOLDOWN) {
            lastDashTime = currentTime;
            Keybinds.INSTANCE.DASH.consumeClick();

            double dashSpeed = 3;
            float yaw = player.getYRot();
            float pitch = player.getXRot();

            double x = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
            double y = -Math.sin(Math.toRadians(pitch));
            double z = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));

            player.setDeltaMovement(player.getDeltaMovement().add(x * dashSpeed, y * dashSpeed, z * dashSpeed));
        }
    }
}

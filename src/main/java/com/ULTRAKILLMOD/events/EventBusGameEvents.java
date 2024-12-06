package com.ULTRAKILLMOD.events;

import com.ULTRAKILLMOD.Client.Keybinds;
import com.ULTRAKILLMOD.Client.handler.VFXHandler;
import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Entities.client.FleshPrisonModel;
import com.ULTRAKILLMOD.init.Entities.client.MinosPrimeModel;
import com.ULTRAKILLMOD.init.Entities.client.ModelLayers;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

@EventBusSubscriber(modid = ULTRAKILLMOD.MODID, value = Dist.CLIENT)
public class EventBusGameEvents {
    @SubscribeEvent
    public static void onEntityFall(LivingFallEvent event) {
        if (event.getEntity() instanceof Player player && player.equals(Minecraft.getInstance().player)) {
            if (Keybinds.INSTANCE.CROUCH.isDown() && event.getDistance() > 3) {

                Vec3 playerPos = player.position().add(new Vec3(0.0,-0.5,0.0));

                float dist = event.getDistance();

                if (dist > 10) {
                    dist = 10;
                }

                for(int i = 0; i<dist; i++) {
                    VFXHandler.explosionRing(i/2, i*8, playerPos, 0);
                }

                double radius = dist * 2; // Radius of the effect increases with fall distance
                AABB damageArea = new AABB(
                        playerPos.x - radius, playerPos.y - radius, playerPos.z - radius,
                        playerPos.x + radius, playerPos.y + radius, playerPos.z + radius
                );

                for (Entity entity : player.level().getEntities(player, damageArea)) {
                    if (entity instanceof LivingEntity target && entity != player) {
                        target.hurt(player.damageSources().playerAttack(player), dist * 2.0f);

                        Vec3 knockback = target.position().subtract(playerPos).normalize().scale(dist/2);
                        target.setDeltaMovement(target.getDeltaMovement().add(knockback));
                    }
                }
            }
            event.setCanceled(true);
        }
    }
}

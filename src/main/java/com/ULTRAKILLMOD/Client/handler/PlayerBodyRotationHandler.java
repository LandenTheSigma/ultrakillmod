package com.ULTRAKILLMOD.Client.handler;

import ca.weblite.objc.Client;
import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.mojang.blaze3d.vertex.PoseStack;
import com.ULTRAKILLMOD.Client.handler.ClientForgeHandler;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

@EventBusSubscriber(modid = ULTRAKILLMOD.MODID, bus = EventBusSubscriber.Bus.GAME, value = net.neoforged.api.distmarker.Dist.CLIENT)
public class PlayerBodyRotationHandler {
    public static Player player = Minecraft.getInstance().player;

    @SubscribeEvent
    public static void onPlayerRender(RenderLivingEvent.Pre<?, ?> event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof AbstractClientPlayer player)) return;

        LivingEntityRenderer<?, ?> renderer = event.getRenderer();
        if (!(renderer instanceof PlayerRenderer)) return;

        if (ClientForgeHandler.isSliding) {
            PoseStack poseStack = event.getPoseStack();
            poseStack.pushPose();

            float bodyYaw = player.yBodyRot;
            poseStack.mulPose(Axis.YP.rotationDegrees(-bodyYaw));
            poseStack.mulPose(Axis.XP.rotationDegrees(-60.0F));
        }
    }

    @SubscribeEvent
    public static void onPlayerRenderPost(RenderLivingEvent.Post<?, ?> event) {
        LivingEntity entity = event.getEntity();
        if (!(entity instanceof AbstractClientPlayer)) return;

        LivingEntityRenderer<?, ?> renderer = event.getRenderer();
        if (!(renderer instanceof PlayerRenderer)) return;

        if (ClientForgeHandler.isSliding) {
            PoseStack poseStack = event.getPoseStack();
            poseStack.popPose();
        }
    }
}


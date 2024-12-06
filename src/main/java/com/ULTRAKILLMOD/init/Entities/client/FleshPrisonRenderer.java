package com.ULTRAKILLMOD.init.Entities.client;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Entities.entities.FleshPrison;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FleshPrisonRenderer extends MobRenderer<FleshPrison, FleshPrisonModel<FleshPrison>> {
    public FleshPrisonRenderer(EntityRendererProvider.Context context) {
        super(context, new FleshPrisonModel<>(context.bakeLayer(ModelLayers.FLESH_PRISON_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(FleshPrison fleshPrison) {
        return ResourceLocation.fromNamespaceAndPath(ULTRAKILLMOD.MODID,"textures/entity/fleshprison.png");
    }

    @Override
    public void render(FleshPrison entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}

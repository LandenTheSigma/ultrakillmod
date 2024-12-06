package com.ULTRAKILLMOD.init.Entities.client;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Entities.entities.MinosPrime;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MinosPrimeRenderer extends MobRenderer<MinosPrime, MinosPrimeModel<MinosPrime>> {
    public MinosPrimeRenderer(EntityRendererProvider.Context context) {
        super(context, new MinosPrimeModel<MinosPrime>(context.bakeLayer(ModelLayers.MINOS_PRIME_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(MinosPrime minosPrime) {
        return ResourceLocation.fromNamespaceAndPath(ULTRAKILLMOD.MODID,"textures/entity/minosprime.png");
    }

    @Override
    public void render(MinosPrime entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}

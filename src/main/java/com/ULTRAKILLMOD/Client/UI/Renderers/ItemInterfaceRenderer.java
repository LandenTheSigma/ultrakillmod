package com.ULTRAKILLMOD.Client.UI.Renderers;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

@EventBusSubscriber(modid = ULTRAKILLMOD.MODID, value = Dist.CLIENT)
public class ItemInterfaceRenderer {

    private static boolean menuVisible = false; // Track if the menu is visible

    // Toggle menu visibility
    public static void toggleMenu() {
        menuVisible = !menuVisible;
    }

    @SubscribeEvent
    public static void onRenderLevel(RenderLevelStageEvent event) {
        if (!menuVisible) return;

        Minecraft minecraft = Minecraft.getInstance();
        PoseStack poseStack = event.getPoseStack();

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        poseStack.pushPose();
        renderMenu3D(poseStack);
        poseStack.popPose();

        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();

    }

    private static void renderMenu3D(PoseStack poseStack) {
        // Example: Render a flat 3D rectangle in front of the player
        poseStack.translate(0, 1.5, 3); // Adjust position in 3D space
        poseStack.scale(.5F, .5F, .5F); // Scale the menu

        // Render a basic rectangle (replace with actual menu rendering)
        RenderSystem.setShaderColor(0.2f, 0.2f, 0.2f, 0.8f); // Dark semi-transparent gray
        //RenderSystem.enableTexture();


    }

    public static boolean isMenuVisible() {
        return menuVisible;
    }
}

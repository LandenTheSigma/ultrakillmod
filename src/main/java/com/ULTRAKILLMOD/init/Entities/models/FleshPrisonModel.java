package com.ULTRAKILLMOD.init.Entities.models;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Entities.FleshPrison;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FleshPrisonModel extends GeoModel<FleshPrison> {
    public static final ResourceLocation model = ResourceLocation.tryBuild(ULTRAKILLMOD.MODID, "geo/flesh_prison.bbmodel");
    public static final ResourceLocation texture = ResourceLocation.tryBuild(ULTRAKILLMOD.MODID, "textures/flesh_prison.png");
    public static final ResourceLocation animations = ResourceLocation.tryBuild(ULTRAKILLMOD.MODID, "animations/flesh_prison_idle_animation.json");

    @Override
    public ResourceLocation getModelResource(FleshPrison animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(FleshPrison animatable) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(FleshPrison animatable) {
        return this.animations;
    }
}

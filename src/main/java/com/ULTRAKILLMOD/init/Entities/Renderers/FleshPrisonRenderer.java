package com.ULTRAKILLMOD.init.Entities.Renderers;

import com.ULTRAKILLMOD.init.Entities.EntityTypes;
import com.ULTRAKILLMOD.init.Entities.FleshPrison;
import com.ULTRAKILLMOD.init.Entities.models.FleshPrisonModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FleshPrisonRenderer extends GeoEntityRenderer<FleshPrison> {
    public FleshPrisonRenderer(EntityRendererProvider.Context context) {
        super(context, new FleshPrisonModel()); // Pass the model directly here
    }
}


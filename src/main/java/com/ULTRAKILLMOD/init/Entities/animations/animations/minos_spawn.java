package com.ULTRAKILLMOD.init.Entities.animations.animations;// Save this class in your mod and generate all required imports

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

/**
 * Made with Blockbench 4.11.2
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author Author
 */
public class minos_spawn {
	public static final AnimationDefinition spawn = AnimationDefinition.Builder.withLength(52.25F)
		.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 140.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(15.0417F, KeyframeAnimations.degreeVec(-4.0793F, 6.033F, 82.7084F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(30.0417F, KeyframeAnimations.degreeVec(-5.6699F, -4.568F, -11.8487F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(42.4167F, KeyframeAnimations.degreeVec(-0.45F, -7.2639F, -59.5479F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(15.0F, -26.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(15.0417F, KeyframeAnimations.posVec(4.0F, -11.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(30.0417F, KeyframeAnimations.posVec(-3.0F, -12.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(42.4167F, KeyframeAnimations.posVec(-10.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("torso", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 87.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(15.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 47.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(30.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(42.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -30.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("torso", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -22.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(15.0417F, KeyframeAnimations.posVec(-4.0F, -13.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(30.0417F, KeyframeAnimations.posVec(-4.0F, -13.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(42.4167F, KeyframeAnimations.posVec(-4.0F, -13.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 77.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(15.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 77.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(30.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 77.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(42.4167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 77.5F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("legs", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -22.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(15.0417F, KeyframeAnimations.posVec(0.0F, -22.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(30.0417F, KeyframeAnimations.posVec(0.0F, -22.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(42.4167F, KeyframeAnimations.posVec(0.0F, -22.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("LARM", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, -37.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(22.2917F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, -37.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(35.1667F, KeyframeAnimations.degreeVec(-8.6177F, -34.0544F, -112.3563F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(47.5F, KeyframeAnimations.degreeVec(-124.899F, -2.4856F, -138.7104F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("LARM", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(14.0F, 4.0F, -14.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(22.2917F, KeyframeAnimations.posVec(14.0F, 4.0F, -14.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(35.1667F, KeyframeAnimations.posVec(17.0F, 29.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(47.5F, KeyframeAnimations.posVec(-10.0F, 22.0F, -31.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("RARM", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.5451F, 9.0652F, -32.0012F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(22.2917F, KeyframeAnimations.degreeVec(36.55F, 9.07F, -32.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(35.1667F, KeyframeAnimations.degreeVec(115.5102F, 42.3788F, -12.376F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(47.5F, KeyframeAnimations.degreeVec(84.1626F, -40.1145F, -41.7231F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("RARM", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(13.0F, 3.0F, 15.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(22.2917F, KeyframeAnimations.posVec(13.0F, 3.0F, 15.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(35.1667F, KeyframeAnimations.posVec(15.0F, 23.0F, 25.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(47.5F, KeyframeAnimations.posVec(-4.0F, 4.0F, 29.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("RLEG", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(22.2917F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -77.5F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(47.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -77.5F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("RLEG", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(22.2917F, KeyframeAnimations.posVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(47.5F, KeyframeAnimations.posVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("LLEG", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(9.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -40.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(47.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -40.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("LLEG", new AnimationChannel(AnimationChannel.Targets.POSITION, 
			new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(9.125F, KeyframeAnimations.posVec(-11.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
			new Keyframe(47.5F, KeyframeAnimations.posVec(-11.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.build();
}
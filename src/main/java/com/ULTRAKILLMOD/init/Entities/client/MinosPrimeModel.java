package com.ULTRAKILLMOD.init.Entities.client;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.ULTRAKILLMOD.init.Entities.animations.AnimationDefinitions;
import com.ULTRAKILLMOD.init.Entities.entities.MinosPrime;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class MinosPrimeModel<T extends Entity> extends EntityModel<T>  {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ultrakillmod", "minos_prime"), "main");
	private final ModelPart head;

	public MinosPrimeModel(ModelPart head) {
		this.head = head;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(44, 0).addBox(-7.0F, -18.0F, -4.0F, 6.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(44, 15).addBox(-4.0F, -24.0F, -3.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(96, 87).addBox(-2.0F, -21.0F, 1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 97).addBox(-6.0F, -26.0F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 87).addBox(-8.0F, -23.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 97).addBox(-7.0F, -22.0F, 2.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 97).addBox(-4.0F, -24.0F, 2.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(-7.0F, -22.0F, -4.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(96, 82).addBox(-6.0F, -20.0F, -5.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(90, 69).addBox(-5.0F, -21.0F, -4.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(96, 14).addBox(-1.0F, -29.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(96, 23).addBox(-3.0F, -24.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(90, 62).addBox(-5.0F, -1.0F, -3.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -11.0F, 2.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 92).addBox(-5.0F, -1.0F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -10.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(86, 75).addBox(-5.0F, -1.0F, -2.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -11.0F, -2.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r4 = head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(66, 75).addBox(-5.0F, -1.0F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -18.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(18, 91).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, -2.0F, 0.0F, 0.8727F, 0.0F));

		PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(96, 9).addBox(-1.0F, -3.0F, -1.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, 0.0F, 0.8727F, 0.0F, -3.1416F));

		PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(16, 100).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, 0.0F, -1.0036F, 0.0F, -3.1416F));

		PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(8, 99).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 99).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r10 = head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(44, 25).addBox(-3.0F, -5.0F, -1.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 2.0F, 0.0F, 0.8727F, 0.0F));

		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, -27.0F, -2.0F, 5.0F, 30.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -23.0F, -8.0F, 5.0F, 26.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(74, 12).addBox(-9.0F, -2.0F, 1.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(74, 24).addBox(-9.0F, -2.0F, -6.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition cube_r11 = torso.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(16, 75).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -22.0F, 3.0F, -1.1781F, 3.1416F, 0.0F));

		PartDefinition cube_r12 = torso.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 66).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -22.0F, -2.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition cube_r13 = torso.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(78, 93).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -20.0F, 5.0F, 0.6545F, 3.1416F, 0.0F));

		PartDefinition cube_r14 = torso.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(22, 0).addBox(-5.0F, 1.0F, -3.0F, 5.0F, 26.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -24.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r15 = torso.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(62, 93).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -20.0F, -5.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r16 = torso.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(80, 83).addBox(-3.0F, 19.0F, -3.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(32, 87).addBox(-3.0F, 19.0F, -10.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -21.0F, 4.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r17 = torso.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 82).addBox(-3.0F, 19.0F, -3.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(64, 83).addBox(-3.0F, 19.0F, -10.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -27.0F, 4.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r18 = torso.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(32, 77).addBox(-3.0F, 19.0F, -3.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(48, 77).addBox(-3.0F, 19.0F, -10.0F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -33.0F, 4.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r19 = torso.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(18, 61).addBox(-5.0F, 17.0F, -3.0F, 5.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(42, 63).addBox(-5.0F, 17.0F, -12.0F, 5.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -39.0F, 4.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition LARM = torso.addOrReplaceChild("LARM", CubeListBuilder.create().texOffs(92, 50).addBox(-6.0F, -23.0F, -13.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r20 = LARM.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(58, 15).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -17.0F, -8.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r21 = LARM.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(72, 0).addBox(-5.0F, 19.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -23.0F, -10.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RARM = torso.addOrReplaceChild("RARM", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r22 = RARM.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(58, 39).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -17.0F, 8.0F, -0.1745F, 3.1416F, 0.0F));

		PartDefinition cube_r23 = RARM.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(94, 93).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -20.0F, 8.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r24 = RARM.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(66, 63).addBox(-5.0F, 19.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -23.0F, 12.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(74, 50).addBox(-5.0F, 1.0F, -3.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition cube_r25 = legs.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(92, 58).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 9.0F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition cube_r26 = legs.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(54, 97).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition LLEG = legs.addOrReplaceChild("LLEG", CubeListBuilder.create().texOffs(38, 32).addBox(-6.0F, 1.0F, 2.0F, 5.0F, 24.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(74, 36).addBox(-6.0F, 25.0F, 2.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RLEG = legs.addOrReplaceChild("RLEG", CubeListBuilder.create().texOffs(18, 32).addBox(-6.0F, 1.0F, -7.0F, 5.0F, 24.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(74, 43).addBox(-6.0F, 25.0F, -7.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw,headPitch,ageInTicks);

	}

	private void applyHeadRotation(float netHeadYaw,float netHeadPitch,float ageInTicks){
		netHeadYaw = Math.clamp(netHeadYaw,-30,30);
		netHeadPitch = Math.clamp(netHeadPitch,-25,45);

		this.head.yRot = netHeadYaw * ((float) Math.PI / 180f);
		this.head.xRot = netHeadPitch * ((float) Math.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, int i2) {
		head.render(poseStack, vertexConsumer, i,i1,i2);
	}

}
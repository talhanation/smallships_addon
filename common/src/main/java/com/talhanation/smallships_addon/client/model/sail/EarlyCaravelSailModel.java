package com.talhanation.smallships_addon.client.model.sail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCaravelEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

// Sail model exported from Blockbench, registered in AddonClientInitializer.
// It bakes its own root in the constructor, so it needs no layer registration.
public class EarlyCaravelSailModel extends SailModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsAddonMod.MOD_ID, EarlyCaravelEntity.ID + "_sail_model"), "main");

	private final ModelPart EarlyCaravelSail;
	private final ModelPart sail_1;
	private final ModelPart sail_1_4;
	private final ModelPart Base1;
	private final ModelPart Base2;
	private final ModelPart Base3;
	private final ModelPart Base4;
	private final ModelPart Base5;
	private final ModelPart sail_1_3;
	private final ModelPart sail_1_3_bottom;
	private final ModelPart Base6;
	private final ModelPart Base7;
	private final ModelPart Base8;
	private final ModelPart Base9;
	private final ModelPart Base10;
	private final ModelPart Base11;
	private final ModelPart Base12;
	private final ModelPart Base13;
	private final ModelPart Base14;
	private final ModelPart Base15;
	private final ModelPart sail_1_2;
	private final ModelPart sail_1_2_bottom;
	private final ModelPart Base16;
	private final ModelPart Base17;
	private final ModelPart Base18;
	private final ModelPart Base19;
	private final ModelPart Base20;
	private final ModelPart Base21;
	private final ModelPart Base22;
	private final ModelPart Base23;
	private final ModelPart Base24;
	private final ModelPart Base25;
	private final ModelPart Base26;
	private final ModelPart Base27;
	private final ModelPart Base28;
	private final ModelPart Base29;
	private final ModelPart Base30;
	private final ModelPart sail_1_1;
	private final ModelPart sail_1_1_bottom;
	private final ModelPart Base31;
	private final ModelPart Base32;
	private final ModelPart Base33;
	private final ModelPart Base34;
	private final ModelPart Base35;
	private final ModelPart Base36;
	private final ModelPart Base37;
	private final ModelPart Base38;
	private final ModelPart Base39;
	private final ModelPart Base40;
	private final ModelPart Base41;
	private final ModelPart Base42;
	private final ModelPart Base43;
	private final ModelPart Base44;
	private final ModelPart Base45;
	private final ModelPart Base46;
	private final ModelPart Base47;
	private final ModelPart Base48;
	private final ModelPart Base49;
	private final ModelPart Base50;
	private final ModelPart sail_1_0;
	private final ModelPart sail_1_0_bundle;
	private final ModelPart rope_1;
	private final ModelPart cube_r31;
	private final ModelPart cube_r32;
	private final ModelPart cube_r33;
	private final ModelPart rope_2;
	private final ModelPart cube_r34;
	private final ModelPart cube_r35;
	private final ModelPart cube_r36;
	private final ModelPart sail_1_rope_4;
	private final ModelPart cube_r5;
	private final ModelPart cube_r6;
	private final ModelPart cube_r7;
	private final ModelPart sail_1_rope_3;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart sail_1_rope_2;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart cube_r10;
	private final ModelPart sail_1_rope_1;
	private final ModelPart cube_r11;
	private final ModelPart cube_r12;
	private final ModelPart cube_r13;
	private final ModelPart sail_1_rope_0;
	private final ModelPart cube_r14;
	private final ModelPart cube_r15;
	private final ModelPart cube_r16;

	public EarlyCaravelSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.EarlyCaravelSail = root.getChild("EarlyCaravelSail");
		this.sail_1 = this.EarlyCaravelSail.getChild("sail_1");
		this.sail_1_4 = this.sail_1.getChild("sail_1_4");
		this.Base1 = this.sail_1_4.getChild("Base1");
		this.Base2 = this.Base1.getChild("Base2");
		this.Base3 = this.Base2.getChild("Base3");
		this.Base4 = this.Base3.getChild("Base4");
		this.Base5 = this.Base4.getChild("Base5");
		this.sail_1_3 = this.sail_1.getChild("sail_1_3");
		this.sail_1_3_bottom = this.sail_1_3.getChild("sail_1_3_bottom");
		this.Base6 = this.sail_1_3.getChild("Base6");
		this.Base7 = this.Base6.getChild("Base7");
		this.Base8 = this.Base7.getChild("Base8");
		this.Base9 = this.Base8.getChild("Base9");
		this.Base10 = this.Base9.getChild("Base10");
		this.Base11 = this.Base10.getChild("Base11");
		this.Base12 = this.Base11.getChild("Base12");
		this.Base13 = this.Base12.getChild("Base13");
		this.Base14 = this.Base13.getChild("Base14");
		this.Base15 = this.Base14.getChild("Base15");
		this.sail_1_2 = this.sail_1.getChild("sail_1_2");
		this.sail_1_2_bottom = this.sail_1_2.getChild("sail_1_2_bottom");
		this.Base16 = this.sail_1_2.getChild("Base16");
		this.Base17 = this.Base16.getChild("Base17");
		this.Base18 = this.Base17.getChild("Base18");
		this.Base19 = this.Base18.getChild("Base19");
		this.Base20 = this.Base19.getChild("Base20");
		this.Base21 = this.Base20.getChild("Base21");
		this.Base22 = this.Base21.getChild("Base22");
		this.Base23 = this.Base22.getChild("Base23");
		this.Base24 = this.Base23.getChild("Base24");
		this.Base25 = this.Base24.getChild("Base25");
		this.Base26 = this.Base25.getChild("Base26");
		this.Base27 = this.Base26.getChild("Base27");
		this.Base28 = this.Base27.getChild("Base28");
		this.Base29 = this.Base28.getChild("Base29");
		this.Base30 = this.Base29.getChild("Base30");
		this.sail_1_1 = this.sail_1.getChild("sail_1_1");
		this.sail_1_1_bottom = this.sail_1_1.getChild("sail_1_1_bottom");
		this.Base31 = this.sail_1_1.getChild("Base31");
		this.Base32 = this.Base31.getChild("Base32");
		this.Base33 = this.Base32.getChild("Base33");
		this.Base34 = this.Base33.getChild("Base34");
		this.Base35 = this.Base34.getChild("Base35");
		this.Base36 = this.Base35.getChild("Base36");
		this.Base37 = this.Base36.getChild("Base37");
		this.Base38 = this.Base37.getChild("Base38");
		this.Base39 = this.Base38.getChild("Base39");
		this.Base40 = this.Base39.getChild("Base40");
		this.Base41 = this.Base40.getChild("Base41");
		this.Base42 = this.Base41.getChild("Base42");
		this.Base43 = this.Base42.getChild("Base43");
		this.Base44 = this.Base43.getChild("Base44");
		this.Base45 = this.Base44.getChild("Base45");
		this.Base46 = this.Base45.getChild("Base46");
		this.Base47 = this.Base46.getChild("Base47");
		this.Base48 = this.Base47.getChild("Base48");
		this.Base49 = this.Base48.getChild("Base49");
		this.Base50 = this.Base49.getChild("Base50");
		this.sail_1_0 = this.sail_1.getChild("sail_1_0");
		this.sail_1_0_bundle = this.sail_1_0.getChild("sail_1_0_bundle");
		this.rope_1 = this.EarlyCaravelSail.getChild("rope_1");
		this.cube_r31 = this.rope_1.getChild("cube_r31");
		this.cube_r32 = this.rope_1.getChild("cube_r32");
		this.cube_r33 = this.rope_1.getChild("cube_r33");
		this.rope_2 = this.EarlyCaravelSail.getChild("rope_2");
		this.cube_r34 = this.rope_2.getChild("cube_r34");
		this.cube_r35 = this.rope_2.getChild("cube_r35");
		this.cube_r36 = this.rope_2.getChild("cube_r36");
		this.sail_1_rope_4 = this.EarlyCaravelSail.getChild("sail_1_rope_4");
		this.cube_r5 = this.sail_1_rope_4.getChild("cube_r5");
		this.cube_r6 = this.sail_1_rope_4.getChild("cube_r6");
		this.cube_r7 = this.sail_1_rope_4.getChild("cube_r7");
		this.sail_1_rope_3 = this.EarlyCaravelSail.getChild("sail_1_rope_3");
		this.cube_r2 = this.sail_1_rope_3.getChild("cube_r2");
		this.cube_r3 = this.sail_1_rope_3.getChild("cube_r3");
		this.cube_r4 = this.sail_1_rope_3.getChild("cube_r4");
		this.sail_1_rope_2 = this.EarlyCaravelSail.getChild("sail_1_rope_2");
		this.cube_r8 = this.sail_1_rope_2.getChild("cube_r8");
		this.cube_r9 = this.sail_1_rope_2.getChild("cube_r9");
		this.cube_r10 = this.sail_1_rope_2.getChild("cube_r10");
		this.sail_1_rope_1 = this.EarlyCaravelSail.getChild("sail_1_rope_1");
		this.cube_r11 = this.sail_1_rope_1.getChild("cube_r11");
		this.cube_r12 = this.sail_1_rope_1.getChild("cube_r12");
		this.cube_r13 = this.sail_1_rope_1.getChild("cube_r13");
		this.sail_1_rope_0 = this.EarlyCaravelSail.getChild("sail_1_rope_0");
		this.cube_r14 = this.sail_1_rope_0.getChild("cube_r14");
		this.cube_r15 = this.sail_1_rope_0.getChild("cube_r15");
		this.cube_r16 = this.sail_1_rope_0.getChild("cube_r16");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition EarlyCaravelSail = partdefinition.addOrReplaceChild("EarlyCaravelSail", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 42.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition sail_1 = EarlyCaravelSail.addOrReplaceChild("sail_1", CubeListBuilder.create(), PartPose.offset(-10.6924F, -74.134F, -3.5247F));

		PartDefinition sail_1_4 = sail_1.addOrReplaceChild("sail_1_4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base1 = sail_1_4.addOrReplaceChild("Base1", CubeListBuilder.create().texOffs(70, 4).addBox(-1.0F, -4.0F, -61.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(80, 0).addBox(-1.0F, -4.0F, -45.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 7).addBox(-1.0F, -4.0F, -25.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 14).addBox(-1.0F, -4.0F, -5.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1996F, 0.0F, 22.0247F));

		PartDefinition Base2 = Base1.addOrReplaceChild("Base2", CubeListBuilder.create().texOffs(67, 3).addBox(-1.0F, -4.0F, -61.5247F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(80, 3).addBox(-1.0F, -4.0F, -42.5247F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(66, 31).addBox(-1.0F, -4.0F, -23.5247F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(80, 17).addBox(-1.0F, -4.0F, -4.5247F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.017F));

		PartDefinition Base3 = Base2.addOrReplaceChild("Base3", CubeListBuilder.create().texOffs(66, 6).addBox(-1.0F, -4.0F, -57.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(80, 6).addBox(-1.0F, -4.0F, -39.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(66, 34).addBox(-1.0F, -4.0F, -21.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(66, 41).addBox(-1.0F, -4.0F, -3.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0152F));

		PartDefinition Base4 = Base3.addOrReplaceChild("Base4", CubeListBuilder.create().texOffs(66, 9).addBox(-1.0F, -4.0F, -53.5247F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(80, 9).addBox(-1.0F, -4.0F, -36.5247F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(66, 37).addBox(-1.0F, -4.0F, -19.5247F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(66, 0).addBox(-1.0F, -4.0F, -2.5247F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0117F));

		PartDefinition Base5 = Base4.addOrReplaceChild("Base5", CubeListBuilder.create().texOffs(80, 5).addBox(-1.0F, -4.0F, -49.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(65, 19).addBox(-1.0F, -4.0F, -33.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(66, 40).addBox(-1.0F, -4.0F, -17.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(65, 3).addBox(-1.0F, -4.0F, -1.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0069F));

		PartDefinition sail_1_3 = sail_1.addOrReplaceChild("sail_1_3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_1_3_bottom = sail_1_3.addOrReplaceChild("sail_1_3_bottom", CubeListBuilder.create().texOffs(79, 8).addBox(-2.9996F, -1.0F, 0.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(79, 15).addBox(-2.9996F, -1.0F, 20.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(81, 34).addBox(-2.9996F, -1.0F, 40.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -20.0F, -23.5F));

		PartDefinition Base6 = sail_1_3.addOrReplaceChild("Base6", CubeListBuilder.create(), PartPose.offset(-0.1996F, 0.0F, 22.0247F));

		PartDefinition Base7 = Base6.addOrReplaceChild("Base7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.017F));

		PartDefinition Base8 = Base7.addOrReplaceChild("Base8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0152F));

		PartDefinition Base9 = Base8.addOrReplaceChild("Base9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0117F));

		PartDefinition Base10 = Base9.addOrReplaceChild("Base10", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0069F));

		PartDefinition Base11 = Base10.addOrReplaceChild("Base11", CubeListBuilder.create().texOffs(80, 8).addBox(-1.0F, -4.0F, -45.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 15).addBox(-1.0F, -4.0F, -25.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 22).addBox(-1.0F, -4.0F, -5.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0014F));

		PartDefinition Base12 = Base11.addOrReplaceChild("Base12", CubeListBuilder.create().texOffs(66, 32).addBox(-1.0F, -4.0F, -41.5247F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F))
				.texOffs(67, 36).addBox(-1.0F, -4.0F, -22.8581F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F))
				.texOffs(67, 2).addBox(-1.0F, -4.0F, -4.1914F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0042F));

		PartDefinition Base13 = Base12.addOrReplaceChild("Base13", CubeListBuilder.create().texOffs(66, 35).addBox(-1.0F, -4.0F, -37.5247F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F))
				.texOffs(66, 42).addBox(-1.0F, -4.0F, -20.1914F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F))
				.texOffs(66, 5).addBox(-1.0F, -4.0F, -2.8581F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0094F));

		PartDefinition Base14 = Base13.addOrReplaceChild("Base14", CubeListBuilder.create().texOffs(66, 38).addBox(-1.0F, -4.0F, -33.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(65, 1).addBox(-1.0F, -4.0F, -17.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(65, 26).addBox(-1.0F, -4.0F, -1.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0136F));

		PartDefinition Base15 = Base14.addOrReplaceChild("Base15", CubeListBuilder.create().texOffs(66, 41).addBox(-1.0F, -4.0F, -29.5247F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F))
				.texOffs(65, 4).addBox(-1.0F, -4.0F, -14.8581F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F))
				.texOffs(65, 11).addBox(-1.0F, -4.0F, -0.1914F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0163F));

		PartDefinition sail_1_2 = sail_1.addOrReplaceChild("sail_1_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_1_2_bottom = sail_1_2.addOrReplaceChild("sail_1_2_bottom", CubeListBuilder.create().texOffs(64, 19).addBox(-4.2996F, -1.0F, 0.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(78, 19).addBox(-4.2996F, -1.0F, 20.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -40.0F, -3.5F));

		PartDefinition Base16 = sail_1_2.addOrReplaceChild("Base16", CubeListBuilder.create(), PartPose.offset(-0.1996F, 0.0F, 22.0247F));

		PartDefinition Base17 = Base16.addOrReplaceChild("Base17", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.017F));

		PartDefinition Base18 = Base17.addOrReplaceChild("Base18", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0152F));

		PartDefinition Base19 = Base18.addOrReplaceChild("Base19", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0117F));

		PartDefinition Base20 = Base19.addOrReplaceChild("Base20", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0069F));

		PartDefinition Base21 = Base20.addOrReplaceChild("Base21", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0014F));

		PartDefinition Base22 = Base21.addOrReplaceChild("Base22", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0042F));

		PartDefinition Base23 = Base22.addOrReplaceChild("Base23", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0094F));

		PartDefinition Base24 = Base23.addOrReplaceChild("Base24", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0136F));

		PartDefinition Base25 = Base24.addOrReplaceChild("Base25", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0163F));

		PartDefinition Base26 = Base25.addOrReplaceChild("Base26", CubeListBuilder.create().texOffs(66, 0).addBox(-1.0F, -4.0F, -25.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(74, 0).addBox(-1.0F, -4.0F, -5.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0172F));

		PartDefinition Base27 = Base26.addOrReplaceChild("Base27", CubeListBuilder.create().texOffs(71, 26).addBox(-1.0F, -4.0F, -21.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(73, 0).addBox(-1.0F, -4.0F, -3.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0163F));

		PartDefinition Base28 = Base27.addOrReplaceChild("Base28", CubeListBuilder.create().texOffs(65, 6).addBox(-1.0F, -4.0F, -17.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(80, 6).addBox(-1.0F, -4.0F, -1.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0136F));

		PartDefinition Base29 = Base28.addOrReplaceChild("Base29", CubeListBuilder.create().texOffs(65, 9).addBox(-1.0F, -4.0F, -13.5247F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(80, 9).addBox(-1.0F, -4.0F, 0.4753F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0094F));

		PartDefinition Base30 = Base29.addOrReplaceChild("Base30", CubeListBuilder.create().texOffs(65, 12).addBox(-1.0F, -4.0F, -9.5247F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(66, 24).addBox(-1.0F, -4.0F, 2.4753F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0042F));

		PartDefinition sail_1_1 = sail_1.addOrReplaceChild("sail_1_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_1_1_bottom = sail_1_1.addOrReplaceChild("sail_1_1_bottom", CubeListBuilder.create().texOffs(78, 0).addBox(-2.4996F, 0.0F, 0.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -60.0F, 16.5F));

		PartDefinition Base31 = sail_1_1.addOrReplaceChild("Base31", CubeListBuilder.create(), PartPose.offset(-0.1996F, 0.0F, 22.0247F));

		PartDefinition Base32 = Base31.addOrReplaceChild("Base32", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.017F));

		PartDefinition Base33 = Base32.addOrReplaceChild("Base33", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0152F));

		PartDefinition Base34 = Base33.addOrReplaceChild("Base34", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0117F));

		PartDefinition Base35 = Base34.addOrReplaceChild("Base35", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0069F));

		PartDefinition Base36 = Base35.addOrReplaceChild("Base36", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0014F));

		PartDefinition Base37 = Base36.addOrReplaceChild("Base37", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0042F));

		PartDefinition Base38 = Base37.addOrReplaceChild("Base38", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0094F));

		PartDefinition Base39 = Base38.addOrReplaceChild("Base39", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0136F));

		PartDefinition Base40 = Base39.addOrReplaceChild("Base40", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0163F));

		PartDefinition Base41 = Base40.addOrReplaceChild("Base41", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0172F));

		PartDefinition Base42 = Base41.addOrReplaceChild("Base42", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0163F));

		PartDefinition Base43 = Base42.addOrReplaceChild("Base43", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0136F));

		PartDefinition Base44 = Base43.addOrReplaceChild("Base44", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0094F));

		PartDefinition Base45 = Base44.addOrReplaceChild("Base45", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0042F));

		PartDefinition Base46 = Base45.addOrReplaceChild("Base46", CubeListBuilder.create().texOffs(80, 8).addBox(-1.0F, -4.0F, -5.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0014F));

		PartDefinition Base47 = Base46.addOrReplaceChild("Base47", CubeListBuilder.create().texOffs(65, 18).addBox(-1.0F, -4.0F, -1.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0069F));

		PartDefinition Base48 = Base47.addOrReplaceChild("Base48", CubeListBuilder.create().texOffs(66, 26).addBox(-1.0F, -4.0F, 2.4753F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0117F));

		PartDefinition Base49 = Base48.addOrReplaceChild("Base49", CubeListBuilder.create().texOffs(65, 24).addBox(-1.0F, -4.0F, 6.4753F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0152F));

		PartDefinition Base50 = Base49.addOrReplaceChild("Base50", CubeListBuilder.create().texOffs(65, 27).addBox(-1.0F, -4.0F, 10.4753F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.017F));

		PartDefinition sail_1_0 = sail_1.addOrReplaceChild("sail_1_0", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_1_0_bundle = sail_1_0.addOrReplaceChild("sail_1_0_bundle", CubeListBuilder.create(), PartPose.offset(-0.2F, 0.0F, -43.5F));

		PartDefinition cube_r1 = sail_1_0_bundle.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(85, 29).addBox(-3.0F, -3.0F, 100.5663F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(73, 23).addBox(-3.0F, -3.0F, 87.9955F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(90, 41).addBox(-3.0F, -3.0F, 75.4247F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(77, 13).addBox(-3.0F, -3.0F, 62.8539F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(69, 25).addBox(-3.0F, -3.0F, 50.2831F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(89, 9).addBox(-3.0F, -3.0F, 37.7124F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(67, 0).addBox(-3.0F, -3.0F, 25.1416F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(85, 19).addBox(-3.0F, -3.0F, 12.5708F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(65, 22).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rope_1 = EarlyCaravelSail.addOrReplaceChild("rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.9F, -42.4146F, 50.8099F, 0.5323F, 0.0F, 0.0F));

		PartDefinition cube_r31 = rope_1.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(3, 26).addBox(-3.5499F, -0.6478F, -25.1246F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(13.4501F, -0.6478F, -25.1246F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(19.4501F, -0.6478F, -25.1246F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(2.4501F, 0.6022F, -25.1246F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(2.4501F, -1.8978F, -25.1246F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(27.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(40.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(53.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(66.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(79.4501F, -0.6478F, -25.1246F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r32 = rope_1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(12, 10).addBox(-16.1163F, -16.4253F, -8.6246F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r33 = rope_1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(19, 4).addBox(-14.9663F, -15.1753F, -8.6246F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_2 = EarlyCaravelSail.addOrReplaceChild("rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6F, -47.4146F, -42.1901F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r34 = rope_2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(24.2601F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(37.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(50.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(63.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(76.2601F, -0.6478F, -17.7881F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r35 = rope_2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r36 = rope_2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_4 = EarlyCaravelSail.addOrReplaceChild("sail_1_rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-23.5F, -31.4146F, 23.3099F, -0.0785F, 0.0F, -0.2531F));

		PartDefinition cube_r5 = sail_1_rope_4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 24).addBox(15.2601F, -0.6478F, -17.7881F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(3.3704F, 0.6356F, -18.1116F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(3.3704F, -1.8644F, -18.1116F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r6 = sail_1_rope_4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(9, 10).addBox(-15.4891F, -15.751F, -1.6116F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r7 = sail_1_rope_4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(16, 4).addBox(-14.3391F, -14.501F, -1.6116F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_3 = EarlyCaravelSail.addOrReplaceChild("sail_1_rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-23.5F, -31.4146F, 23.3099F, -0.0349F, 0.0F, -0.1658F));

		PartDefinition cube_r2 = sail_1_rope_3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2601F, -0.6478F, -17.7881F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(5.3392F, 0.6062F, -18.0004F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(5.3392F, -1.8938F, -18.0004F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = sail_1_rope_3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(9, 10).addBox(-14.0762F, -14.3796F, -1.5004F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r4 = sail_1_rope_3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 4).addBox(-12.9262F, -13.1296F, -1.5004F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_2 = EarlyCaravelSail.addOrReplaceChild("sail_1_rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-23.5F, -31.4146F, 23.3099F, -0.0174F, 0.0015F, -0.1222F));

		PartDefinition cube_r8 = sail_1_rope_2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(3, 25).addBox(-6.7398F, -0.6478F, -17.7881F, 17.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.2601F, -0.6478F, -17.7881F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(54.2601F, -0.6478F, -17.7881F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.3746F, 0.6894F, -18.0862F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.3746F, -1.8106F, -18.0862F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r9 = sail_1_rope_2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(9, 10).addBox(-6.3319F, -6.5176F, -1.5862F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r10 = sail_1_rope_2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 4).addBox(-5.1819F, -5.2676F, -1.5862F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_1 = EarlyCaravelSail.addOrReplaceChild("sail_1_rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-23.5F, -31.4146F, 23.3099F, -0.0174F, 0.0015F, -0.0873F));

		PartDefinition cube_r11 = sail_1_rope_1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(3, 25).addBox(-6.7398F, -0.6478F, -17.7881F, 17.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(54.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(73.2602F, -0.6478F, -17.7881F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(23.3395F, 0.7022F, -18.2075F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(23.3395F, -1.7978F, -18.2075F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r12 = sail_1_rope_1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(9, 10).addBox(-1.416F, -1.5835F, -1.7075F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r13 = sail_1_rope_1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(16, 4).addBox(-0.266F, -0.3335F, -1.7075F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_0 = EarlyCaravelSail.addOrReplaceChild("sail_1_rope_0", CubeListBuilder.create(), PartPose.offsetAndRotation(-23.5F, -31.4146F, 23.3099F, -0.0261F, -0.0159F, -0.0786F));

		PartDefinition cube_r14 = sail_1_rope_0.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(4, 25).addBox(-6.7398F, -0.6478F, -17.7881F, 17.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(27.2601F, -0.6478F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 24).addBox(49.2601F, -0.6478F, -17.7881F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(54.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(73.2602F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(92.2602F, -0.6478F, -17.7881F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(37.3889F, 0.6084F, -17.885F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(37.3889F, -1.8916F, -17.885F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r15 = sail_1_rope_0.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(9, 10).addBox(8.5848F, 8.2845F, -1.385F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r16 = sail_1_rope_0.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(16, 4).addBox(9.7348F, 9.5345F, -1.385F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(@NotNull Ship ship, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		byte state = ship.getData(Ship.SAIL_STATE);

		showSail(state, this.sail_1_0, this.sail_1_1, this.sail_1_2, this.sail_1_3, this.sail_1_4, this.sail_1_1_bottom, this.sail_1_2_bottom, this.sail_1_3_bottom);

		this.sail_1_rope_0.visible = state == 0;
		this.sail_1_rope_1.visible = state == 1;
		this.sail_1_rope_2.visible = state == 2;
		this.sail_1_rope_3.visible = state == 3;
		this.sail_1_rope_4.visible = state == 4;
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		EarlyCaravelSail.render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}
}

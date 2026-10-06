package com.talhanation.smallships_addon.client.model.sail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCaravelEntity;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class FishingBoatSailModel extends SailModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsAddonMod.MOD_ID, FishingBoatEntity.ID + "_sail_model"), "main");

	private final ModelPart FishingBoatSail;
	private final ModelPart sail_rope_0;
	private final ModelPart cube_r20;
	private final ModelPart cube_r21;
	private final ModelPart cube_r22;
	private final ModelPart sail_rope_1;
	private final ModelPart cube_r17;
	private final ModelPart cube_r18;
	private final ModelPart cube_r19;
	private final ModelPart sail_rope_2;
	private final ModelPart cube_r23;
	private final ModelPart cube_r24;
	private final ModelPart cube_r25;
	private final ModelPart sail_rope_3;
	private final ModelPart cube_r26;
	private final ModelPart cube_r27;
	private final ModelPart cube_r28;
	private final ModelPart sail_rope_4;
	private final ModelPart cube_r29;
	private final ModelPart cube_r30;
	private final ModelPart cube_r40;
	private final ModelPart sail;
	private final ModelPart sail_4;
	private final ModelPart Base51;
	private final ModelPart Base52;
	private final ModelPart Base53;
	private final ModelPart sail_3;
	private final ModelPart sail_3_bottom;
	private final ModelPart Base54;
	private final ModelPart Base55;
	private final ModelPart Base56;
	private final ModelPart Base57;
	private final ModelPart Base58;
	private final ModelPart Base59;
	private final ModelPart sail_2;
	private final ModelPart sail_2_bottom;
	private final ModelPart Base60;
	private final ModelPart Base61;
	private final ModelPart Base62;
	private final ModelPart Base63;
	private final ModelPart Base64;
	private final ModelPart Base65;
	private final ModelPart Base66;
	private final ModelPart Base67;
	private final ModelPart Base68;
	private final ModelPart sail_1;
	private final ModelPart sail_1_bottom;
	private final ModelPart Base69;
	private final ModelPart Base70;
	private final ModelPart Base71;
	private final ModelPart Base72;
	private final ModelPart Base73;
	private final ModelPart Base74;
	private final ModelPart Base75;
	private final ModelPart Base76;
	private final ModelPart Base77;
	private final ModelPart Base78;
	private final ModelPart Base79;
	private final ModelPart Base80;
	private final ModelPart sail_0;
	private final ModelPart sail_2_0_bundle;

	public FishingBoatSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.FishingBoatSail = root.getChild("FishingBoatSail");
		this.sail_rope_0 = this.FishingBoatSail.getChild("sail_rope_0");
		this.cube_r20 = this.sail_rope_0.getChild("cube_r20");
		this.cube_r21 = this.sail_rope_0.getChild("cube_r21");
		this.cube_r22 = this.sail_rope_0.getChild("cube_r22");
		this.sail_rope_1 = this.FishingBoatSail.getChild("sail_rope_1");
		this.cube_r17 = this.sail_rope_1.getChild("cube_r17");
		this.cube_r18 = this.sail_rope_1.getChild("cube_r18");
		this.cube_r19 = this.sail_rope_1.getChild("cube_r19");
		this.sail_rope_2 = this.FishingBoatSail.getChild("sail_rope_2");
		this.cube_r23 = this.sail_rope_2.getChild("cube_r23");
		this.cube_r24 = this.sail_rope_2.getChild("cube_r24");
		this.cube_r25 = this.sail_rope_2.getChild("cube_r25");
		this.sail_rope_3 = this.FishingBoatSail.getChild("sail_rope_3");
		this.cube_r26 = this.sail_rope_3.getChild("cube_r26");
		this.cube_r27 = this.sail_rope_3.getChild("cube_r27");
		this.cube_r28 = this.sail_rope_3.getChild("cube_r28");
		this.sail_rope_4 = this.FishingBoatSail.getChild("sail_rope_4");
		this.cube_r29 = this.sail_rope_4.getChild("cube_r29");
		this.cube_r30 = this.sail_rope_4.getChild("cube_r30");
		this.cube_r40 = this.sail_rope_4.getChild("cube_r40");
		this.sail = this.FishingBoatSail.getChild("sail");
		this.sail_4 = this.sail.getChild("sail_4");
		this.Base51 = this.sail_4.getChild("Base51");
		this.Base52 = this.Base51.getChild("Base52");
		this.Base53 = this.Base52.getChild("Base53");
		this.sail_3 = this.sail.getChild("sail_3");
		this.sail_3_bottom = this.sail_3.getChild("sail_3_bottom");
		this.Base54 = this.sail_3.getChild("Base54");
		this.Base55 = this.Base54.getChild("Base55");
		this.Base56 = this.Base55.getChild("Base56");
		this.Base57 = this.Base56.getChild("Base57");
		this.Base58 = this.Base57.getChild("Base58");
		this.Base59 = this.Base58.getChild("Base59");
		this.sail_2 = this.sail.getChild("sail_2");
		this.sail_2_bottom = this.sail_2.getChild("sail_2_bottom");
		this.Base60 = this.sail_2.getChild("Base60");
		this.Base61 = this.Base60.getChild("Base61");
		this.Base62 = this.Base61.getChild("Base62");
		this.Base63 = this.Base62.getChild("Base63");
		this.Base64 = this.Base63.getChild("Base64");
		this.Base65 = this.Base64.getChild("Base65");
		this.Base66 = this.Base65.getChild("Base66");
		this.Base67 = this.Base66.getChild("Base67");
		this.Base68 = this.Base67.getChild("Base68");
		this.sail_1 = this.sail.getChild("sail_1");
		this.sail_1_bottom = this.sail_1.getChild("sail_1_bottom");
		this.Base69 = this.sail_1.getChild("Base69");
		this.Base70 = this.Base69.getChild("Base70");
		this.Base71 = this.Base70.getChild("Base71");
		this.Base72 = this.Base71.getChild("Base72");
		this.Base73 = this.Base72.getChild("Base73");
		this.Base74 = this.Base73.getChild("Base74");
		this.Base75 = this.Base74.getChild("Base75");
		this.Base76 = this.Base75.getChild("Base76");
		this.Base77 = this.Base76.getChild("Base77");
		this.Base78 = this.Base77.getChild("Base78");
		this.Base79 = this.Base78.getChild("Base79");
		this.Base80 = this.Base79.getChild("Base80");
		this.sail_0 = this.sail.getChild("sail_0");
		this.sail_2_0_bundle = this.sail_0.getChild("sail_2_0_bundle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition FishingBoatSail = partdefinition.addOrReplaceChild("FishingBoatSail", CubeListBuilder.create(), PartPose.offsetAndRotation(15.1263F, 6.9197F, 15.0749F, 0.0F, 1.5708F, 0.0F));

		PartDefinition sail_rope_0 = FishingBoatSail.addOrReplaceChild("sail_rope_0", CubeListBuilder.create(), PartPose.offsetAndRotation(0.7279F, 5.7946F, 0.2346F, 0.0873F, 0.2122F, 0.0642F));

		PartDefinition cube_r20 = sail_rope_0.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7399F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2602F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2602F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2602F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(54.2602F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r21 = sail_rope_0.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r22 = sail_rope_0.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_rope_1 = FishingBoatSail.addOrReplaceChild("sail_rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.7354F, 5.8559F, 0.2343F, 0.1311F, 0.2361F, 0.1016F));

		PartDefinition cube_r17 = sail_rope_1.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7399F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2602F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2602F, -0.6478F, -17.7881F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r18 = sail_rope_1.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r19 = sail_rope_1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_rope_2 = FishingBoatSail.addOrReplaceChild("sail_rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.7434F, 5.9135F, 0.2337F, 0.1761F, 0.2206F, 0.1292F));

		PartDefinition cube_r23 = sail_rope_2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7399F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r24 = sail_rope_2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r25 = sail_rope_2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_rope_3 = FishingBoatSail.addOrReplaceChild("sail_rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.7533F, 6.0008F, 0.2331F, 0.2223F, 0.2344F, 0.1753F));

		PartDefinition cube_r26 = sail_rope_3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7399F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r27 = sail_rope_3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r28 = sail_rope_3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_rope_4 = FishingBoatSail.addOrReplaceChild("sail_rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.7639F, 6.1608F, 0.231F, 0.3202F, 0.2855F, 0.2687F));

		PartDefinition cube_r29 = sail_rope_4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7399F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r30 = sail_rope_4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r40 = sail_rope_4.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail = FishingBoatSail.addOrReplaceChild("sail", CubeListBuilder.create(), PartPose.offset(7.1313F, -28.3286F, -1.1747F));

		PartDefinition sail_4 = sail.addOrReplaceChild("sail_4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base51 = sail_4.addOrReplaceChild("Base51", CubeListBuilder.create().texOffs(92, 32).addBox(-1.0F, -4.0F, -12.5624F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(71, 31).addBox(-1.0F, -4.0F, 3.4376F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(80, 7).addBox(-1.0F, -4.0F, 19.4376F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.4486F, 0.0F, -36.9753F));

		PartDefinition Base52 = Base51.addOrReplaceChild("Base52", CubeListBuilder.create().texOffs(94, 22).addBox(-1.0F, -4.0F, -8.5581F, 2.0F, 4.0F, 14.6652F, new CubeDeformation(0.0F))
				.texOffs(94, 22).addBox(-1.0F, -4.0F, 6.1072F, 2.0F, 4.0F, 14.6652F, new CubeDeformation(0.0F))
				.texOffs(65, 28).addBox(-1.0F, -4.0F, 20.7724F, 2.0F, 4.0F, 14.6652F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0283F));

		PartDefinition Base53 = Base52.addOrReplaceChild("Base53", CubeListBuilder.create().texOffs(84, 24).addBox(-1.0F, -4.0F, -4.5624F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 6).addBox(-1.0F, -4.0F, 15.4376F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0193F));

		PartDefinition sail_3 = sail.addOrReplaceChild("sail_3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_3_bottom = sail_3.addOrReplaceChild("sail_3_bottom", CubeListBuilder.create().texOffs(86, 43).addBox(-6.7486F, 0.0F, -6.0377F, 3.0F, 3.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(86, 14).addBox(-6.7486F, 0.0F, 11.9623F, 3.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -12.0F, -31.5F));

		PartDefinition Base54 = sail_3.addOrReplaceChild("Base54", CubeListBuilder.create(), PartPose.offset(-5.4486F, 0.0F, -36.9753F));

		PartDefinition Base55 = Base54.addOrReplaceChild("Base55", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0283F));

		PartDefinition Base56 = Base55.addOrReplaceChild("Base56", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0193F));

		PartDefinition Base57 = Base56.addOrReplaceChild("Base57", CubeListBuilder.create().texOffs(80, 2).addBox(-1.0F, -4.0F, -0.5624F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(80, 9).addBox(-1.0F, -4.0F, 17.4376F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0042F));

		PartDefinition Base58 = Base57.addOrReplaceChild("Base58", CubeListBuilder.create().texOffs(92, 16).addBox(-1.0F, -4.0F, 3.4376F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(65, 19).addBox(-1.0F, -4.0F, 19.4376F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0123F));

		PartDefinition Base59 = Base58.addOrReplaceChild("Base59", CubeListBuilder.create().texOffs(80, 8).addBox(-1.0F, -4.0F, 7.4376F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(66, 36).addBox(-1.0F, -4.0F, 21.4376F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0248F));

		PartDefinition sail_2 = sail.addOrReplaceChild("sail_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_2_bottom = sail_2.addOrReplaceChild("sail_2_bottom", CubeListBuilder.create().texOffs(84, 20).addBox(-7.2486F, 0.0F, -6.0377F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(66, 39).addBox(-7.2486F, 0.0F, 5.9623F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -24.0F, -19.5F));

		PartDefinition Base60 = sail_2.addOrReplaceChild("Base60", CubeListBuilder.create(), PartPose.offset(-5.4486F, 0.0F, -36.9753F));

		PartDefinition Base61 = Base60.addOrReplaceChild("Base61", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0283F));

		PartDefinition Base62 = Base61.addOrReplaceChild("Base62", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0193F));

		PartDefinition Base63 = Base62.addOrReplaceChild("Base63", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0042F));

		PartDefinition Base64 = Base63.addOrReplaceChild("Base64", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0123F));

		PartDefinition Base65 = Base64.addOrReplaceChild("Base65", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0248F));

		PartDefinition Base66 = Base65.addOrReplaceChild("Base66", CubeListBuilder.create().texOffs(80, 11).addBox(-1.0F, -4.0F, 11.4376F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(66, 39).addBox(-1.0F, -4.0F, 23.4376F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0295F));

		PartDefinition Base67 = Base66.addOrReplaceChild("Base67", CubeListBuilder.create().texOffs(68, 31).addBox(-1.0F, -4.0F, 15.4376F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0248F));

		PartDefinition Base68 = Base67.addOrReplaceChild("Base68", CubeListBuilder.create().texOffs(66, 38).addBox(-1.0F, -4.0F, 19.4376F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0123F));

		PartDefinition sail_1 = sail.addOrReplaceChild("sail_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_1_bottom = sail_1.addOrReplaceChild("sail_1_bottom", CubeListBuilder.create().texOffs(94, 41).addBox(-7.7486F, 0.0F, -6.0377F, 5.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -36.0F, -7.5F));

		PartDefinition Base69 = sail_1.addOrReplaceChild("Base69", CubeListBuilder.create(), PartPose.offset(-5.4486F, 0.0F, -36.9753F));

		PartDefinition Base70 = Base69.addOrReplaceChild("Base70", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0283F));

		PartDefinition Base71 = Base70.addOrReplaceChild("Base71", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0193F));

		PartDefinition Base72 = Base71.addOrReplaceChild("Base72", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0042F));

		PartDefinition Base73 = Base72.addOrReplaceChild("Base73", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0123F));

		PartDefinition Base74 = Base73.addOrReplaceChild("Base74", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0248F));

		PartDefinition Base75 = Base74.addOrReplaceChild("Base75", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0295F));

		PartDefinition Base76 = Base75.addOrReplaceChild("Base76", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0248F));

		PartDefinition Base77 = Base76.addOrReplaceChild("Base77", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0123F));

		PartDefinition Base78 = Base77.addOrReplaceChild("Base78", CubeListBuilder.create().texOffs(66, 41).addBox(-1.0F, -4.0F, 23.4376F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0042F));

		PartDefinition Base79 = Base78.addOrReplaceChild("Base79", CubeListBuilder.create().texOffs(65, 0).addBox(-1.0F, -4.0F, 27.4376F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0193F));

		PartDefinition Base80 = Base79.addOrReplaceChild("Base80", CubeListBuilder.create().texOffs(65, 3).addBox(-1.0F, -4.0F, 31.4376F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0283F));

		PartDefinition sail_0 = sail.addOrReplaceChild("sail_0", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_2_0_bundle = sail_0.addOrReplaceChild("sail_2_0_bundle", CubeListBuilder.create(), PartPose.offset(-0.2F, 0.0F, -43.5F));

		PartDefinition cube_r1 = sail_2_0_bundle.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(88, 27).addBox(-7.5886F, -7.6338F, 49.672F, 6.0F, 6.0F, 13.5764F, new CubeDeformation(0.0F))
				.texOffs(88, 0).addBox(-7.5886F, -7.6338F, 36.0955F, 6.0F, 6.0F, 13.5765F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-7.5886F, -7.6338F, 22.5191F, 6.0F, 6.0F, 13.5765F, new CubeDeformation(0.0F))
				.texOffs(88, 44).addBox(-7.5886F, -7.6338F, 8.9426F, 6.0F, 6.0F, 13.5764F, new CubeDeformation(0.0F))
				.texOffs(66, 33).addBox(-7.5886F, -7.6338F, -4.6338F, 6.0F, 6.0F, 13.5765F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}


	@Override
	public void setupAnim(@NotNull Ship ship, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		byte state = ship.getData(Ship.SAIL_STATE);

		showSail(state, this.sail_0, this.sail_1, this.sail_2, this.sail_3, this.sail_4, this.sail_1_bottom, this.sail_2_bottom, this.sail_3_bottom);

		this.sail_rope_0.visible = state == 0;
		this.sail_rope_1.visible = state == 1;
		this.sail_rope_2.visible = state == 2;
		this.sail_rope_3.visible = state == 3;
		this.sail_rope_4.visible = state == 4;
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		FishingBoatSail.render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}
}

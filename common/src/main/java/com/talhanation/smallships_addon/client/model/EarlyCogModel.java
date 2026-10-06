package com.talhanation.smallships_addon.client.model;

import com.talhanation.smallships.client.model.ShipModel;
import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.world.entity.ship.EarlyCogEntity;
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


// Hull model exported from Blockbench.
public class EarlyCogModel extends ShipModel<EarlyCogEntity> {
	// register this layer with createBodyLayer() in the loader module (forge ClientModBus / fabric client)
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsAddonMod.MOD_ID, EarlyCogEntity.ID + "_model"), "main");

	private final ModelPart EarlyCog;
	private final ModelPart deck;
	private final ModelPart cube_r1;
	private final ModelPart bottom;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart sides;
	private final ModelPart cube_r4;
	private final ModelPart cube_r5;
	private final ModelPart mast_1;
	private final ModelPart cube_r6;
	private final ModelPart mast_oben;
	private final ModelPart chest_1;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart cube_r10;
	private final ModelPart chest_4;
	private final ModelPart cube_r11;
	private final ModelPart cube_r12;
	private final ModelPart cube_r13;
	private final ModelPart chest_2;
	private final ModelPart cube_r14;
	private final ModelPart cube_r15;
	private final ModelPart cube_r16;
	private final ModelPart chest_3;
	private final ModelPart cube_r17;
	private final ModelPart cube_r18;
	private final ModelPart steer;
	private final ModelPart BannerStick;

	public EarlyCogModel(ModelPart root) {
		this.EarlyCog = root.getChild("EarlyCog");
		this.deck = this.EarlyCog.getChild("deck");
		this.cube_r1 = this.deck.getChild("cube_r1");
		this.bottom = this.EarlyCog.getChild("bottom");
		this.cube_r2 = this.bottom.getChild("cube_r2");
		this.cube_r3 = this.bottom.getChild("cube_r3");
		this.sides = this.EarlyCog.getChild("sides");
		this.cube_r4 = this.sides.getChild("cube_r4");
		this.cube_r5 = this.sides.getChild("cube_r5");
		this.mast_1 = this.EarlyCog.getChild("mast_1");
		this.cube_r6 = this.mast_1.getChild("cube_r6");
		this.mast_oben = this.EarlyCog.getChild("mast_oben");
		this.chest_1 = this.EarlyCog.getChild("chest_1");
		this.cube_r7 = this.chest_1.getChild("cube_r7");
		this.cube_r8 = this.chest_1.getChild("cube_r8");
		this.cube_r9 = this.chest_1.getChild("cube_r9");
		this.cube_r10 = this.chest_1.getChild("cube_r10");
		this.chest_4 = this.EarlyCog.getChild("chest_4");
		this.cube_r11 = this.chest_4.getChild("cube_r11");
		this.cube_r12 = this.chest_4.getChild("cube_r12");
		this.cube_r13 = this.chest_4.getChild("cube_r13");
		this.chest_2 = this.EarlyCog.getChild("chest_2");
		this.cube_r14 = this.chest_2.getChild("cube_r14");
		this.cube_r15 = this.chest_2.getChild("cube_r15");
		this.cube_r16 = this.chest_2.getChild("cube_r16");
		this.chest_3 = this.EarlyCog.getChild("chest_3");
		this.cube_r17 = this.chest_3.getChild("cube_r17");
		this.cube_r18 = this.chest_3.getChild("cube_r18");
		this.steer = this.EarlyCog.getChild("steer");
		this.BannerStick = this.EarlyCog.getChild("BannerStick");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition EarlyCog = partdefinition.addOrReplaceChild("EarlyCog", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition deck = EarlyCog.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(14.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = deck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 0).addBox(28.0F, 0.0F, 2.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(28.0F, -13.0F, 2.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 0.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(30, 0).addBox(-40.0F, -6.5F, 7.0F, 12.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-13.0F, -16.0F, 2.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-13.0F, 13.0F, 2.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, 0.0F, 2.0F, 28.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -13.0F, 2.0F, 28.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 16.0F, 2.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -19.0F, 2.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -16.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition bottom = EarlyCog.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(4, 1).addBox(42.0F, -11.0F, -3.5F, 4.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bottom.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(4, 1).addBox(-3.0F, -13.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(4, 1).addBox(-3.0F, -6.5F, -3.5F, 7.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.44F, 2.4938F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r3 = bottom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(38.0F, -2.0F, -10.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(16.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, 2.0F, -3.0F, 22.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -12.0F, -3.0F, 22.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -12.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, -12.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, 2.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, 2.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition sides = EarlyCog.addOrReplaceChild("sides", CubeListBuilder.create().texOffs(8, 36).addBox(-28.0F, -11.0F, -16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-13.0F, -11.0F, -19.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(0.0F, -11.0F, -22.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(18.0F, -11.0F, -19.0F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-28.0F, -11.0F, 13.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-13.0F, -11.0F, 16.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(28.0F, -11.0F, -16.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(28.0F, -17.0F, -16.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(37.0F, -17.0F, -16.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(28.0F, -17.0F, 13.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(37.0F, -17.0F, 13.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-35.0F, -16.0F, -6.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-35.0F, -16.0F, 4.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-31.0F, -16.0F, 4.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-31.0F, -16.0F, -6.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-38.0F, -16.0F, 4.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-38.0F, -16.0F, -6.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(28.0F, -11.0F, 13.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(0.0F, -11.0F, 19.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(18.0F, -11.0F, 16.0F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = sides.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 36).addBox(-23.0F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-6.0F, -8.0F, -75.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-11.0F, -8.0F, -75.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-16.0F, -8.0F, -75.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-23.0F, -9.0F, 6.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-1.5F, -9.0F, 6.5F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-14.0F, -9.0F, 6.5F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-9.5F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.0F, -8.0F, -9.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r5 = sides.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 36).addBox(3.5F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-9.5F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.5F, -8.0F, -3.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition mast_1 = EarlyCog.addOrReplaceChild("mast_1", CubeListBuilder.create().texOffs(8, 0).addBox(-3.0F, -15.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-3.0F, -30.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-3.0F, -45.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-3.0F, -60.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-3.0F, -75.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(13.4F, -5.0F, -1.0F));

		PartDefinition cube_r6 = mast_1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(8, 0).addBox(-6.0F, -7.5F, -1.5F, 3.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-47.5F, -15.5F, 1.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition mast_oben = EarlyCog.addOrReplaceChild("mast_oben", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -69.0F, -16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(7, 7).addBox(9.0F, -69.0F, -25.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -69.0F, 0.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(7, 7).addBox(9.0F, -69.0F, 16.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.6F, 0.0F, 0.0F));

		PartDefinition chest_1 = EarlyCog.addOrReplaceChild("chest_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest_1_r1 = chest_1.addOrReplaceChild("chest_1_r1", CubeListBuilder.create().texOffs(96, 38).addBox(-13.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.0F, -9.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = chest_1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 55).addBox(-0.25F, 3.65F, -0.25F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.75F, -11.75F, -8.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r8 = chest_1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 55).addBox(-1.0F, 5.5F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, -15.5F, -18.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = chest_1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 55).addBox(57.0F, -19.0F, 25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, 9.0F, -75.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = chest_1.addOrReplaceChild("cube_r10", CubeListBuilder.create(), PartPose.offsetAndRotation(22.0F, -9.0F, -1.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_4 = EarlyCog.addOrReplaceChild("chest_4", CubeListBuilder.create(), PartPose.offset(-23.0F, -11.5F, 9.0F));

		PartDefinition cube_r11 = chest_4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, -1.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r12 = chest_4.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(30, 55).addBox(39.0F, -22.0F, -5.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 20.5F, -42.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r13 = chest_4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(50, 47).addBox(38.0F, -17.0F, -9.25F, 7.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.5F, -42.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_2 = EarlyCog.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(19.0F, -15.5F, 15.0F));

		PartDefinition cube_r14 = chest_2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(30, 55).addBox(0.0F, 6.5F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = chest_2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(30, 55).addBox(57.0F, -19.0F, 14.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(32.0F, -25.0F, -8.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 24.5F, -57.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = chest_2.addOrReplaceChild("cube_r16", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 6.5F, -16.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r16_r1 = cube_r16.addOrReplaceChild("cube_r16_r1", CubeListBuilder.create().texOffs(96, 38).addBox(4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 0.0F, 7.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition chest_3 = EarlyCog.addOrReplaceChild("chest_3", CubeListBuilder.create(), PartPose.offset(51.3333F, -8.0F, -11.1667F));

		PartDefinition cube_r17 = chest_3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(30, 55).addBox(33.0F, -19.0F, 53.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(31, 56).addBox(33.0F, -19.0F, 49.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.3333F, 17.0F, -33.8333F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = chest_3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -49.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.3333F, -1.0F, 7.1667F, 0.0F, 1.5708F, 0.0F));

		PartDefinition steer = EarlyCog.addOrReplaceChild("steer", CubeListBuilder.create().texOffs(4, 1).addBox(0.0F, -7.0F, -1.0F, 4.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(42.0F, 9.0F, 0.0F));

		PartDefinition BannerStick = EarlyCog.addOrReplaceChild("BannerStick", CubeListBuilder.create().texOffs(8, 0).addBox(12.0F, -94.0F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.7F, -1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	@Override
	public void setupAnim(@NotNull EarlyCogEntity earlyCogEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest_1.visible = earlyCogEntity.getInvFillState() >= 15;
		this.chest_2.visible = earlyCogEntity.getInvFillState() >= 30;
		this.chest_3.visible = earlyCogEntity.getInvFillState() >= 60;
		this.chest_4.visible = earlyCogEntity.getInvFillState() >= 90;

		this.steer.yRot = -earlyCogEntity.getRotSpeed() * 0.25F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.EarlyCog;
	}
}

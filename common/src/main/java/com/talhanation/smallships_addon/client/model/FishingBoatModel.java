package com.talhanation.smallships_addon.client.model;

import com.talhanation.smallships.client.model.ShipModel;
import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.world.entity.ship.FishingBoatEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class FishingBoatModel extends ShipModel<FishingBoatEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsAddonMod.MOD_ID, FishingBoatEntity.ID + "_model"), "main");
	private final ModelPart FishingBoat;
	private final ModelPart deck;
	private final ModelPart cube_r1;
	private final ModelPart sides;
	private final ModelPart back;
	private final ModelPart sides8;
	private final ModelPart deck6;
	private final ModelPart cube_r13;
	private final ModelPart front;
	private final ModelPart cube_r12;
	private final ModelPart chest_1;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart chest_2;
	private final ModelPart cube_r15;
	private final ModelPart cube_r16;
	private final ModelPart mast;
	private final ModelPart steer;
	private final ModelPart row;
	private final ModelPart net_out;
	private final ModelPart net_out_0;
	private final ModelPart net_out_1;
	private final ModelPart net_out_2;
	private final ModelPart net_out_3;
	private final ModelPart net_out_4;
	private final ModelPart net_in;
	private final ModelPart net_in_out;
	private final ModelPart net_in_top;
	private final ModelPart net_in_in;
	private final ModelPart net_in_under_out;
	private final ModelPart net_in_under_top;
	private final ModelPart net_in_under_in;

	public FishingBoatModel(ModelPart root) {
		this.FishingBoat = root.getChild("FishingBoat");
		this.deck = this.FishingBoat.getChild("deck");
		this.cube_r1 = this.deck.getChild("cube_r1");
		this.sides = this.FishingBoat.getChild("sides");
		this.back = this.sides.getChild("back");
		this.sides8 = this.back.getChild("sides8");
		this.deck6 = this.back.getChild("deck6");
		this.cube_r13 = this.deck6.getChild("cube_r13");
		this.front = this.sides.getChild("front");
		this.cube_r12 = this.front.getChild("cube_r12");
		this.chest_1 = this.FishingBoat.getChild("chest_1");
		this.cube_r7 = this.chest_1.getChild("cube_r7");
		this.cube_r8 = this.chest_1.getChild("cube_r8");
		this.cube_r9 = this.chest_1.getChild("cube_r9");
		this.chest_2 = this.FishingBoat.getChild("chest_2");
		this.cube_r15 = this.chest_2.getChild("cube_r15");
		this.cube_r16 = this.chest_2.getChild("cube_r16");
		this.mast = this.FishingBoat.getChild("mast");
		this.steer = this.FishingBoat.getChild("steer");
		this.row = this.steer.getChild("row");
		this.net_out = this.FishingBoat.getChild("net_out");
		this.net_out_0 = this.net_out.getChild("net_out_0");
		this.net_out_1 = this.net_out_0.getChild("net_out_1");
		this.net_out_2 = this.net_out_1.getChild("net_out_2");
		this.net_out_3 = this.net_out_2.getChild("net_out_3");
		this.net_out_4 = this.net_out_3.getChild("net_out_4");
		this.net_in = this.FishingBoat.getChild("net_in");
		this.net_in_out = this.net_in.getChild("net_in_out");
		this.net_in_top = this.net_in.getChild("net_in_top");
		this.net_in_in = this.net_in.getChild("net_in_in");
		this.net_in_under_out = this.net_in.getChild("net_in_under_out");
		this.net_in_under_top = this.net_in.getChild("net_in_under_top");
		this.net_in_under_in = this.net_in.getChild("net_in_under_in");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition FishingBoat = partdefinition.addOrReplaceChild("FishingBoat", CubeListBuilder.create(), PartPose.offset(-0.4929F, 23.0357F, -1.35F));

		PartDefinition deck = FishingBoat.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(17.4929F, 0.9643F, 8.35F));

		PartDefinition cube_r1 = deck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 0).addBox(-24.0F, -5.0F, 3.0F, 20.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(6, 0).addBox(-4.0F, -5.0F, 3.0F, 22.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -12.0F, -2.0F, 20.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-24.0F, -12.0F, -2.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -6.0F, -2.0F, 20.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-24.0F, -6.0F, -2.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -9.0F, -5.0F, 20.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-24.0F, -9.0F, -5.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r4_r1 = cube_r1.addOrReplaceChild("cube_r4_r1", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-10.0F, -5.5F, -1.5F, 20.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0F, -10.5F, 4.5F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r2_r1 = cube_r1.addOrReplaceChild("cube_r2_r1", CubeListBuilder.create().texOffs(12, 0).addBox(-11.0F, -5.5F, -1.5F, 22.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -10.5F, 4.5F, 0.0F, 0.0F, -3.1416F));

		PartDefinition sides = FishingBoat.addOrReplaceChild("sides", CubeListBuilder.create().texOffs(8, 36).addBox(0.0F, -11.0F, -19.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(10, 36).addBox(-16.0F, -11.0F, -19.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 36).addBox(-24.0F, -11.0F, -19.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(10, 36).addBox(-16.0F, -12.0F, 6.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 36).addBox(-24.0F, -12.0F, 6.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(0.0F, -12.0F, 6.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.4929F, 0.9643F, 8.35F));

		PartDefinition back = sides.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(-6.0F, 0.0F, 0.0F));

		PartDefinition sides8 = back.addOrReplaceChild("sides8", CubeListBuilder.create().texOffs(8, 36).addBox(18.0F, -12.0F, 3.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(18.0F, -12.0F, -16.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 0.0F, 0.0F));

		PartDefinition sides_r1 = sides8.addOrReplaceChild("sides_r1", CubeListBuilder.create().texOffs(7, 36).addBox(-5.5F, -3.0F, -1.5F, 16.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.5F, -8.0F, -7.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition deck6 = back.addOrReplaceChild("deck6", CubeListBuilder.create(), PartPose.offset(20.0F, 0.0F, 0.0F));

		PartDefinition cube_r13 = deck6.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(13, 0).addBox(18.0F, -9.0F, -5.0F, 10.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, -6.0F, -2.0F, 17.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, -12.0F, -2.0F, 17.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r5_r1 = cube_r13.addOrReplaceChild("cube_r5_r1", CubeListBuilder.create().texOffs(4, 4).addBox(0.0F, -6.0F, 0.5F, 8.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.5F, -5.5F, -2.225F, 0.0F, -1.0908F, 0.0F));

		PartDefinition cube_r6_r1 = cube_r13.addOrReplaceChild("cube_r6_r1", CubeListBuilder.create().texOffs(4, 4).addBox(0.0F, -3.0F, 0.5F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.7F, -5.5F, -5.2F, 0.0F, -0.3491F, 0.0F));

		PartDefinition front = sides.addOrReplaceChild("front", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(35.5071F, -9.0357F, -1.15F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(8, 0).mirror().addBox(35.5071F, -9.0357F, 4.85F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(8, 0).mirror().addBox(35.5071F, -9.0357F, 1.85F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(13, 36).mirror().addBox(-34.4929F, -11.0357F, 11.35F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(13, 36).mirror().addBox(-34.4929F, -11.0357F, -7.65F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5071F, -0.9643F, -8.35F));

		PartDefinition sides_r2 = front.addOrReplaceChild("sides_r2", CubeListBuilder.create().texOffs(7, 36).mirror().addBox(-10.5F, -4.0F, -1.5F, 16.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-35.9929F, -7.0357F, 0.85F, 0.0F, 1.5708F, 0.0F));

		PartDefinition sides_r3 = front.addOrReplaceChild("sides_r3", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-1.5F, -5.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-36.9929F, -10.0357F, 3.35F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r12 = front.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-30.0F, -12.0F, -2.0F, 12.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(13, 0).mirror().addBox(-23.0F, -9.0F, -5.0F, 5.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(13, 0).mirror().addBox(-23.0F, -9.0F, -5.0F, 5.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(-30.0F, -6.0F, -2.0F, 12.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(-30.0F, -12.0F, -2.0F, 12.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(30, 0).mirror().addBox(-31.0F, -5.0F, 3.0F, 13.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(20, 0).addBox(24.0F, -5.0F, 3.0F, 18.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4929F, 0.9643F, 8.35F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r5_r2 = cube_r12.addOrReplaceChild("cube_r5_r2", CubeListBuilder.create().texOffs(4, 4).mirror().addBox(-5.6913F, -6.0F, 4.9351F, 8.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-35.5F, -5.5F, -2.225F, 0.0F, 1.0908F, 0.0F));

		PartDefinition cube_r6_r2 = cube_r12.addOrReplaceChild("cube_r6_r2", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(-9.0F, -5.0F, -1.5F, 18.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(33.0F, -10.0F, 4.5F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r5_r3 = cube_r12.addOrReplaceChild("cube_r5_r3", CubeListBuilder.create().texOffs(15, 0).mirror().addBox(-9.0F, -5.0F, -1.5F, 13.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-27.0F, -10.0F, 4.5F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r6_r3 = cube_r12.addOrReplaceChild("cube_r6_r3", CubeListBuilder.create().texOffs(4, 4).mirror().addBox(-3.3015F, -3.0F, 2.2101F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-27.7F, -5.5F, -5.2F, 0.0F, 0.3491F, 0.0F));

		PartDefinition chest_1 = FishingBoat.addOrReplaceChild("chest_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.4571F, -7.2857F, 13.9F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_1_r1 = chest_1.addOrReplaceChild("chest_1_r1", CubeListBuilder.create().texOffs(96, 38).addBox(-13.0F, -4.0F, -12.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.65F, -1.75F, 22.25F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = chest_1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 55).addBox(-1.2501F, 3.65F, 9.75F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -4.5F, 14.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r8 = chest_1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 55).addBox(13.0F, -21.5F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.35F, -8.25F, 4.25F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = chest_1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 55).addBox(59.0F, -19.0F, -9.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.65F, 16.25F, -52.75F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_2 = FishingBoat.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(-45.5071F, -14.5357F, 23.35F));

		PartDefinition cube_r15 = chest_2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(30, 55).addBox(35.0F, -18.0F, -56.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 24.5F, -57.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = chest_2.addOrReplaceChild("cube_r16", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 6.5F, -16.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r16_r1 = cube_r16.addOrReplaceChild("cube_r16_r1", CubeListBuilder.create().texOffs(96, 38).addBox(4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-69.0F, -1.0F, 15.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition mast = FishingBoat.addOrReplaceChild("mast", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4929F, -5.2296F, 3.35F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r2 = mast.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 47).addBox(-11.7387F, -5.6338F, -5.4179F, 5.3726F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(-6.3662F, -5.6338F, -5.4179F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(0.6338F, -5.6338F, -5.4179F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(28.6338F, -5.6338F, -5.4179F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0707F, -64.8061F, 6.4293F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r3 = mast.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 45).addBox(-13.7388F, -5.6338F, -6.4886F, 4.3726F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(-9.3662F, -5.6338F, -6.4886F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(1.6338F, -5.6338F, -6.4886F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.849F, -62.9777F, 6.5846F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r4 = mast.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 45).addBox(24.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.849F, -62.9777F, -1.4154F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r5 = mast.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(1, 37).addBox(-13.5F, -0.5F, -9.5F, 27.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -75.3061F, 8.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r6 = mast.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 36).addBox(-13.5F, -1.5F, -9.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -48.3061F, 8.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r10 = mast.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 36).addBox(-13.5F, -1.5F, -9.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.3061F, 8.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r11 = mast.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(17, 36).addBox(3.5F, -1.5F, -9.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.6939F, 8.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition steer = FishingBoat.addOrReplaceChild("steer", CubeListBuilder.create().texOffs(4, 1).addBox(2.75F, 9.0F, -1.0F, 4.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(4, 1).addBox(0.75F, 10.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(4, 1).addBox(0.75F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(41.9929F, -10.0357F, 3.35F));

		PartDefinition row = steer.addOrReplaceChild("row", CubeListBuilder.create(), PartPose.offsetAndRotation(45.0F, 0.0F, -2.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r14 = row.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(9, 0).addBox(-6.0F, -43.5F, 8.0F, 1.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 8.0F, -10.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition net_out = FishingBoat.addOrReplaceChild("net_out", CubeListBuilder.create(), PartPose.offset(15.4929F, -6.0357F, -11.65F));

		PartDefinition sides_r4 = net_out.addOrReplaceChild("sides_r4", CubeListBuilder.create().texOffs(6, 36).addBox(-11.0F, -1.0F, -1.5F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -4.0F, -14.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition sides_r5 = net_out.addOrReplaceChild("sides_r5", CubeListBuilder.create().texOffs(8, 36).addBox(-9.0F, -1.0F, -1.5F, 18.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -4.0F, -4.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition net_out_0 = net_out.addOrReplaceChild("net_out_0", CubeListBuilder.create().texOffs(112, -1).addBox(0.0F, 3.0F, 12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 2.6F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 0.2F, -12.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 0.2F, -3.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 0.2F, 6.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -3.0F, -12.0F, 0.0F, 0.0F, -0.4189F));

		PartDefinition net_out_1 = net_out_0.addOrReplaceChild("net_out_1", CubeListBuilder.create().texOffs(111, -2).addBox(0.0F, 0.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, -0.4F, 11.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 1.6F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 1.6F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 1.6F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.2094F));

		PartDefinition net_out_2 = net_out_1.addOrReplaceChild("net_out_2", CubeListBuilder.create().texOffs(111, -2).addBox(0.0F, 0.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 0.6F, 11.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 2.6F, -11.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 2.6F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, -0.4F, -6.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 2.6F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 2.6F, 8.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.2094F));

		PartDefinition net_out_3 = net_out_2.addOrReplaceChild("net_out_3", CubeListBuilder.create().texOffs(111, -2).addBox(0.0F, 0.0F, -11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 1.9F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 3.0F, -6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.2094F));

		PartDefinition net_out_4 = net_out_3.addOrReplaceChild("net_out_4", CubeListBuilder.create().texOffs(112, -1).addBox(0.0F, 1.0F, 12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 10.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 7.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 4.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -8.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 0.0F, -11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(112, -1).addBox(0.0F, 1.0F, -12.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 1.6F, -11.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 1.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 1.6F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 1.6F, 11.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -1).addBox(-0.5F, 1.6F, 6.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(111, -2).addBox(0.0F, 2.0F, -11.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition net_in = FishingBoat.addOrReplaceChild("net_in", CubeListBuilder.create(), PartPose.offset(1.4929F, -10.6357F, -11.65F));

		PartDefinition net_in_out = net_in.addOrReplaceChild("net_in_out", CubeListBuilder.create().texOffs(111, 0).addBox(9.5F, 5.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-2.5F, 5.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-12.5F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(11.5F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(7.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(3.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-0.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-8.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-12.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(9.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(1.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-2.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-6.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-12.5F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(11.5F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(7.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(3.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-0.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-8.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-12.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(9.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(1.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-2.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-6.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-12.5F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(11.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(7.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(3.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-0.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-8.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-12.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1047F, 0.0F, 0.0F));

		PartDefinition net_in_top = net_in.addOrReplaceChild("net_in_top", CubeListBuilder.create().texOffs(111, 0).addBox(9.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-2.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-6.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-12.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(11.5F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(7.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(3.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-0.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-8.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-12.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(9.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(1.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-2.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-6.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-12.5F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(11.5F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(7.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(3.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-0.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-8.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-12.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(9.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(1.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-2.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-6.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.5F, 4.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-12.5F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition net_in_in = net_in.addOrReplaceChild("net_in_in", CubeListBuilder.create().texOffs(112, 0).addBox(11.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(7.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(3.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-0.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-8.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-12.5F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(9.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(1.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-2.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-6.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.5F, 1.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-12.5F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(11.5F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(7.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(3.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-0.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-8.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-12.5F, 2.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(9.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-2.5F, 3.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-12.5F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.1047F, 0.0F, 0.0F));

		PartDefinition net_in_under_out = net_in.addOrReplaceChild("net_in_under_out", CubeListBuilder.create().texOffs(111, 0).addBox(11.0F, 6.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(8.0F, 6.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.0F, 6.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(2.0F, 6.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-1.0F, 6.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.0F, 6.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-7.0F, 6.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.0F, 6.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-13.0F, 6.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(13.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(10.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(7.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(4.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(1.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-2.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-5.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-8.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-11.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-14.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(11.0F, 4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(8.0F, 4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.0F, 4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(2.0F, 4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-1.0F, 4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.0F, 4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-7.0F, 4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.0F, 4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-13.0F, 4.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(13.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(10.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(7.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(4.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(1.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-2.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-5.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-8.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-11.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-14.0F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(11.0F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(8.0F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.0F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(2.0F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-1.0F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.0F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-7.0F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.0F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-13.0F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(13.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(10.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(7.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(4.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-2.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-5.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-11.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-14.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(11.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(8.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-7.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-13.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.35F, 0.5F, -0.0524F, 0.0F, 0.0F));

		PartDefinition net_in_under_top = net_in.addOrReplaceChild("net_in_under_top", CubeListBuilder.create().texOffs(112, 0).addBox(13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(7.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(4.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-5.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(11.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(8.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(2.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-1.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-7.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-13.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(13.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(10.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(7.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(4.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(1.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-2.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-5.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-8.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-11.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-14.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(11.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(8.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(2.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-7.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-13.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.35F, 0.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition net_in_under_in = net_in.addOrReplaceChild("net_in_under_in", CubeListBuilder.create().texOffs(112, 0).addBox(13.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(10.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(7.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(4.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-5.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-8.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-11.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-14.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(11.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(8.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(2.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-1.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-7.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-13.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(13.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(10.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(7.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(4.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(1.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-2.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-5.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-8.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-11.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-14.0F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(11.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(8.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(5.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(2.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-4.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-7.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-10.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(111, 0).addBox(-13.0F, 3.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(13.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(10.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(7.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(4.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(1.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-2.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-5.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-8.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-11.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(112, 0).addBox(-14.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.35F, 4.5F, 0.0524F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(@NotNull FishingBoatEntity fishingBoat, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.net_out.visible = fishingBoat.isNetOut();
		this.net_in.visible = !this.net_out.visible;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.FishingBoat;
	}
}

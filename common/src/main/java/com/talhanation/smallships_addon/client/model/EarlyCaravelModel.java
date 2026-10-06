package com.talhanation.smallships_addon.client.model;

import com.talhanation.smallships.client.model.ShipModel;
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

// Hull model exported from Blockbench.
public class EarlyCaravelModel extends ShipModel<EarlyCaravelEntity> {
	// register this layer with createBodyLayer() in the loader module (forge ClientModBus / fabric client)
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsAddonMod.MOD_ID, EarlyCaravelEntity.ID + "_model"), "main");

	private final ModelPart EarlyCaravel;
	private final ModelPart bottom;
	private final ModelPart front;
	private final ModelPart back;
	private final ModelPart sides;
	private final ModelPart deck;
	private final ModelPart back_deck;
	private final ModelPart mast_1;
	private final ModelPart bannerstick;
	private final ModelPart steer;
	private final ModelPart chest_1;
	private final ModelPart chest_2;
	private final ModelPart chest_3;

	public EarlyCaravelModel(ModelPart root) {
		this.EarlyCaravel = root.getChild("EarlyCaravel");
		this.bottom = this.EarlyCaravel.getChild("bottom");
		this.front = this.bottom.getChild("front");
		this.back = this.bottom.getChild("back");
		this.sides = this.EarlyCaravel.getChild("sides");
		this.deck = this.EarlyCaravel.getChild("deck");
		this.back_deck = this.deck.getChild("back_deck");
		this.mast_1 = this.EarlyCaravel.getChild("mast_1");
		this.bannerstick = this.mast_1.getChild("bannerstick");
		this.steer = this.EarlyCaravel.getChild("steer");
		this.chest_1 = this.EarlyCaravel.getChild("chest_1");
		this.chest_2 = this.EarlyCaravel.getChild("chest_2");
		this.chest_3 = this.EarlyCaravel.getChild("chest_3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition EarlyCaravel = partdefinition.addOrReplaceChild("EarlyCaravel", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bottom = EarlyCaravel.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bottom.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(10.0F, 2.0F, -5.5F, 11.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-9.0F, 2.0F, -5.5F, 19.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(1, 0).addBox(-27.0F, 2.0F, -5.5F, 18.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = bottom.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(2, 0).addBox(-25.0F, 3.0F, -5.5F, 14.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -16.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r3 = bottom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(10.0F, 0.0F, -10.0F, 11.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(10.0F, -13.0F, -10.0F, 11.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-9.0F, 0.0F, -10.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-9.0F, -13.0F, -10.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(1, 0).addBox(-27.0F, 0.0F, -10.0F, 18.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(1, 0).addBox(-27.0F, -13.0F, -10.0F, 18.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-34.0F, 0.0F, -10.0F, 7.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-41.0F, -10.0F, -10.0F, 7.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-34.0F, -13.0F, -10.0F, 7.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(10.0F, 0.0F, -5.0F, 11.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(10.0F, -13.0F, -5.0F, 11.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-9.0F, 0.0F, -5.0F, 19.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-9.0F, -13.0F, -5.0F, 19.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(2, 1).addBox(-27.0F, 0.0F, -5.0F, 18.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(2, 1).addBox(-27.0F, -13.0F, -5.0F, 18.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 0).addBox(-41.0F, 6.0F, -5.0F, 14.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(1, 0).addBox(-41.0F, 0.0F, -5.0F, 14.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(1, 0).addBox(-41.0F, -9.0F, -5.0F, 14.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(1, 0).addBox(-41.0F, -6.0F, -5.0F, 14.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = bottom.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(10.0F, -19.0F, -10.0F, 11.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-9.0F, -19.0F, -10.0F, 19.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(1, 0).addBox(-27.0F, -19.0F, -10.0F, 18.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = bottom.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(7, 0).addBox(-51.0F, -14.0F, -10.0F, 4.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -7.0F, 79.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r6 = bottom.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(11, 9).addBox(7.0F, -11.0F, -1.0F, 4.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -16.0F, -45.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = bottom.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(11, 3).addBox(-34.0F, -13.0F, -10.0F, 7.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(10, 2).addBox(-34.0F, 0.0F, -10.0F, 7.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r8 = bottom.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(8, 0).addBox(-34.0F, 0.0F, -10.0F, 7.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -7.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = bottom.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-51.0F, 1.0F, -12.0F, 5.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.0F, 86.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = bottom.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(1, 0).addBox(-58.0F, -1.0F, -5.0F, 14.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(1, 0).addBox(-58.0F, -7.0F, -5.0F, 14.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -4.0F, 79.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition front = bottom.addOrReplaceChild("front", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 2.0F, -59.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition cube_r11 = front.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(13, 3).addBox(-7.7523F, -17.4717F, -4.1F, 12.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -15.0F, -1.5708F, -1.5708F, 1.5708F));

		PartDefinition cube_r12 = front.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(20, 4).addBox(-10.9808F, -16.1225F, -3.1F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -8.5F, -25.1F, -1.5708F, -1.0908F, 1.5708F));

		PartDefinition cube_r13 = front.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(13, 3).addBox(-7.7523F, -24.4717F, -4.1F, 15.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -15.0F, -1.5708F, -1.5708F, 1.5708F));

		PartDefinition cube_r14 = front.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(13, 3).addBox(-7.7523F, -24.4717F, -4.1F, 13.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 1.5708F));

		PartDefinition back = bottom.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2F, -20.5327F, 44.3204F, -1.2654F, 3.1416F, 0.0F));

		PartDefinition cube_r15 = back.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(13, 3).addBox(-8.7908F, -23.7865F, -5.1F, 15.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4092F, 13.3192F, 2.7796F, -1.5708F, -1.5708F, 1.5708F));

		PartDefinition cube_r16 = back.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(13, 3).addBox(-8.7908F, -23.7865F, -5.1F, 13.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4092F, 13.3192F, 17.7796F, -1.5708F, -1.5708F, 1.5708F));

		PartDefinition sides = EarlyCaravel.addOrReplaceChild("sides", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r17 = sides.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(11, 39).addBox(-20.0F, -22.0F, -19.0F, 11.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, 30.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = sides.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(3, 40).addBox(-28.0F, -22.0F, -19.0F, 11.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, 16.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r19 = sides.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(3, 40).addBox(-28.0F, -22.0F, -19.0F, 11.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, 27.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r20 = sides.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(4, 39).addBox(-27.0F, -22.0F, -19.0F, 15.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r21 = sides.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(7, 39).addBox(-24.5F, -1.5F, 0.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(11, 43).addBox(-24.5F, -1.5F, -4.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.5F, -22.0F, -51.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r22 = sides.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(12, 37).addBox(-6.0F, -19.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(12, 38).addBox(1.0F, -22.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -1.0F, -35.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r23 = sides.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(12, 36).addBox(-6.0F, -19.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.0F, -1.0F, -35.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r24 = sides.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(16, 40).addBox(-6.0F, -19.0F, -17.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.0F, -9.0F, -35.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r25 = sides.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(16, 41).addBox(-6.0F, -19.0F, -17.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 41).addBox(1.0F, -22.0F, -17.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, -35.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r26 = sides.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(3, 43).addBox(-10.5F, 15.5F, 0.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -26.0F, -56.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r27 = sides.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(-1, 39).addBox(-10.5F, 15.5F, -4.0F, 20.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -18.0F, -56.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r28 = sides.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(3, 43).addBox(-10.5F, 15.5F, 0.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -26.0F, -59.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r29 = sides.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(-1, 39).addBox(-10.5F, 15.5F, -4.0F, 20.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -18.0F, -59.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r30 = sides.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(2, 41).addBox(-9.5F, -1.5F, -2.0F, 11.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -21.0F, 11.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r31 = sides.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(5, 41).addBox(-6.5F, -1.5F, -2.0F, 15.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -21.0F, -18.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r32 = sides.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(10, 41).addBox(-1.5F, -1.5F, -2.0F, 11.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -21.0F, 8.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r33 = sides.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(10, 41).addBox(-1.5F, -1.5F, -2.0F, 11.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -21.0F, -2.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition deck = EarlyCaravel.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r34 = deck.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -16.0F, -13.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r35 = deck.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -16.0F, -13.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -4.0F, 1.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r36 = deck.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -16.0F, -13.0F, 20.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -4.0F, 29.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r37 = deck.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -16.0F, -13.0F, 20.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 29.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition back_deck = deck.addOrReplaceChild("back_deck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -14.6F, 32.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r38 = back_deck.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(1, 0).addBox(36.0F, 7.0F, -5.0F, 14.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(43.0F, 1.0F, -10.0F, 7.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(43.0F, -12.0F, -10.0F, 7.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4394F, 10.6515F, -39.0303F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r39 = back_deck.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(2, 0).addBox(52.0F, 3.0F, -6.5F, 14.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4394F, 7.6515F, -55.0303F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r40 = back_deck.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(8, 0).addBox(43.0F, 1.0F, -10.0F, 7.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4394F, 10.6515F, -46.0303F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r41 = back_deck.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(1, 0).addBox(36.0F, -8.0F, -5.0F, 14.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(36.0F, -9.0F, -10.0F, 7.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 10.6F, -39.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r42 = back_deck.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(12, 38).addBox(78.0F, -21.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(12, 37).addBox(71.0F, -18.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 13.6F, -74.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r43 = back_deck.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(16, 41).addBox(78.0F, -21.0F, -17.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 41).addBox(71.0F, -18.0F, -17.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 5.6F, -74.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r44 = back_deck.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(-1, 39).addBox(-11.5F, 92.5F, -4.0F, 20.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.4F, -98.0F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r45 = back_deck.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(3, 43).addBox(-11.5F, 92.5F, 0.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -11.4F, -98.0F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r46 = back_deck.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 0).addBox(-11.5F, 92.5F, 0.0F, 20.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -11.4F, -95.0F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r47 = back_deck.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(16, 40).addBox(71.0F, -18.0F, -17.0F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.5F, 5.6F, -74.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r48 = back_deck.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(12, 36).addBox(71.0F, -18.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.5F, 13.6F, -74.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r49 = back_deck.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(7, 39).addBox(-101.5F, -2.5F, 0.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(11, 43).addBox(-101.5F, -2.5F, -4.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -7.9F, -90.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r50 = back_deck.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(8, 0).addBox(43.0F, 1.0F, -10.0F, 7.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(11, 4).addBox(43.0F, -12.0F, -10.0F, 7.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.6F, -39.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition mast_1 = EarlyCaravel.addOrReplaceChild("mast_1", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, -39.5F));

		PartDefinition cube_r51 = mast_1.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(0, 47).addBox(-61.6274F, -1.0F, -0.8293F, 22.6274F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(-39.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(-11.0F, -1.0F, -0.8293F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(-4.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(24.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0707F, -79.0F, 26.9293F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r52 = mast_1.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(2, 47).addBox(-63.6274F, -1.0F, 0.1F, 22.6274F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(32.9761F, -12.3466F, -27.8654F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r53 = mast_1.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(2, 47).addBox(-63.6274F, -1.0F, 0.1F, 22.6274F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.9011F, -28.1716F, -14.8904F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r54 = mast_1.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(2, 47).addBox(-63.6274F, -1.0F, 0.1F, 22.6274F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.751F, -44.0966F, -1.8404F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r55 = mast_1.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(2, 47).addBox(-63.6274F, -1.0F, 0.1F, 22.6274F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5511F, -60.0716F, 11.2846F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r56 = mast_1.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(0, 47).addBox(-65.0F, -1.0F, 0.1F, 24.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.649F, -76.0716F, 24.3846F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r57 = mast_1.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(0, 45).addBox(-63.6274F, -1.0F, -1.9F, 22.6274F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(-41.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(-14.0F, -1.0F, -1.9F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(-3.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(24.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.849F, -77.1716F, 27.0846F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r58 = mast_1.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(1, 37).addBox(-13.5F, -0.5F, -1.5F, 27.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -89.5F, 29.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r59 = mast_1.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(0, 36).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -62.5F, 28.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r60 = mast_1.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(0, 36).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -35.5F, 28.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r61 = mast_1.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(0, 36).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 28.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition bannerstick = mast_1.addOrReplaceChild("bannerstick", CubeListBuilder.create(), PartPose.offset(0.0F, -116.5F, 29.4F));

		PartDefinition bannerstick_r1 = bannerstick.addOrReplaceChild("bannerstick_r1", CubeListBuilder.create().texOffs(2, 38).addBox(-13.5F, -0.5F, -1.5F, 17.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition steer = EarlyCaravel.addOrReplaceChild("steer", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 40.0F));

		PartDefinition cube_r62 = steer.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(3, 29).addBox(43.0F, -1.0F, -10.0F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.0F, -43.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition chest_1 = EarlyCaravel.addOrReplaceChild("chest_1", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -1.0F, 4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(-8.0F, 2.0F, 4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(-16.0F, 2.0F, 16.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(-13.0F, 2.0F, 9.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(9.0F, 2.0F, 4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(5.0F, 2.0F, 5.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(10.0F, 2.0F, 9.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 36.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_2 = EarlyCaravel.addOrReplaceChild("chest_2", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -8.0F, 4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(12.0F, -5.5F, 15.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(-10.0F, -5.5F, 3.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(7.0F, -5.5F, 8.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(4.0F, -5.5F, 3.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, -41.0F));

		PartDefinition chest_3 = EarlyCaravel.addOrReplaceChild("chest_3", CubeListBuilder.create().texOffs(96, 38).addBox(21.8F, -8.0F, 5.8F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(-8.0F, -5.5F, 4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(-13.0F, -5.5F, 8.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(-3.1F, -5.5F, 18.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(0.9F, -5.5F, 15.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -17.0F, -4.0F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

@Override
	public void setupAnim(@NotNull EarlyCaravelEntity earlyCaravelEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest_1.visible = earlyCaravelEntity.getInvFillState() >= 15;
		this.chest_2.visible = earlyCaravelEntity.getInvFillState() >= 30;
		this.chest_3.visible = earlyCaravelEntity.getInvFillState() >= 60;

		this.steer.yRot = -earlyCaravelEntity.getRotSpeed() * 0.25F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.EarlyCaravel;
	}
}

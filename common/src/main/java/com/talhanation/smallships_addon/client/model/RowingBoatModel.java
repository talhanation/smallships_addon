package com.talhanation.smallships_addon.client.model;

import com.talhanation.smallships.client.model.ShipModel;
import com.talhanation.smallships.world.entity.ship.abilities.Paddleable;
import com.talhanation.smallships_addon.SmallShipsAddonMod;
import com.talhanation.smallships_addon.world.entity.ship.RowingBoatEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

// Hull model exported from Blockbench.
public class RowingBoatModel extends ShipModel<RowingBoatEntity> {
	// register this layer with createBodyLayer() in the loader module (forge ClientModBus / fabric client)
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsAddonMod.MOD_ID, RowingBoatEntity.ID + "_model"), "main");
	private final ModelPart RowningBoat;
	private final ModelPart deck;
	private final ModelPart cube_r1;
	private final ModelPart sides;
	private final ModelPart cube_r4;
	private final ModelPart cube_r5;
	private final ModelPart chest_1;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart cube_r10;
	private final ModelPart chest_2;
	private final ModelPart cube_r14;
	private final ModelPart cube_r15;
	private final ModelPart cube_r16;
	private final ModelPart row_R_1;
	private final ModelPart row_L_1;
	private final ModelPart Rows_idle;
	private final ModelPart rowA;
	private final ModelPart rowB;


	public RowingBoatModel(ModelPart root) {
		this.RowningBoat = root.getChild("RowningBoat");
		this.deck = this.RowningBoat.getChild("deck");
		this.cube_r1 = this.deck.getChild("cube_r1");
		this.sides = this.RowningBoat.getChild("sides");
		this.cube_r4 = this.sides.getChild("cube_r4");
		this.cube_r5 = this.sides.getChild("cube_r5");
		this.chest_1 = this.RowningBoat.getChild("chest_1");
		this.cube_r7 = this.chest_1.getChild("cube_r7");
		this.cube_r8 = this.chest_1.getChild("cube_r8");
		this.cube_r9 = this.chest_1.getChild("cube_r9");
		this.cube_r10 = this.chest_1.getChild("cube_r10");
		this.chest_2 = this.RowningBoat.getChild("chest_2");
		this.cube_r14 = this.chest_2.getChild("cube_r14");
		this.cube_r15 = this.chest_2.getChild("cube_r15");
		this.cube_r16 = this.chest_2.getChild("cube_r16");
		this.row_R_1 = this.RowningBoat.getChild("row_R_1");
		this.row_L_1 = this.RowningBoat.getChild("row_L_1");
		this.Rows_idle = this.RowningBoat.getChild("Rows_idle");
		this.rowA = this.Rows_idle.getChild("rowA");
		this.rowB = this.Rows_idle.getChild("rowB");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RowningBoat = partdefinition.addOrReplaceChild("RowningBoat", CubeListBuilder.create(), PartPose.offset(-0.4929F, 23.0357F, -1.35F));

		PartDefinition deck = RowningBoat.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(17.4929F, 0.9643F, 8.35F));

		PartDefinition cube_r1 = deck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(6, 0).addBox(-4.0F, -16.0F, 3.0F, 22.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, -13.0F, 3.0F, 9.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-33.0F, -13.0F, 3.0F, 9.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 0).addBox(-24.0F, -16.0F, 3.0F, 20.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(5.0F, -12.0F, -2.0F, 21.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-17.0F, -12.0F, -2.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(-32.0F, -12.0F, -2.0F, 15.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r5_r1 = cube_r1.addOrReplaceChild("cube_r5_r1", CubeListBuilder.create().texOffs(4, 4).addBox(-11.694F, -3.0F, -7.0961F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, -8.0F, -2.0F, 0.0F, 1.0908F, 0.0F));

		PartDefinition cube_r4_r1 = cube_r1.addOrReplaceChild("cube_r4_r1", CubeListBuilder.create().texOffs(4, 4).addBox(0.0F, -3.0F, 0.5F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -8.0F, -2.2F, 0.0F, -1.0908F, 0.0F));

		PartDefinition sides = RowningBoat.addOrReplaceChild("sides", CubeListBuilder.create().texOffs(8, 36).addBox(0.0F, -11.0F, -19.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(10, 36).addBox(-16.0F, -11.0F, -19.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 36).addBox(-24.0F, -11.0F, -19.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(0.0F, -11.0F, 0.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(18.0F, -11.0F, -16.0F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(18.0F, -11.0F, -3.0F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-33.0F, -11.0F, -16.0F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-33.0F, -11.0F, -3.0F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(10, 36).addBox(-16.0F, -11.0F, 0.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 36).addBox(-24.0F, -11.0F, 0.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.4929F, 0.9643F, 8.35F));

		PartDefinition sides_r1 = sides.addOrReplaceChild("sides_r1", CubeListBuilder.create().texOffs(7, 36).addBox(-5.5F, -3.0F, -1.5F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(9, 36).addBox(-3.5F, -6.0F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-34.5F, -8.0F, -7.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition sides_r2 = sides.addOrReplaceChild("sides_r2", CubeListBuilder.create().texOffs(9, 36).addBox(-3.5F, 0.0F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(7, 36).addBox(-5.5F, 3.0F, -1.5F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.5F, -14.0F, -7.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = sides.addOrReplaceChild("cube_r4", CubeListBuilder.create(), PartPose.offsetAndRotation(35.0F, -8.0F, -9.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r5 = sides.addOrReplaceChild("cube_r5", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -8.0F, -3.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_1 = RowningBoat.addOrReplaceChild("chest_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.4571F, -7.2857F, 13.9F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_1_r1 = chest_1.addOrReplaceChild("chest_1_r1", CubeListBuilder.create().texOffs(96, 38).addBox(-13.0F, -4.0F, -12.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.65F, -1.75F, 22.25F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = chest_1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 55).addBox(-1.2501F, 3.65F, 9.75F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -4.5F, 14.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r8 = chest_1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 55).addBox(13.0F, -21.5F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.35F, -8.25F, 4.25F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = chest_1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 55).addBox(59.0F, -19.0F, -9.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.65F, 16.25F, -52.75F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = chest_1.addOrReplaceChild("cube_r10", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.35F, -1.75F, 21.25F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_2 = RowningBoat.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(-45.5071F, -14.5357F, 23.35F));

		PartDefinition cube_r14 = chest_2.addOrReplaceChild("cube_r14", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = chest_2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(30, 55).addBox(35.0F, -18.0F, -56.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 24.5F, -57.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = chest_2.addOrReplaceChild("cube_r16", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 6.5F, -16.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r16_r1 = cube_r16.addOrReplaceChild("cube_r16_r1", CubeListBuilder.create().texOffs(96, 38).addBox(4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-69.0F, -1.0F, 15.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition row_R_1 = RowningBoat.addOrReplaceChild("row_R_1", CubeListBuilder.create().texOffs(33, 3).addBox(-2.5F, -1.5F, 16.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9929F, -12.0357F, 10.35F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r2 = row_R_1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(9, 0).addBox(-5.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-5.0F, 8.5F, 8.0F, 1.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 8.0F, -16.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_L_1 = RowningBoat.addOrReplaceChild("row_L_1", CubeListBuilder.create().texOffs(33, 3).addBox(-2.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9929F, -11.0357F, -9.65F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r3 = row_L_1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(9, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Rows_idle = RowningBoat.addOrReplaceChild("Rows_idle", CubeListBuilder.create(), PartPose.offset(0.4929F, 0.9643F, 1.35F));

		PartDefinition rowA = Rows_idle.addOrReplaceChild("rowA", CubeListBuilder.create().texOffs(29, 3).addBox(-2.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.3F, -12.0F, 4.9F, -1.7453F, -1.5708F, 1.9373F));

		PartDefinition cube_r6 = rowA.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(5, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(5, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition rowB = Rows_idle.addOrReplaceChild("rowB", CubeListBuilder.create().texOffs(29, 3).addBox(-2.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.3F, -11.6F, 3.9F, 0.192F, -1.2654F, 0.0F));

		PartDefinition cube_r11 = rowB.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(5, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(5, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	@Override
	public void setupAnim(@NotNull RowingBoatEntity rowingBoat, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest_1.visible = rowingBoat.getInvFillState() >= 33;
		this.chest_2.visible = rowingBoat.getInvFillState() >= 66;

		boolean driverInside = rowingBoat.getDriver() != null;

		this.Rows_idle.visible = !driverInside;
		this.row_R_1.visible = driverInside;
		this.row_L_1.visible = driverInside;

		rowingBoat.animatePaddle(Paddleable.PaddleSide.RIGHT, this.row_R_1 , limbSwing);
		rowingBoat.animatePaddle(Paddleable.PaddleSide.LEFT, this.row_L_1 , limbSwing);
	}

	@Override
	public @NotNull ModelPart root() {
		return this.RowningBoat;
	}
}

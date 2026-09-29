package com.talhanation.smallshipsaddon.client.model;

import com.talhanation.smallships.client.model.ShipModel;
import com.talhanation.smallshipsaddon.SmallShipsAddon;
import com.talhanation.smallshipsaddon.world.entity.ship.CrayerEntity;
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

/**
 * PLACEHOLDER geometry - a readable box hull, not a finished ship. Export your
 * real model from Blockbench with the modded_entity generator and paste the
 * generated createBodyLayer over this one, the rest of the class stays.
 *
 * What matters for SmallShips is the structure around the geometry, and that is
 * real: the cargo parts driven by getInvFillState, the steer driven by
 * getRotSpeed, and the BannerStick the shared renderer looks for when the ship
 * is Bannerable.
 */
public class CrayerModel extends ShipModel<CrayerEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsAddon.MOD_ID, CrayerEntity.ID + "_model"), "main");

	private final ModelPart crayer;
	private final ModelPart chest1;
	private final ModelPart chest2;
	private final ModelPart chest3;
	private final ModelPart chest4;
	private final ModelPart steer;

	public CrayerModel(ModelPart modelPart) {
		this.crayer = modelPart;
		ModelPart crayer = this.crayer.getChild("Crayer");
		this.chest1 = crayer.getChild("chest_1");
		this.chest2 = crayer.getChild("chest_2");
		this.chest3 = crayer.getChild("chest_3");
		this.chest4 = crayer.getChild("chest_4");
		this.steer = crayer.getChild("steer");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Crayer = partdefinition.addOrReplaceChild("Crayer", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		// hull: short and shallow, a boat rather than a ship
		Crayer.addOrReplaceChild("bottom", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-30.0F, -4.0F, -9.0F, 60.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Crayer.addOrReplaceChild("side_left", CubeListBuilder.create()
				.texOffs(0, 24).addBox(-30.0F, -12.0F, 9.0F, 60.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Crayer.addOrReplaceChild("side_right", CubeListBuilder.create()
				.texOffs(0, 24).addBox(-30.0F, -12.0F, -12.0F, 60.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		// the transom stern
		Crayer.addOrReplaceChild("transom", CubeListBuilder.create()
				.texOffs(0, 40).addBox(-33.0F, -20.0F, -9.0F, 3.0F, 20.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Crayer.addOrReplaceChild("bow", CubeListBuilder.create()
				.texOffs(44, 40).addBox(30.0F, -10.0F, -9.0F, 3.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Crayer.addOrReplaceChild("mast", CubeListBuilder.create()
				.texOffs(84, 0).addBox(-2.0F, -66.0F, -2.0F, 4.0F, 66.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -4.0F, 0.0F));

		// the tiller, animated below
		Crayer.addOrReplaceChild("steer", CubeListBuilder.create()
				.texOffs(84, 0).addBox(0.0F, -7.0F, -1.0F, 4.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-36.0F, -14.0F, 0.0F));

		// cargo, shown step by step as the inventory fills up
		Crayer.addOrReplaceChild("chest_1", CubeListBuilder.create()
				.texOffs(100, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(14.0F, -4.0F, 0.0F));
		Crayer.addOrReplaceChild("chest_2", CubeListBuilder.create()
				.texOffs(100, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -4.0F, 0.0F));
		Crayer.addOrReplaceChild("chest_3", CubeListBuilder.create()
				.texOffs(100, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -4.0F, 0.0F));
		Crayer.addOrReplaceChild("chest_4", CubeListBuilder.create()
				.texOffs(100, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -4.0F, 0.0F));

		// the shared renderer hangs the banner off this part
		Crayer.addOrReplaceChild("BannerStick", CubeListBuilder.create()
				.texOffs(84, 0).addBox(12.0F, -94.0F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(@NotNull CrayerEntity crayerEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest1.visible = crayerEntity.getInvFillState() >= 15;
		this.chest2.visible = crayerEntity.getInvFillState() >= 30;
		this.chest3.visible = crayerEntity.getInvFillState() >= 60;
		this.chest4.visible = crayerEntity.getInvFillState() >= 90;

		this.steer.yRot = -crayerEntity.getRotSpeed() * 0.25F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.crayer;
	}
}

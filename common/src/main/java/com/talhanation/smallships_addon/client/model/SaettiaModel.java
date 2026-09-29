package com.talhanation.smallshipsaddon.client.model;

import com.talhanation.smallships.client.model.ShipModel;
import com.talhanation.smallshipsaddon.SmallShipsAddon;
import com.talhanation.smallshipsaddon.world.entity.ship.SaettiaEntity;
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
public class SaettiaModel extends ShipModel<SaettiaEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsAddon.MOD_ID, SaettiaEntity.ID + "_model"), "main");

	private final ModelPart saettia;
	private final ModelPart chest1;
	private final ModelPart chest2;
	private final ModelPart chest3;
	private final ModelPart chest4;
	private final ModelPart steer;

	public SaettiaModel(ModelPart modelPart) {
		this.saettia = modelPart;
		ModelPart saettia = this.saettia.getChild("Saettia");
		this.chest1 = saettia.getChild("chest_1");
		this.chest2 = saettia.getChild("chest_2");
		this.chest3 = saettia.getChild("chest_3");
		this.chest4 = saettia.getChild("chest_4");
		this.steer = saettia.getChild("steer");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Saettia = partdefinition.addOrReplaceChild("Saettia", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		// hull: narrow and sharp, built for a tideless sea with real quays
		Saettia.addOrReplaceChild("bottom", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-32.0F, -4.0F, -7.0F, 64.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Saettia.addOrReplaceChild("side_left", CubeListBuilder.create()
				.texOffs(0, 24).addBox(-32.0F, -11.0F, 7.0F, 64.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Saettia.addOrReplaceChild("side_right", CubeListBuilder.create()
				.texOffs(0, 24).addBox(-32.0F, -11.0F, -10.0F, 64.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		// a low pointed stern, not the Crayers' squared transom
		Saettia.addOrReplaceChild("transom", CubeListBuilder.create()
				.texOffs(0, 40).addBox(-35.0F, -13.0F, -7.0F, 3.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Saettia.addOrReplaceChild("bow", CubeListBuilder.create()
				.texOffs(44, 40).addBox(32.0F, -11.0F, -7.0F, 3.0F, 11.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		Saettia.addOrReplaceChild("mast", CubeListBuilder.create()
				.texOffs(84, 0).addBox(-2.0F, -58.0F, -2.0F, 4.0F, 58.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.12F));

		// the tiller, animated below
		Saettia.addOrReplaceChild("steer", CubeListBuilder.create()
				.texOffs(84, 0).addBox(0.0F, -7.0F, -1.0F, 4.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-36.0F, -14.0F, 0.0F));

		// cargo, shown step by step as the inventory fills up
		Saettia.addOrReplaceChild("chest_1", CubeListBuilder.create()
				.texOffs(100, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(14.0F, -4.0F, 0.0F));
		Saettia.addOrReplaceChild("chest_2", CubeListBuilder.create()
				.texOffs(100, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -4.0F, 0.0F));
		Saettia.addOrReplaceChild("chest_3", CubeListBuilder.create()
				.texOffs(100, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.0F, -4.0F, 0.0F));
		Saettia.addOrReplaceChild("chest_4", CubeListBuilder.create()
				.texOffs(100, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -4.0F, 0.0F));

		// the shared renderer hangs the banner off this part
		Saettia.addOrReplaceChild("BannerStick", CubeListBuilder.create()
				.texOffs(84, 0).addBox(12.0F, -94.0F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(@NotNull SaettiaEntity saettiaEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest1.visible = saettiaEntity.getInvFillState() >= 15;
		this.chest2.visible = saettiaEntity.getInvFillState() >= 30;
		this.chest3.visible = saettiaEntity.getInvFillState() >= 60;
		this.chest4.visible = saettiaEntity.getInvFillState() >= 90;

		this.steer.yRot = -saettiaEntity.getRotSpeed() * 0.25F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.saettia;
	}
}

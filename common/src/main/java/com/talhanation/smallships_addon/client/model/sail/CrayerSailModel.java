package com.talhanation.smallshipsaddon.client.model.sail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.world.entity.ship.Ship;
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
 * PLACEHOLDER geometry, real animation. One small square sail, reefed in four
 * steps the way every sail in the mod is.
 *
 * The state pattern is the one every sail in the mod follows:
 *   state 0 -> only the furled bundle is visible
 *   state N -> panels 1..N are visible (cumulative)
 *   exactly ONE bottom roll is visible at a time, the one below the last panel
 *
 * Replace createBodyLayer with your Blockbench export, keep setupAnim.
 */
public class CrayerSailModel extends SailModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsAddon.MOD_ID, CrayerEntity.ID + "_sail_model"), "main");

	private final ModelPart crayerSail;
	private final ModelPart sail_0;
	private final ModelPart sail_1;
	private final ModelPart sail_2;
	private final ModelPart sail_3;
	private final ModelPart sail_4;
	private final ModelPart sail_1_bottom;
	private final ModelPart sail_2_bottom;
	private final ModelPart sail_3_bottom;

	/**
	 * Same shape as the main mods' sail models: bake the layer right here in a
	 * no-arg constructor, so registering the sail is a single new call and the
	 * addon never has to touch the renderer context.
	 */
	public CrayerSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.crayerSail = root;
		ModelPart crayerSail = root.getChild("CrayerSail");
		this.sail_0 = crayerSail.getChild("sail_0");
		this.sail_1 = crayerSail.getChild("sail_1");
		this.sail_2 = crayerSail.getChild("sail_2");
		this.sail_3 = crayerSail.getChild("sail_3");
		this.sail_4 = crayerSail.getChild("sail_4");
		this.sail_1_bottom = crayerSail.getChild("sail_1_bottom");
		this.sail_2_bottom = crayerSail.getChild("sail_2_bottom");
		this.sail_3_bottom = crayerSail.getChild("sail_3_bottom");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition CrayerSail = partdefinition.addOrReplaceChild("CrayerSail", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		// the furled bundle, all panels stacked on the boom
		CrayerSail.addOrReplaceChild("sail_0", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-20.0F, -2.0F, -1.0F, 40.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -12.0F, 0.0F));

		// one panel per sail state, stacked upwards from the boom
		CrayerSail.addOrReplaceChild("sail_1", panel(), PartPose.offset(-6.0F, -24.0F, 0.0F));
		CrayerSail.addOrReplaceChild("sail_2", panel(), PartPose.offset(-6.0F, -36.0F, 0.0F));
		CrayerSail.addOrReplaceChild("sail_3", panel(), PartPose.offset(-6.0F, -48.0F, 0.0F));
		CrayerSail.addOrReplaceChild("sail_4", panel(), PartPose.offset(-6.0F, -60.0F, 0.0F));

		// the remaining bundle below the last set panel
		CrayerSail.addOrReplaceChild("sail_1_bottom", bundle(), PartPose.offset(-6.0F, -14.0F, 0.0F));
		CrayerSail.addOrReplaceChild("sail_2_bottom", bundle(), PartPose.offset(-6.0F, -26.0F, 0.0F));
		CrayerSail.addOrReplaceChild("sail_3_bottom", bundle(), PartPose.offset(-6.0F, -38.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	/** one cloth panel plus the spar along its foot */
	private static CubeListBuilder panel() {
		return CubeListBuilder.create()
				.texOffs(0, 8).addBox(-20.0F, 0.0F, -0.5F, 40.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-20.0F, 11.0F, -1.0F, 40.0F, 2.0F, 2.0F, new CubeDeformation(0.0F));
	}

	private static CubeListBuilder bundle() {
		return CubeListBuilder.create()
				.texOffs(0, 0).addBox(-20.0F, -2.0F, -1.0F, 40.0F, 4.0F, 2.0F, new CubeDeformation(0.0F));
	}

	@Override
	public void setupAnim(@NotNull Ship crayer, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		byte state = crayer.getData(Ship.SAIL_STATE);

		this.sail_0.visible = state == 0;
		this.sail_1.visible = state >= 1;
		this.sail_2.visible = state >= 2;
		this.sail_3.visible = state >= 3;
		this.sail_4.visible = state >= 4;

		// exactly one bottom roll, sitting under the topmost panel that is set
		this.sail_1_bottom.visible = state == 1;
		this.sail_2_bottom.visible = state == 2;
		this.sail_3_bottom.visible = state == 3;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		this.crayerSail.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}

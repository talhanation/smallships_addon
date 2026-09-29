package com.talhanation.smallshipsaddon.client.model.sail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.world.entity.ship.Ship;
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
 * PLACEHOLDER geometry, real animation. A LATEEN sail, and it reefs differently
 * from the Crayers' square sail: the cloth hangs off a single long yard slung
 * at an angle across the mast, so it is not rolled up from the foot but gathered
 * in along the yard, from the low forward end back towards the peak.
 *
 * The state pattern is still the one every sail in the mod follows:
 *   state 0 -> only the gathered bundle along the yard is visible
 *   state N -> panels 1..N are visible (cumulative)
 *   exactly ONE gathered remainder is visible at a time, ahead of the last panel
 *
 * The yard itself is always visible, unlike the square rigs' boom: a lateen
 * yard stays aloft whether the sail is set or not.
 *
 * Replace createBodyLayer with your Blockbench export, keep setupAnim.
 */
public class SaettiaSailModel extends SailModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsAddon.MOD_ID, SaettiaEntity.ID + "_sail_model"), "main");

	private final ModelPart saettiaSail;
	private final ModelPart sail_0;
	private final ModelPart sail_1;
	private final ModelPart sail_2;
	private final ModelPart sail_3;
	private final ModelPart sail_4;
	private final ModelPart sail_1_gathered;
	private final ModelPart sail_2_gathered;
	private final ModelPart sail_3_gathered;

	/**
	 * Same shape as the main mods' sail models: bake the layer right here in a
	 * no-arg constructor, so registering the sail is a single new call and the
	 * addon never has to touch the renderer context.
	 */
	public SaettiaSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.saettiaSail = root;
		ModelPart saettiaSail = root.getChild("SaettiaSail");
		this.sail_0 = saettiaSail.getChild("sail_0");
		this.sail_1 = saettiaSail.getChild("sail_1");
		this.sail_2 = saettiaSail.getChild("sail_2");
		this.sail_3 = saettiaSail.getChild("sail_3");
		this.sail_4 = saettiaSail.getChild("sail_4");
		this.sail_1_gathered = saettiaSail.getChild("sail_1_gathered");
		this.sail_2_gathered = saettiaSail.getChild("sail_2_gathered");
		this.sail_3_gathered = saettiaSail.getChild("sail_3_gathered");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition SaettiaSail = partdefinition.addOrReplaceChild("SaettiaSail", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		// the yard, slung across the mast at a steep angle - always aloft
		SaettiaSail.addOrReplaceChild("yard", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-38.0F, -1.5F, -1.5F, 76.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, -44.0F, 0.0F, 0.0F, 0.0F, -0.85F));

		// fully gathered: the whole sail bundled along the yard
		SaettiaSail.addOrReplaceChild("sail_0", gathered(36.0F), yardPose());

		// the sail drops from the yard in panels, peak first, foot last
		SaettiaSail.addOrReplaceChild("sail_1", panel(0.0F, 14.0F), yardPose());
		SaettiaSail.addOrReplaceChild("sail_2", panel(14.0F, 26.0F), yardPose());
		SaettiaSail.addOrReplaceChild("sail_3", panel(26.0F, 36.0F), yardPose());
		SaettiaSail.addOrReplaceChild("sail_4", panel(36.0F, 44.0F), yardPose());

		// what is still bundled ahead of the last set panel
		SaettiaSail.addOrReplaceChild("sail_1_gathered", gathered(24.0F), yardPose());
		SaettiaSail.addOrReplaceChild("sail_2_gathered", gathered(14.0F), yardPose());
		SaettiaSail.addOrReplaceChild("sail_3_gathered", gathered(6.0F), yardPose());

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	/** every sail part hangs off the same slung yard, so they share its pose */
	private static PartPose yardPose() {
		return PartPose.offsetAndRotation(-4.0F, -44.0F, 0.0F, 0.0F, 0.0F, -0.85F);
	}

	/**
	 * One band of cloth below the yard. A lateen is triangular, so a band
	 * further from the peak is both longer and deeper - the placeholder fakes
	 * that by widening with distance.
	 */
	private static CubeListBuilder panel(float from, float to) {
		float depth = to - from;
		return CubeListBuilder.create()
				.texOffs(0, 8).addBox(-38.0F + from, -depth * 0.5F, -0.5F, 30.0F + from * 0.6F, depth, 1.0F, new CubeDeformation(0.0F));
	}

	/** the bundled remainder, a roll lying along the yard */
	private static CubeListBuilder gathered(float length) {
		return CubeListBuilder.create()
				.texOffs(0, 0).addBox(-38.0F, -2.5F, -2.5F, length, 5.0F, 5.0F, new CubeDeformation(0.0F));
	}

	@Override
	public void setupAnim(@NotNull Ship saettia, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		byte state = saettia.getData(Ship.SAIL_STATE);

		this.sail_0.visible = state == 0;
		this.sail_1.visible = state >= 1;
		this.sail_2.visible = state >= 2;
		this.sail_3.visible = state >= 3;
		this.sail_4.visible = state >= 4;

		// exactly one gathered remainder, ahead of the topmost panel that is set
		this.sail_1_gathered.visible = state == 1;
		this.sail_2_gathered.visible = state == 2;
		this.sail_3_gathered.visible = state == 3;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		this.saettiaSail.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}

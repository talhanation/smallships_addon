package com.talhanation.smallshipsaddon.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.talhanation.smallships.client.renderer.entity.ShipRenderer;
import com.talhanation.smallshipsaddon.SmallShipsAddon;
import com.talhanation.smallshipsaddon.client.model.CrayerModel;
import com.talhanation.smallshipsaddon.world.entity.ship.CrayerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

/**
 * ShipRenderer does the heavy lifting - hull, sail, banner, sail damage, and
 * the guns on a ship that has any. An addon renderer only supplies its model
 * and its textures.
 *
 * getTextureLocation must be overridden: the base class builds the path in the
 * MAIN mods' namespace, which would send this addon looking for its oak texture
 * inside smallships.
 */
public class CrayerRenderer extends ShipRenderer<CrayerEntity> {
    public CrayerRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected CrayerModel createBoatModel(EntityRendererProvider.Context context, Boat.Type type) {
        return new CrayerModel(context.bakeLayer(CrayerModel.LAYER_LOCATION));
    }

    @Override
    protected ResourceLocation getTextureLocation(Boat.Type type) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsAddon.MOD_ID, "textures/entity/ship/" + ShipRenderer.getNameFromType(type) + ".png");
    }

    @Override
    public void render(@NotNull CrayerEntity crayerEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.translate(0.0D, 2.2D, 0.0D);
        super.render(crayerEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}

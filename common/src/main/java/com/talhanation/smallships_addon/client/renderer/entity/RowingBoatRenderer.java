package com.talhanation.smallships_addon.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.renderer.entity.ShipRenderer;
import com.talhanation.smallships_addon.client.model.RowingBoatModel;
import com.talhanation.smallships_addon.world.entity.ship.RowingBoatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;


/**
 * ShipRenderer does the heavy lifting (hull, sail, banners, damage, cannons).
 * An addon renderer only supplies its model and its texture.
 */
public class RowingBoatRenderer extends ShipRenderer<RowingBoatEntity> {
    public RowingBoatRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected RowingBoatModel createBoatModel(EntityRendererProvider.Context context, Boat.Type type) {
        // the layer must be registered in the loader module, otherwise the game crashes on startup
        return new RowingBoatModel(context.bakeLayer(RowingBoatModel.LAYER_LOCATION));
    }

    @Override
    protected ResourceLocation getTextureLocation(Boat.Type type) {
        // reuses the main mods' hull textures - use SmallShipsAddon.MOD_ID to ship your own
        return new ResourceLocation(SmallShipsMod.MOD_ID, "textures/entity/ship/" + ShipRenderer.getNameFromType(type) + ".png");
    }

    @Override
    public void render(@NotNull RowingBoatEntity boat, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        // ShipRenderer#render pops this pose again
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        // lifts the model onto the waterline, tune per ship
        poseStack.translate(0.0D, 2.7D, 0.0D);
        super.render(boat, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}

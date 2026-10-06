package com.talhanation.smallships_addon.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships_addon.world.entity.ship.FishingNetEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/**
 * Draws nothing. The net entity is only the box the net fishes in - the net
 * the player sees is part of the boat model, see FishingBoatModel.
 *
 * This class exists only because vanilla refuses to start with an entity type
 * that has no renderer.
 */
public class FishingNetRenderer extends EntityRenderer<FishingNetEntity> {

    public FishingNetRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(@NotNull FishingNetEntity netEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
    }

    /**
     * Keeps the net out of the render loop unless the hitboxes are on. The
     * wireframe is drawn by EntityRenderDispatcher, so F3 + B still shows
     * whether the box sits where the model draws the net.
     */
    @Override
    public boolean shouldRender(@NotNull FishingNetEntity netEntity, @NotNull Frustum frustum, double camX, double camY, double camZ) {
        return this.entityRenderDispatcher.shouldRenderHitBoxes() && super.shouldRender(netEntity, frustum, camX, camY, camZ);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull FishingNetEntity netEntity) {
        return MissingTextureAtlasSprite.getLocation();
    }
}

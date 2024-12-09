package net.ohfired.silver_innovation.entity.client.renderer;

import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.entity.client.ModModelLayers;
import net.ohfired.silver_innovation.entity.client.SilverGolemModel;
import net.ohfired.silver_innovation.entity.custom.SilverGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SilverGolemRenderer extends MobRenderer<SilverGolemEntity, SilverGolemModel<SilverGolemEntity>> {
    public SilverGolemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SilverGolemModel<>(pContext.bakeLayer(ModModelLayers.SILVER_GOLEM_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(SilverGolemEntity pEntity) {
        return new ResourceLocation(SilverInnovation.MOD_ID, "textures/entity/silver_golem.png");
    }
}

package net.ohfired.silver_innovation.entity.client.renderer;

import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.entity.projectile.SilverMissileEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SilverMissileRenderer extends ArrowRenderer<SilverMissileEntity> {
    public SilverMissileRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(SilverMissileEntity pEntity) {
        return new ResourceLocation(SilverInnovation.MOD_ID, "textures/entity/projectiles/silver_missile.png");
    }
}

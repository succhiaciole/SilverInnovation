package net.coder.silver_innovation.entity.client.renderer;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.entity.projectile.SilverMissleEntity;
import net.coder.silver_innovation.item.ModItems;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SilverMissleRenderer extends ArrowRenderer<SilverMissleEntity> {
    public SilverMissleRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(SilverMissleEntity pEntity) {
        Item referenceItem = ModItems.SILVER_MISSLE.get();
        return new ResourceLocation(SilverInnovation.MOD_ID, "textures/entity/projectiles" + "silver_missle" + ".png");
    }
}

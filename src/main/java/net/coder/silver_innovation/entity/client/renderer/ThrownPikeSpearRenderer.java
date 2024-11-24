package net.coder.silver_innovation.entity.client.renderer;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.entity.projectile.SilverMissleEntity;
import net.coder.silver_innovation.entity.projectile.ThrownPikeSpear;
import net.coder.silver_innovation.item.ModItems;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ThrownPikeSpearRenderer extends ArrowRenderer<ThrownPikeSpear> {
    private final ResourceLocation TEXTURE = new ResourceLocation(SilverInnovation.MOD_ID, "textures/block/silver_block.png");

    public ThrownPikeSpearRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownPikeSpear pEntity) {
        Item referenceItem = ModItems.PIKE_SPEAR.get();
        return TEXTURE;
    }
}

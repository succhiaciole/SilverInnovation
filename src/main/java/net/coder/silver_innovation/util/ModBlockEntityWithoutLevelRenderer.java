package net.coder.silver_innovation.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.entity.client.ThrownPikeSpearModel;
import net.coder.silver_innovation.entity.client.renderer.ThrownPikeSpearRenderer;
import net.coder.silver_innovation.item.ModItems;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("rawtypes")
public class ModBlockEntityWithoutLevelRenderer extends BlockEntityWithoutLevelRenderer implements ResourceManagerReloadListener {
    private ThrownPikeSpearModel pikeSpearModel;
    private final EntityModelSet entityModelSet;
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;
    private final ResourceLocation TEXTURE = new ResourceLocation(SilverInnovation.MOD_ID, "textures/block/silver_block.png");

    public ModBlockEntityWithoutLevelRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet, EntityModelSet entityModelSet, BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
        super(pBlockEntityRenderDispatcher, pEntityModelSet);
        this.entityModelSet = entityModelSet;
        this.blockEntityRenderDispatcher = blockEntityRenderDispatcher;
    }

    public void onResourceManagerReload(ResourceManager pResourceManager) {
        this.pikeSpearModel = new ThrownPikeSpearModel(this.entityModelSet.bakeLayer(ThrownPikeSpearModel.LAYER_LOCATION));
    }

    public void renderByItem(ItemStack pStack, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (pStack.is(ModItems.PIKE_SPEAR.get())) {
            pPoseStack.pushPose();
            pPoseStack.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer1 = ItemRenderer.getFoilBufferDirect(pBuffer, this.pikeSpearModel.renderType(this.TEXTURE), false, pStack.hasFoil());
            this.pikeSpearModel.renderToBuffer(pPoseStack, vertexconsumer1, pPackedLight, pPackedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            pPoseStack.popPose();
        }
    }
}


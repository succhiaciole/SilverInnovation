package net.coder.silver_innovation.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.coder.silver_innovation.entity.client.ModModelLayers;
import net.coder.silver_innovation.entity.client.PikeSpearModel;
import net.coder.silver_innovation.item.ModItems;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModBlockEntityWithoutLevelRenderer implements ResourceManagerReloadListener {
    private PikeSpearModel pikeSpearModel;
    private final EntityModelSet entityModelSet;


    public ModBlockEntityWithoutLevelRenderer(EntityModelSet pEntityModelSet) {
        this.entityModelSet = pEntityModelSet;
    }

    public void onResourceManagerReload(ResourceManager pResourceManager) {
        this.pikeSpearModel = new PikeSpearModel(this.entityModelSet.bakeLayer(ModModelLayers.PIKE_SPEAR_LAYER));
    }

    public void renderByItem(ItemStack pStack, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (pStack.is(ModItems.PIKE_SPEAR.get())) {
                pPoseStack.pushPose();
                pPoseStack.scale(1.0F, -1.0F, -1.0F);
                VertexConsumer vertexconsumer1 = ItemRenderer.getFoilBufferDirect(pBuffer, this.pikeSpearModel.renderType(PikeSpearModel.TEXTURE), false, pStack.hasFoil());
                this.pikeSpearModel.renderToBuffer(pPoseStack, vertexconsumer1, pPackedLight, pPackedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
                pPoseStack.popPose();
        }
    }
}

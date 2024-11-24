package net.coder.silver_innovation.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.entity.client.ModModelLayers;
import net.coder.silver_innovation.entity.client.PikeSpearModel;
import net.coder.silver_innovation.entity.client.SilverGolemModel;
import net.coder.silver_innovation.entity.projectile.ThrownPikeSpear;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ThrownPikeSpearRenderer extends EntityRenderer<ThrownPikeSpear> {
    public static final ResourceLocation PIKE_SPEAR_LOCATION = new ResourceLocation(SilverInnovation.MOD_ID, "textures/entity/pike_spear.png");
    public final PikeSpearModel model;

    public ThrownPikeSpearRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new PikeSpearModel(pContext.bakeLayer(ModModelLayers.PIKE_SPEAR_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownPikeSpear pEntity) {
        return PIKE_SPEAR_LOCATION;
    }

    public void render(ThrownPikeSpear pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}

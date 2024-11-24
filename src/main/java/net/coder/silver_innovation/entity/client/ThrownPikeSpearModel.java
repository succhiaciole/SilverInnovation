package net.coder.silver_innovation.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.coder.silver_innovation.SilverInnovation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ThrownPikeSpearModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SilverInnovation.MOD_ID, "pike_spear "), "main");
    private final ModelPart pike_spear;
    private final ModelPart head;
    private final ModelPart handle;

    public ThrownPikeSpearModel(ModelPart root) {
        this.pike_spear = root.getChild("pike_spear");
        this.head = this.pike_spear.getChild("head");
        this.handle = this.pike_spear.getChild("handle");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition pike_spear = partdefinition.addOrReplaceChild("pike_spear", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = pike_spear.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 0).addBox(-1.0F, -32.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 0).addBox(-2.0F, -31.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 5).addBox(-1.0F, -31.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 5).addBox(-1.0F, -31.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 10).addBox(0.0F, -30.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 10).addBox(0.0F, -30.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-2.0F, -30.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 4).addBox(-2.0F, -30.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 8).addBox(-3.0F, -30.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(-1.0F, -30.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 14).addBox(1.0F, -30.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 14).addBox(-1.0F, -30.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition handle = pike_spear.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -27.0F, -1.0F, 1.0F, 27.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        pike_spear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}

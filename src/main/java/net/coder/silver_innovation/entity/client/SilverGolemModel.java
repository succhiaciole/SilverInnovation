package net.coder.silver_innovation.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.coder.silver_innovation.entity.animations.ModAnimationDefinitions;
import net.coder.silver_innovation.entity.custom.SilverGolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class SilverGolemModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart silver_golem;
	private final ModelPart head;


	public SilverGolemModel(ModelPart root) {
		this.silver_golem = root.getChild("silver_golem");
		this.head = root.getChild("silver_golem").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition silver_golem = partdefinition.addOrReplaceChild("silver_golem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = silver_golem.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -45.0F, -5.0F, 14.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest = silver_golem.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(38, 58).addBox(-4.0F, -32.0F, -2.0F, 8.0F, 21.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-12.0F, -33.0F, -3.0F, 24.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(30, 86).addBox(4.0F, -32.0F, -2.0F, 7.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(98, 58).addBox(4.0F, -22.0F, -2.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(98, 69).addBox(-8.0F, -22.0F, -2.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(58, 86).addBox(-11.0F, -32.0F, -2.0F, 7.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arms = silver_golem.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = arms.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 37).addBox(-21.0F, -35.0F, -4.0F, 14.0F, 10.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(68, 58).addBox(-19.0F, -31.0F, -3.0F, 6.0F, 19.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(54, 0).addBox(-20.0F, -18.0F, -4.0F, 8.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = arms.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(50, 37).addBox(7.0F, -35.0F, -4.0F, 14.0F, 10.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 79).addBox(13.0F, -31.0F, -3.0F, 6.0F, 19.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 58).addBox(12.0F, -18.0F, -4.0F, 8.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = silver_golem.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(66, 21).addBox(4.0F, -7.0F, -2.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(100, 32).addBox(9.0F, -12.0F, -2.0F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(86, 86).addBox(4.0F, -18.0F, -2.0F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(92, 0).addBox(-11.0F, -7.0F, -2.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(100, 44).addBox(-11.0F, -12.0F, -2.0F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(94, 14).addBox(-9.0F, -18.0F, -2.0F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.WALK, limbSwing, limbSwingAmount, 1.6f, 2.5f);
		this.animate(((SilverGolemEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 0.6f);
		this.animate(((SilverGolemEntity) entity).attackAnimationState, ModAnimationDefinitions.ATTACK, ageInTicks, 1.2f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, 0F, 0F);
		pHeadPitch = Mth.clamp(pHeadPitch, 0F, 0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		silver_golem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return silver_golem;
	}
}
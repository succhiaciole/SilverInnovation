package net.ohfired.silver_innovation.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class SilverSpikesBlock extends Block {
    public SilverSpikesBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)pEntity;
            if (!livingentity.isInvulnerableTo(pLevel.damageSources().sting(livingentity))) {
                livingentity.hurt(pLevel.damageSources().cactus(), 1.5f);
                pEntity.makeStuckInBlock(pState, new Vec3(0.25D, 0.05F, 0.25D));
            }
        }
    }
}

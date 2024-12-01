package net.coder.silver_innovation.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModHangingSingBlockEntity extends SignBlockEntity {
    public ModHangingSingBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.MOD_HANGING_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_HANGING_SIGN.get();
    }
}
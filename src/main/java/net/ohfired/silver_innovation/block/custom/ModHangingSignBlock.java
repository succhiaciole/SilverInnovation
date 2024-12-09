package net.ohfired.silver_innovation.block.custom;

import net.ohfired.silver_innovation.block.entity.ModHangingSingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModHangingSignBlock extends CeilingHangingSignBlock {
    public ModHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModHangingSingBlockEntity(pPos, pState);
    }
}

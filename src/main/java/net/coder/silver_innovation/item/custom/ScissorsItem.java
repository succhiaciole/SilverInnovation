package net.coder.silver_innovation.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class ScissorsItem extends Item {
    private static final int BAR_COLOR = Mth.color(5.0F, 5.0F, 5.0F);

    public ScissorsItem(Properties pProperties) {
        super(pProperties);
    }

    public int getBarColor(ItemStack pStack) {
        return BAR_COLOR;
    }

    public boolean isCorrectToolForDrops(BlockState pBlock) {
        return pBlock.is(Blocks.COBWEB) || pBlock.is(Blocks.REDSTONE_WIRE) || pBlock.is(Blocks.TRIPWIRE);
    }

    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if (!pState.is(Blocks.COBWEB) && !pState.is(BlockTags.LEAVES)) {
            if (pState.is(BlockTags.WOOL)) {
                return 5.0F;
            } else {
                return !pState.is(Blocks.VINE) && !pState.is(Blocks.GLOW_LICHEN) ? super.getDestroySpeed(pStack, pState) : 2.0F;
            }
        } else {
            return 15.0F;
        }
    }
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && !pState.is(BlockTags.FIRE)) {
            pStack.hurtAndBreak(1, pEntityLiving, (p_43076_) -> {
                p_43076_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }

        return !pState.is(BlockTags.LEAVES) && !pState.is(Blocks.COBWEB) && !pState.is(Blocks.GRASS) && !pState.is(Blocks.FERN) && !pState.is(Blocks.DEAD_BUSH) && !pState.is(Blocks.HANGING_ROOTS) && !pState.is(Blocks.VINE) && !pState.is(Blocks.TRIPWIRE) && !pState.is(BlockTags.WOOL) ? super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving) : true;
    }
}

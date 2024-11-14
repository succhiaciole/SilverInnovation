package net.coder.silver_innovation.item.custom;

import net.coder.silver_innovation.sound.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class SilverShortbowItem extends BowItem {
    public static final int DEFAULT_RANGE = 15;
    private static final int BAR_COLOR = Mth.color(5.0F, 5.0F, 5.0F);

    public SilverShortbowItem(Properties pProperties) {
        super(pProperties);
    }

    public int getBarColor(ItemStack pStack) {
        return BAR_COLOR;
    }

    @Override
    public int getDefaultProjectileRange() {
        return DEFAULT_RANGE;
    }

    @Override
        public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
            if (pEntityLiving instanceof Player player) {
                boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
                ItemStack itemstack = player.getProjectile(pStack);

                int i = this.getUseDuration(pStack) - pTimeLeft;
                i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pStack, pLevel, player, i, !itemstack.isEmpty() || flag);
                if (i < 0) return;

                if (!itemstack.isEmpty() || flag) {
                    if (itemstack.isEmpty()) {
                        itemstack = new ItemStack(Items.ARROW);
                    }

                    float f = getPowerForTime(i);
                    if (!((double)f < 0.1D)) {
                        boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, pStack, player));
                        if (!pLevel.isClientSide) {
                            ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                            AbstractArrow abstractarrow = arrowitem.createArrow(pLevel, itemstack, player);
                            abstractarrow = customArrow(abstractarrow);
                            abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 4.0F, 0.8F);
                            if (f == 1.0F) {
                                abstractarrow.setCritArrow(true);
                            }

                            int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
                            if (j > 0) {
                                abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)j * 0.5D + 0.5D);
                            }

                            int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, pStack);
                            if (k > 0) {
                                abstractarrow.setKnockback(k);
                            }

                            if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, pStack) > 0) {
                                abstractarrow.setSecondsOnFire(100);
                            }

                            pStack.hurtAndBreak(1, player, (p_289501_) -> {
                                p_289501_.broadcastBreakEvent(player.getUsedItemHand());
                            });
                            if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
                                abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            }

                            pLevel.addFreshEntity(abstractarrow);
                        }

                        pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), ModSounds.SILVER_BOW.get(), SoundSource.PLAYERS, 1.0F, 1.2F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                        if (!flag1 && !player.getAbilities().instabuild) {
                            itemstack.shrink(1);
                            if (itemstack.isEmpty()) {
                                player.getInventory().removeItem(itemstack);
                            }
                        }

                        player.awardStat(Stats.ITEM_USED.get(this));
                    }
                }
            }
        }

    public static float getPowerForTime(int pCharge) {
        float f = (float)pCharge / 10.0F;
        f = (f * f + f) / 1.5F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }
}


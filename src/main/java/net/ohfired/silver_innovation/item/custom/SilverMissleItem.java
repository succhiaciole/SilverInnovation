package net.ohfired.silver_innovation.item.custom;

import net.ohfired.silver_innovation.entity.projectile.SilverMissleEntity;
import net.ohfired.silver_innovation.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SilverMissleItem extends ArrowItem {
    public final float damage;

    public SilverMissleItem(float damage, Properties pProperties) {
        super(pProperties);
        this.damage = damage;
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        SilverMissleEntity arrow = new SilverMissleEntity(pShooter, pLevel, ModItems.SILVER_MISSLE.get());
        arrow.setBaseDamage(this.damage);
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant > 0 && this.getClass() == SilverMissleItem.class;
    }
}

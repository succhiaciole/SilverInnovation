package net.ohfired.silver_innovation.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.ohfired.silver_innovation.item.custom.SilverHammerItem;

public class DeepseekEnchantment extends Enchantment {
        public DeepseekEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
            super(pRarity, EnchantmentCategory.create("SILVER_HAMMER", (item ->(item instanceof SilverHammerItem))), pApplicableSlots);
        }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    public int getMinCost(int pEnchantmentLevel) {
        return pEnchantmentLevel * 45;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 65;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    protected boolean checkCompatibility(Enchantment pOther) {
        return this != Enchantments.SILK_TOUCH;
    }
}


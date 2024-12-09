package net.ohfired.silver_innovation.enchantment;

import net.ohfired.silver_innovation.item.custom.HammerItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class ThicknessEnchantment extends Enchantment {
        public ThicknessEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
            super(pRarity, EnchantmentCategory.create("SILVER_HAMMER", (item ->(item instanceof HammerItem))), pApplicableSlots);
        }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    public int getMinCost(int pEnchantmentLevel) {
        return pEnchantmentLevel * 25;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 50;
    }

    protected boolean checkCompatibility(Enchantment pOther) {
        return this != Enchantments.SILK_TOUCH;
    }
}


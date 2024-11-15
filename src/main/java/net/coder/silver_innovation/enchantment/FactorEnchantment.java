package net.coder.silver_innovation.enchantment;

import net.coder.silver_innovation.item.custom.SilverBowItem;
import net.coder.silver_innovation.item.custom.SilverLongbowItem;
import net.coder.silver_innovation.item.custom.SilverShortbowItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class FactorEnchantment extends Enchantment {
        public FactorEnchantment(Enchantment.Rarity pRarity, EquipmentSlot... pApplicableSlots) {
            super(pRarity, EnchantmentCategory.create("SILVER_BOWS", (item ->(item instanceof SilverBowItem || item instanceof SilverLongbowItem|| item instanceof SilverShortbowItem))), pApplicableSlots);
        }

    public int getMinCost(int pEnchantmentLevel) {
        return 20;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return 50;
    }

}


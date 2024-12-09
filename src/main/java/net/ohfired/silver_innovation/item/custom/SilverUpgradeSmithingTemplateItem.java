package net.ohfired.silver_innovation.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class SilverUpgradeSmithingTemplateItem extends Item {
    public SilverUpgradeSmithingTemplateItem(Properties pProperties) {
        super(pProperties);
    }

    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add(Component.literal("§7Silver Upgrade"));
        list.add(Component.literal(""));
        list.add(Component.literal("§7Applies to:"));
        list.add(Component.literal(" §9Iron Equipment"));
        list.add(Component.literal("§7Ingredients:"));
        list.add(Component.literal(" §9Silver Ingot"));
    }

}

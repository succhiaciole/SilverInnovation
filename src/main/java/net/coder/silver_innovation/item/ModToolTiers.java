package net.coder.silver_innovation.item;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SILVER = TierSortingRegistry.registerTier(
            new ForgeTier(3, 574, 6.0f, 2.7f, 15,
                    ModTags.Blocks.NEEDS_SILVER_TOOL, () -> Ingredient.of(ModItems.SILVER_INGOT.get())),
            new ResourceLocation(SilverInnovation.MOD_ID, "silver"), List.of(Tiers.STONE), List.of(Tiers.DIAMOND));

}

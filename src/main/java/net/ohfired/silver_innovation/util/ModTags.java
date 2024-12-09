package net.ohfired.silver_innovation.util;

import net.ohfired.silver_innovation.SilverInnovation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_SILVER_TOOL = tag("needs_silver_tool");
        public static final TagKey<Block> MAHOGANY_LOGS = tag("mahogany_logs");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SilverInnovation.MOD_ID, name));
        }

    }
    public static class Items {
        public static final TagKey<Item> MAHOGANY_LOGS = tag("mahogany_logs");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SilverInnovation.MOD_ID, name));
        }

    }
}

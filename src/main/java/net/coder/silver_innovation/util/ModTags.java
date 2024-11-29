package net.coder.silver_innovation.util;

import net.coder.silver_innovation.SilverInnovation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;

public class ModTags {
    public static class Blocks {
        public static final TagKey<net.minecraft.world.level.block.Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<net.minecraft.world.level.block.Block> NEEDS_SILVER_TOOL = tag("needs_silver_tool");
        public static final TagKey<net.minecraft.world.level.block.Block> MAHOGANY_LOGS = tag("mahogany_logs");


        private static TagKey<net.minecraft.world.level.block.Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SilverInnovation.MOD_ID, name));
        }

    }
    public static class Items {
        public static final TagKey<net.minecraft.world.item.Item> MAHOGANY_LOGS = tag("mahogany_logs");


        private static TagKey<net.minecraft.world.item.Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SilverInnovation.MOD_ID, name));
        }

    }
}

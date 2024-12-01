package net.coder.silver_innovation.datagen;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.block.ModBlocks;
import net.coder.silver_innovation.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SilverInnovation.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_CARBON_ORE.get())
                .add(ModBlocks.CARBON_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_CARBON_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(ModTags.Blocks.NEEDS_SILVER_TOOL)
                .add(ModBlocks.SILVER_SLAB.get(),
                    (ModBlocks.SILVER_STAIRS.get()),
                    (ModBlocks.SILVER_TRAPDOOR.get()),
                    (ModBlocks.SILVER_WALL.get()),
                    (ModBlocks.SILVER_FENCE.get()),
                    (ModBlocks.SILVER_FENCE_GATE.get()),
                    (ModBlocks.SILVER_DOOR.get()),
                    (ModBlocks.SILVER_FOUNDRY.get()));

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SILVER_ORE.get(),
                    (ModBlocks.DEEPSLATE_SILVER_ORE.get()),
                    (ModBlocks.CARBON_ORE.get()));

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SILVER_ORE.get(),
                    (ModBlocks.DEEPSLATE_SILVER_ORE.get()),
                        (ModBlocks.SILVER_BLOCK.get()),
                        (ModBlocks.RAW_SILVER_BLOCK.get()),
                        (ModBlocks.DEEPSLATE_CARBON_ORE.get()),
                        (ModBlocks.CARBON_ORE.get()),
                        (ModBlocks.SILVER_SLAB.get()),
                        (ModBlocks.SILVER_STAIRS.get()),
                        (ModBlocks.SILVER_TRAPDOOR.get()),
                        (ModBlocks.SILVER_WALL.get()),
                        (ModBlocks.SILVER_FENCE.get()),
                        (ModBlocks.SILVER_FENCE_GATE.get()),
                        (ModBlocks.SILVER_DOOR.get()),
                        (ModBlocks.SILVER_PRESSURE_PLATE.get()),
                        (ModBlocks.SILVER_BUTTON.get()),
                        (ModBlocks.SILVER_FOUNDRY.get()));


        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.CARBON_DUST_BLOCK.get());


        this.tag(BlockTags.FENCES)
                .add(ModBlocks.SILVER_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.SILVER_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.SILVER_WALL.get());
        this.tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.SILVER_PRESSURE_PLATE.get());
        this.tag(BlockTags.BUTTONS)
                .add(ModBlocks.SILVER_BUTTON.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAHOGANY_LOG.get())
                .add(ModBlocks.MAHOGANY_WOOD.get())
                .add(ModBlocks.STRIPPED_MAHOGANY_LOG.get())
                .add(ModBlocks.STRIPPED_MAHOGANY_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.MAHOGANY_PLANKS.get());

        this.tag(ModTags.Blocks.MAHOGANY_LOGS)
                .add(ModBlocks.MAHOGANY_LOG.get())
                .add(ModBlocks.MAHOGANY_WOOD.get())
                .add(ModBlocks.STRIPPED_MAHOGANY_LOG.get())
                .add(ModBlocks.STRIPPED_MAHOGANY_WOOD.get());

        this.tag(BlockTags.SIGNS)
                .add(ModBlocks.MAHOGANY_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS)
                .add(ModBlocks.MAHOGANY_WALL_SIGN.get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.MAHOGANY_HANGING_SIGN.get());
        this.tag(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.MAHOGANY_WALL_HANGING_SIGN.get());

    }
}

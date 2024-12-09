package net.ohfired.silver_innovation.datagen;

import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.block.ModBlocks;
import net.ohfired.silver_innovation.item.ModItems;
import net.ohfired.silver_innovation.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, SilverInnovation.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SILVER_HELMET.get(),
                    ModItems.SILVER_CHESTPLATE.get(),
                    ModItems.SILVER_LEGGINGS.get(),
                    ModItems.SILVER_BOOTS.get());

        this.tag(Tags.Items.TOOLS_BOWS)
                .add(ModItems.SILVER_BOW.get(),
                     ModItems.SILVER_LONGBOW.get(),
                     ModItems.SILVER_SHORTBOW.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MAHOGANY_LOG.get().asItem())
                .add(ModBlocks.MAHOGANY_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAHOGANY_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAHOGANY_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.MAHOGANY_PLANKS.get().asItem());

        this.tag(ModTags.Items.MAHOGANY_LOGS)
                .add(ModBlocks.MAHOGANY_LOG.get().asItem())
                .add(ModBlocks.MAHOGANY_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_MAHOGANY_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_MAHOGANY_WOOD.get().asItem());
    }
}

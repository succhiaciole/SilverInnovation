package net.coder.silver_innovation.datagen;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.block.ModBlocks;
import net.coder.silver_innovation.item.ModItems;
import net.coder.silver_innovation.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SILVER_SMELTABLES = List.of(
            ModItems.RAW_SILVER.get(),
            ModBlocks.SILVER_ORE.get(),
            ModBlocks.DEEPSLATE_SILVER_ORE.get());
    private static final List<ItemLike> CARBON_SMELTABLES = List.of(
            ModBlocks.CARBON_ORE.get(),
            ModBlocks.DEEPSLATE_CARBON_ORE.get());
    private static final List<ItemLike> TO_ANTHRACITE = List.of(
            ModItems.CARBON_DUST.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.25f, 100, "silver");
        oreSmelting(pWriter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 0.25f, 200, "silver");
        oreBlasting(pWriter, CARBON_SMELTABLES, RecipeCategory.MISC, ModItems.CARBON_DUST.get(), 0.25f, 100, "carbon");
        oreSmelting(pWriter, CARBON_SMELTABLES, RecipeCategory.MISC, ModItems.CARBON_DUST.get(), 0.25f, 200, "carbon");
        oreSmelting(pWriter, TO_ANTHRACITE, RecipeCategory.MISC, ModItems.ANTHRACITE.get(), 0.75f, 500, "anthracite");


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_SLAB.get(),6)
                .pattern("   ")
                .pattern("SSS")
                .pattern("   ")
                .define('S', ModBlocks.SILVER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_WALL.get(),6)
                .pattern("   ")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModBlocks.SILVER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_DOOR.get(),3)
                .pattern(" SS")
                .pattern(" SS")
                .pattern(" SS")
                .define('S', ModBlocks.SILVER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_TRAPDOOR.get(),2)
                .pattern("   ")
                .pattern("SS ")
                .pattern("SS ")
                .define('S', ModBlocks.SILVER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_FENCE.get(), 6)
                .pattern("   ")
                .pattern("SAS")
                .pattern("SAS")
                .define('S', ModBlocks.SILVER_BLOCK.get())
                .define('A', ModItems.SILVER_LIMB.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_FENCE_GATE.get(), 2)
                .pattern("   ")
                .pattern("ASA")
                .pattern("ASA")
                .define('S', ModBlocks.SILVER_BLOCK.get())
                .define('A', ModItems.SILVER_LIMB.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_STAIRS.get(), 6)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .define('S', ModBlocks.SILVER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_PRESSURE_PLATE.get(), 2)
                .pattern("   ")
                .pattern("SS ")
                .pattern("   ")
                .define('S', ModBlocks.SILVER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SILVER_INGOT.get())
                .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARBON_DUST_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.CARBON_DUST.get())
                .unlockedBy(getHasName(ModItems.CARBON_DUST.get()), has(ModItems.CARBON_DUST.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_SILVER_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAW_SILVER.get())
                .unlockedBy(getHasName(ModItems.RAW_SILVER.get()), has(ModItems.RAW_SILVER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.METAL_DETECTOR.get())
                .pattern("  T")
                .pattern(" S ")
                .pattern("SA ")
                .define('S', ModItems.SILVER_INGOT.get())
                .define('A', Items.REDSTONE)
                .define('T', Items.STICK)
                .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_GOLEM_SPAWN_EGG.get())
                .pattern(" T ")
                .pattern("AAA")
                .pattern(" A ")
                .define('A', ModBlocks.SILVER_BLOCK.get())
                .define('T', Blocks.CARVED_PUMPKIN)
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SILVER_BOW.get())
                .pattern(" #A")
                .pattern("# Z")
                .pattern(" #A")
                .define('#', ModItems.SILVER_LIMB.get())
                .define('A', Items.STRING)
                .define('Z', ModItems.CARBON_DUST.get())
                .unlockedBy(getHasName(ModItems.SILVER_LIMB.get()), has(ModItems.SILVER_LIMB.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SILVER_LONGBOW.get())
                .pattern(" #A")
                .pattern("#HZ")
                .pattern(" #A")
                .define('#', ModItems.SILVER_LIMB.get())
                .define('A', Items.STRING)
                .define('Z', ModItems.CARBON_DUST.get())
                .define('H', ModItems.SILVER_BOW.get())
                .unlockedBy(getHasName(ModItems.SILVER_BOW.get()), has(ModItems.SILVER_BOW.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SILVER_SHORTBOW.get())
                .pattern(" A ")
                .pattern("#XZ")
                .pattern(" A ")
                .define('#', ModItems.SILVER_LIMB.get())
                .define('A', Items.STRING)
                .define('Z', ModItems.CARBON_DUST.get())
                .define('X', ModItems.SILVER_BOW.get())
                .unlockedBy(getHasName(ModItems.SILVER_BOW.get()), has(ModItems.SILVER_BOW.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_WOOD.get())
                .pattern("   ")
                .pattern(" ##")
                .pattern(" ##")
                .define('#', ModBlocks.MAHOGANY_LOG.get())
                .unlockedBy(getHasName(ModBlocks.MAHOGANY_LOG.get()), has(ModBlocks.MAHOGANY_LOG.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_MAHOGANY_WOOD.get())
                .pattern("   ")
                .pattern(" ##")
                .pattern(" ##")
                .define('#', ModBlocks.STRIPPED_MAHOGANY_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_MAHOGANY_WOOD.get()), has(ModBlocks.STRIPPED_MAHOGANY_LOG.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.SILVER_BUTTON.get())
                .requires(ModBlocks.SILVER_BLOCK.get())
                .requires(Items.REDSTONE)
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_NUGGET.get(), 9)
                .requires(ModItems.SILVER_INGOT.get())
                .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CARBON_DUST.get(), 9)
                .requires(ModBlocks.CARBON_DUST_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CARBON_DUST_BLOCK.get()), has(ModBlocks.CARBON_DUST_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_SILVER.get(), 9)
                .requires(ModBlocks.RAW_SILVER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_SILVER_BLOCK.get()), has(ModBlocks.RAW_SILVER_BLOCK.get()))
                .save(pWriter);
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, SilverInnovation.MOD_ID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}

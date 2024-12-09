package net.ohfired.silver_innovation.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.block.ModBlocks;
import net.ohfired.silver_innovation.recipe.SilverFoundryRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SilverFoundryCategory implements IRecipeCategory<SilverFoundryRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(SilverInnovation.MOD_ID, "silver_foundry");
    public static final ResourceLocation TEXTURE = new ResourceLocation(SilverInnovation.MOD_ID,
            "textures/gui/container/silver_foundry_gui.png");

    public static final RecipeType<SilverFoundryRecipe> SILVER_FOUNDRY_TYPE =
            new RecipeType<>(UID, SilverFoundryRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SilverFoundryCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,176,80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SILVER_FOUNDRY.get()));
    }


    @Override
    public RecipeType<SilverFoundryRecipe> getRecipeType() {
        return SILVER_FOUNDRY_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.silver_innovation.silver_foundry");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SilverFoundryRecipe recipe, IFocusGroup focus) {
        builder.addSlot(RecipeIngredientRole.INPUT, 58, 14).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 100, 14).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 79, 56).addItemStack(recipe.getResultItem(null));


    }
}

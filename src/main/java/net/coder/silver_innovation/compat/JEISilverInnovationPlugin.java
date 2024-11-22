package net.coder.silver_innovation.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.recipe.SilverFoundryRecipe;
import net.coder.silver_innovation.screen.SilverFoundryScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEISilverInnovationPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(SilverInnovation.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SilverFoundryCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<SilverFoundryRecipe> foundryRecipes = recipeManager.getAllRecipesFor(SilverFoundryRecipe.Type.INSTANCE);
        registration.addRecipes(SilverFoundryCategory.SILVER_FOUNDRY_TYPE, foundryRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(SilverFoundryScreen.class, 74,24,26,27,
                SilverFoundryCategory.SILVER_FOUNDRY_TYPE);
    }
}

package net.ohfired.silver_innovation.recipe;

import net.ohfired.silver_innovation.SilverInnovation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SilverInnovation.MOD_ID);

    public static final RegistryObject<RecipeSerializer<SilverFoundryRecipe>> SILVER_FOUNDRY_SERIALIZER =
            SERIALIZERS.register("silver_foundry", () -> SilverFoundryRecipe.Serializer.INSTRANCE);

    public static void register(IEventBus eventBus) {
            SERIALIZERS.register(eventBus);
    }

}

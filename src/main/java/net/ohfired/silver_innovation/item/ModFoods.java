package net.ohfired.silver_innovation.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
   public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
           .saturationMod(0.2f)
           .nutrition(1)
           .fast()
           .build();

   public static final FoodProperties SILVER_STRAWBERRY = new FoodProperties.Builder()
           .saturationMod(0.7f)
           .nutrition(2)
           .fast()
           .build();
}

package net.coder.silver_innovation.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
   public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
           .saturationMod(0.2f)
           .nutrition(2)
           .fast()
           .build();

   public static final FoodProperties SILVER_STRAWBERRY = new FoodProperties.Builder()
           .saturationMod(1.0f)
           .nutrition(4)
           .fast()
           .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500), 0.3f)
           .build();
}

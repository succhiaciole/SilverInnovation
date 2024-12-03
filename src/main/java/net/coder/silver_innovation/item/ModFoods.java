package net.coder.silver_innovation.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
   public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
           .saturationMod(0.2f)
           .nutrition(1)
           .fast()
           .build();

   public static final FoodProperties SILVER_STRAWBERRY = new FoodProperties.Builder()
           .saturationMod(0.5f)
           .nutrition(2)
           .fast()
           .build();
   public static final FoodProperties ENCHANTED_SILVER_STRAWBERRY = new FoodProperties.Builder()
           .nutrition(3).saturationMod(1.0F)
           .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 1), 1.0F)
           .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3000, 0), 1.0F)
           .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3000, 0), 1.0F)
           .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 1), 1.0F)
           .alwaysEat()
           .build();
}

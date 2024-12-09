package net.ohfired.silver_innovation.datagen;

import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.item.ModItems;
import net.ohfired.silver_innovation.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, SilverInnovation.MOD_ID);
    }

    @Override
    protected void start() {
        add("strawberry_seed_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, ModItems.STRAWBERRY_SEEDS.get()));

        add("silver_nugget_from_silver_golem", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/silver_golem")).build() }, ModItems.SILVER_NUGGET.get()));

        add("silver_ingot_from_buried_treasure", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/buried_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(15f).build(),}, ModItems.SILVER_INGOT.get()));


    }
}

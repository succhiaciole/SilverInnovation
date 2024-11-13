package net.coder.silver_innovation.datagen.loot;

import net.coder.silver_innovation.block.ModBlocks;
import net.coder.silver_innovation.block.custom.StrawberryCropBlock;
import net.coder.silver_innovation.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.CARBON_DUST_BLOCK.get());
        this.dropSelf(ModBlocks.SILVERER_TABLE.get());

        this.add(ModBlocks.SILVER_ORE.get(),
                block -> createIronLikeOreDrops(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createIronLikeOreDrops(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.CARBON_ORE.get(),
                block -> createRedstoneLikeOreDrops(ModBlocks.CARBON_ORE.get(), ModItems.CARBON_DUST.get()));
        this.add(ModBlocks.DEEPSLATE_CARBON_ORE.get(),
                block -> createRedstoneLikeOreDrops(ModBlocks.CARBON_ORE.get(), ModItems.CARBON_DUST.get()));

        this.dropSelf(ModBlocks.SILVER_STAIRS.get());
        this.dropSelf(ModBlocks.SILVER_BUTTON.get());
        this.dropSelf(ModBlocks.SILVER_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SILVER_TRAPDOOR.get());
        this.dropSelf(ModBlocks.SILVER_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SILVER_FENCE.get());
        this.dropSelf(ModBlocks.SILVER_WALL.get());

        this.add(ModBlocks.SILVER_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SILVER_SLAB.get()));
        this.add(ModBlocks.SILVER_DOOR.get(),
                block -> createDoorTable(ModBlocks.SILVER_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));

        this.add(ModBlocks.STRAWBERRY_CROP.get(), createCropDrops(ModBlocks.STRAWBERRY_CROP.get(), ModItems.STRAWBERRY.get(),
                ModItems.STRAWBERRY_SEEDS.get(), lootitemcondition$builder));

    }

    protected LootTable.Builder createIronLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay
                (pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createRedstoneLikeOreDrops(Block pBlock, Item item) {
            return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay
                    (pBlock, LootItem.lootTableItem(item)
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                            .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

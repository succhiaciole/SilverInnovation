package net.coder.silver_innovation.datagen.loot;

import net.coder.silver_innovation.block.ModBlocks;
import net.coder.silver_innovation.block.custom.StrawberryBushBlock;
import net.coder.silver_innovation.block.custom.StrawberryCropBlock;
import net.coder.silver_innovation.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
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
        this.dropSelf(ModBlocks.SILVER_FOUNDRY.get());

        this.dropSelf(ModBlocks.MAHOGANY_LOG.get());
        this.dropSelf(ModBlocks.MAHOGANY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MAHOGANY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_MAHOGANY_WOOD.get());
        this.dropSelf(ModBlocks.MAHOGANY_PLANKS.get());
        this.dropSelf(ModBlocks.MAHOGANY_SAPLING.get());

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

        LootItemCondition.Builder lootitemconditionBbuilder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.STRAWBERRY_BUSH.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryBushBlock.AGE, 4));

        this.add(ModBlocks.STRAWBERRY_BUSH.get(), createBushLikeDrops(ModBlocks.STRAWBERRY_BUSH.get(), ModItems.STRAWBERRY.get(), lootitemconditionBbuilder));

        this.add(ModBlocks.MAHOGANY_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.MAHOGANY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.MAHOGANY_SIGN.get(), block ->
                createSingleItemTable(ModItems.MAHOGANY_SIGN.get()));
        this.add(ModBlocks.MAHOGANY_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.MAHOGANY_SIGN.get()));
        this.add(ModBlocks.MAHOGANY_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.MAHOGANY_HANGING_SIGN.get()));
        this.add(ModBlocks.MAHOGANY_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.MAHOGANY_HANGING_SIGN.get()));
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

    protected LootTable.Builder createBushLikeDrops(Block pCropBlock, Item pGrownCropItem, LootItemCondition.Builder pDropGrownCropCondition) {
        return this.applyExplosionDecay
                (pCropBlock, LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition))));

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

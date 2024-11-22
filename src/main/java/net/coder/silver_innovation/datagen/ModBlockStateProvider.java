package net.coder.silver_innovation.datagen;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.block.ModBlocks;
import net.coder.silver_innovation.block.custom.StrawberryCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SilverInnovation.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
          blockWithItem(ModBlocks.RAW_SILVER_BLOCK);
          blockWithItem(ModBlocks.SILVER_BLOCK);

          blockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE);
          blockWithItem(ModBlocks.SILVER_ORE);

          blockWithItem(ModBlocks.CARBON_DUST_BLOCK);

          blockWithItem(ModBlocks.DEEPSLATE_CARBON_ORE);
          blockWithItem(ModBlocks.CARBON_ORE);
          
          stairsBlock(((StairBlock) ModBlocks.SILVER_STAIRS.get()), blockTexture(ModBlocks.SILVER_BLOCK.get()));
          slabBlock(((SlabBlock) ModBlocks.SILVER_SLAB.get()), blockTexture(ModBlocks.SILVER_BLOCK.get()), blockTexture(ModBlocks.SILVER_BLOCK.get()));

          buttonBlock(((ButtonBlock) ModBlocks.SILVER_BUTTON.get()), blockTexture(ModBlocks.SILVER_BLOCK.get()));
          pressurePlateBlock(((PressurePlateBlock) ModBlocks.SILVER_PRESSURE_PLATE.get()), blockTexture(ModBlocks.SILVER_BLOCK.get()));

          fenceBlock(((FenceBlock) ModBlocks.SILVER_FENCE.get()), blockTexture(ModBlocks.SILVER_BLOCK.get()));
          fenceGateBlock(((FenceGateBlock) ModBlocks.SILVER_FENCE_GATE.get()), blockTexture(ModBlocks.SILVER_BLOCK.get()));
          wallBlock(((WallBlock) ModBlocks.SILVER_WALL.get()), blockTexture(ModBlocks.SILVER_BLOCK.get()));

          doorBlockWithRenderType(((DoorBlock) ModBlocks.SILVER_DOOR.get()), modLoc("block/silver_door_bottom"),modLoc("block/silver_door_top"),"cutout");
          trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.SILVER_TRAPDOOR.get()), modLoc("block/silver_trapdoor"),true,"cutout");

        makeStrawberryCrop((CropBlock) ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
    }


    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(SilverInnovation.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

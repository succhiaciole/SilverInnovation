package net.ohfired.silver_innovation.block;

import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.block.custom.*;
import net.ohfired.silver_innovation.item.ModItems;
import net.ohfired.silver_innovation.util.ModWoodTypes;
import net.ohfired.silver_innovation.worldgen.tree.MahoganyTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SilverInnovation.MOD_ID);

    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_CARBON_ORE = registerBlock("deepslate_carbon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE), UniformInt.of(2,5)));
    public static final RegistryObject<Block> CARBON_ORE = registerBlock("carbon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(2,5)));
    public static final RegistryObject<Block> CARBON_DUST_BLOCK = registerBlock("carbon_dust_block",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND)));
    public static final RegistryObject<Block> SILVER_FOUNDRY = registerBlock("silver_foundry",
            () -> new SilverFoundryBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> REINFORCED_SCAFFOLDING = BLOCKS.register("reinforced_scaffolding",
            () -> new ReinforcedScaffoldingBlock(BlockBehaviour.Properties.of()
                    .strength(3.0F, 6.0F)
                    .noCollission()
                    .sound(SoundType.LANTERN)
                    .isValidSpawn(ModBlocks::never)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> STRAWBERRY_CROP = registerBlock("strawberry_crop",
            () -> new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> STRAWBERRY_BUSH = registerBlock("strawberry_bush",
            () -> new StrawberryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion().noCollission()));

    public static final RegistryObject<Block> MAHOGANY_LOG = registerBlock("mahogany_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(1.5f)));
    public static final RegistryObject<Block> MAHOGANY_WOOD = registerBlock("mahogany_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(1.5f)));
    public static final RegistryObject<Block> STRIPPED_MAHOGANY_LOG = registerBlock("stripped_mahogany_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(1.5f)));
    public static final RegistryObject<Block> STRIPPED_MAHOGANY_WOOD = registerBlock("stripped_mahogany_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(1.5f)));

    public static final RegistryObject<Block> MAHOGANY_PLANKS = registerBlock("mahogany_planks",
            () -> new ModPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(1.5f)));
    public static final RegistryObject<Block> MAHOGANY_LEAVES = registerBlock("mahogany_leaves",
            () -> new ModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> MAHOGANY_SAPLING = registerBlock("mahogany_sapling",
            () -> new SaplingBlock(new MahoganyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).randomTicks().instabreak().noOcclusion().noCollission()));

    public static final RegistryObject<Block> MAHOGANY_SIGN = BLOCKS.register("mahogany_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.MAHOGANY));
    public static final RegistryObject<Block> MAHOGANY_WALL_SIGN = registerBlock("mahogany_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.MAHOGANY));
    public static final RegistryObject<Block> MAHOGANY_HANGING_SIGN = BLOCKS.register("mahogany_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.MAHOGANY));
    public static final RegistryObject<Block> MAHOGANY_WALL_HANGING_SIGN = registerBlock("mahogany_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.MAHOGANY));

    public static final RegistryObject<Block> SILVER_STAIRS = registerBlock("silver_stairs",
            () -> new StairBlock(() -> ModBlocks.SILVER_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> SILVER_SLAB = registerBlock("silver_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> SILVER_BUTTON = registerBlock("silver_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 45, false));
    public static final RegistryObject<Block> SILVER_PRESSURE_PLATE = registerBlock("silver_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS,
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), BlockSetType.IRON));

    public static final RegistryObject<Block> SILVER_FENCE = registerBlock("silver_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> SILVER_FENCE_GATE = registerBlock("silver_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> SILVER_WALL = registerBlock("silver_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> SILVER_DOOR = registerBlock("silver_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> SILVER_TRAPDOOR = registerBlock("silver_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .noOcclusion(), BlockSetType.IRON));

    private static <T extends Block> RegistryObject<T> registerBlock (String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return (boolean) false;
    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

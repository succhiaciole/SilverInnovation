package net.coder.silver_innovation.item;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SilverInnovation.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TESTS = CREATIVE_MODE_TABS.register("tests",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Blocks.BARRIER))
                    .title(Component.translatable("creativetab.tests"))
                    .displayItems((pParameters, pOutput) -> {
                    })
                    .build());


    public static final RegistryObject<CreativeModeTab> SILVER_INNOVATION = CREATIVE_MODE_TABS.register("silver_innovation",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SILVER_INGOT.get()))
                    .title(Component.translatable("creativetab.silver_innovation"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SILVER_INGOT.get());
                        pOutput.accept(ModItems.RAW_SILVER.get());
                        pOutput.accept(ModItems.SILVER_NUGGET.get());

                        pOutput.accept(ModItems.SILVER_HELMET.get());
                        pOutput.accept(ModItems.SILVER_CHESTPLATE.get());
                        pOutput.accept(ModItems.SILVER_LEGGINGS.get());
                        pOutput.accept(ModItems.SILVER_BOOTS.get());

                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());
                        pOutput.accept(ModItems.SILVER_STRAWBERRY.get());

                        pOutput.accept(ModItems.CARBON_DUST.get());
                        pOutput.accept(ModItems.ANTHRACITE.get());

                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.SILVER_MISSLE.get());

                        pOutput.accept(ModItems.SILVER_SWORD.get());
                        pOutput.accept(ModItems.SILVER_PICKAXE.get());
                        pOutput.accept(ModItems.SILVER_AXE.get());
                        pOutput.accept(ModItems.SILVER_SHOVEL.get());
                        pOutput.accept(ModItems.SILVER_HOE.get());
                        pOutput.accept(ModItems.SILVER_BOW.get());
                        pOutput.accept(ModItems.SILVER_LONGBOW.get());

                        pOutput.accept(ModItems.SILVER_GOLEM_SPAWN_EGG.get());

                        pOutput.accept(ModBlocks.SILVER_BLOCK.get());
                        pOutput.accept(ModBlocks.SILVER_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SILVER_ORE.get());
                        pOutput.accept(ModBlocks.RAW_SILVER_BLOCK.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_CARBON_ORE.get());
                        pOutput.accept(ModBlocks.CARBON_ORE.get());
                        pOutput.accept(ModBlocks.CARBON_DUST_BLOCK.get());
                        pOutput.accept(ModBlocks.SILVERER_TABLE.get());

                        pOutput.accept(ModBlocks.SILVER_DOOR.get());
                        pOutput.accept(ModBlocks.SILVER_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.SILVER_FENCE.get());
                        pOutput.accept(ModBlocks.SILVER_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.SILVER_BUTTON.get());
                        pOutput.accept(ModBlocks.SILVER_WALL.get());
                        pOutput.accept(ModBlocks.SILVER_STAIRS.get());
                        pOutput.accept(ModBlocks.SILVER_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.SILVER_SLAB.get());
                    })
                    .build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

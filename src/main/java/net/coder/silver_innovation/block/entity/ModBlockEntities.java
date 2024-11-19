package net.coder.silver_innovation.block.entity;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SilverInnovation.MOD_ID);

    public static final RegistryObject<BlockEntityType<SilverFoundryBlockEntity>> SILVER_FOUNDRY_BE =
            BLOCK_ENTITIES.register("silver_foundry_be",
                    () -> BlockEntityType.Builder.of(SilverFoundryBlockEntity::new,
                    ModBlocks.SILVER_FOUNDRY.get()).build(null));

    public static void register(IEventBus eventBus) {
      BLOCK_ENTITIES.register(eventBus);
    }
}

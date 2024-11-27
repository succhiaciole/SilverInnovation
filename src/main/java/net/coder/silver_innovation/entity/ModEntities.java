package net.coder.silver_innovation.entity;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.entity.projectile.SilverMissleEntity;
import net.coder.silver_innovation.entity.custom.SilverGolemEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SilverInnovation.MOD_ID);

    public static final RegistryObject<EntityType<SilverGolemEntity>> SILVER_GOLEM =
            ENTITY_TYPES.register("silver_golem", () -> EntityType.Builder.of(SilverGolemEntity::new, MobCategory.CREATURE)
                    .sized(1.1f, 2.9f).build("silver_golem"));
    public static final RegistryObject<EntityType<SilverMissleEntity>> SILVER_MISSLE =
            ENTITY_TYPES.register("silver_missle", () -> EntityType.Builder.<SilverMissleEntity>of(SilverMissleEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(new ResourceLocation(SilverInnovation.MOD_ID, "silver_missle").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

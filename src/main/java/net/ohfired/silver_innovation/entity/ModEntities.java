package net.ohfired.silver_innovation.entity;

import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.entity.projectile.SilverMissleEntity;
import net.ohfired.silver_innovation.entity.custom.SilverGolemEntity;
import net.ohfired.silver_innovation.entity.projectile.bombs.FlyingTntEntity;
import net.ohfired.silver_innovation.entity.projectile.bombs.FlamedSurpriseEntity;
import net.ohfired.silver_innovation.entity.projectile.bombs.SilverSurpriseEntity;
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

    public static final RegistryObject<EntityType<SilverSurpriseEntity>> SILVER_SURPRISE =
            ENTITY_TYPES.register("silver_surprise", () -> EntityType.Builder.<SilverSurpriseEntity>of(SilverSurpriseEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(new ResourceLocation(SilverInnovation.MOD_ID, "silver_surprise").toString()));
    public static final RegistryObject<EntityType<FlamedSurpriseEntity>> FLAMED_SURPRISE =
            ENTITY_TYPES.register("flamed_surprise", () -> EntityType.Builder.<FlamedSurpriseEntity>of(FlamedSurpriseEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(new ResourceLocation(SilverInnovation.MOD_ID, "flamed_surprise").toString()));
    public static final RegistryObject<EntityType<FlyingTntEntity>> FLYING_TNT =
            ENTITY_TYPES.register("flying_tnt", () -> EntityType.Builder.<FlyingTntEntity>of(FlyingTntEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(new ResourceLocation(SilverInnovation.MOD_ID, "flying_tnt").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

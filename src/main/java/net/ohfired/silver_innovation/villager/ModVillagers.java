package net.ohfired.silver_innovation.villager;

import com.google.common.collect.ImmutableSet;
import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, SilverInnovation.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, SilverInnovation.MOD_ID);

    public static final RegistryObject<PoiType> SILVER_POI = POI_TYPES.register("silver_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.SILVER_FOUNDRY.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> SILVER_SMITHER =
            VILLAGER_PROFESSIONS.register("silver_smither", () -> new VillagerProfession("silver_smither",
                    holder -> holder.get() == SILVER_POI.get(), holder -> holder.get() == SILVER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
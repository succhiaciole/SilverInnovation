package net.ohfired.silver_innovation.worldgen.tree;

import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.worldgen.tree.custom.MahoganyTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, SilverInnovation.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<MahoganyTrunkPlacer>> MAHOGANY_TRUNK_PLACER =
            TRUNK_PLACER.register("mahogany_trunk_placer", () -> new TrunkPlacerType<>(MahoganyTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}

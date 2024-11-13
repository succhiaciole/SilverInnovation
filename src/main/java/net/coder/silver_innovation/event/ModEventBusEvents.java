package net.coder.silver_innovation.event;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.entity.ModEntities;
import net.coder.silver_innovation.entity.custom.SilverGolemEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SilverInnovation.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SILVER_GOLEM.get(), SilverGolemEntity.createAttributes().build());
    }
}
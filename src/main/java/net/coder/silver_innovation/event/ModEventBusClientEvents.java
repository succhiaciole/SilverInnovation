package net.coder.silver_innovation.event;

import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.entity.ModEntities;
import net.coder.silver_innovation.entity.client.ModModelLayers;
import net.coder.silver_innovation.entity.client.renderer.SilverMissleRenderer;
import net.coder.silver_innovation.entity.client.SilverGolemModel;
import net.coder.silver_innovation.entity.client.renderer.ThrownPikeSpearRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SilverInnovation.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SILVER_GOLEM_LAYER, SilverGolemModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.SILVER_MISSLE.get(), SilverMissleRenderer::new);
        event.registerEntityRenderer(ModEntities.PIKE_SPEAR.get(), ThrownPikeSpearRenderer::new);
    }
}

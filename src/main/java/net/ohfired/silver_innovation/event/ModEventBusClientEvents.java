package net.ohfired.silver_innovation.event;

import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.block.entity.ModBlockEntities;
import net.ohfired.silver_innovation.entity.ModEntities;
import net.ohfired.silver_innovation.entity.client.ModModelLayers;
import net.ohfired.silver_innovation.entity.client.renderer.SilverMissileRenderer;
import net.ohfired.silver_innovation.entity.client.SilverGolemModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.SILVER_MISSILE.get(), SilverMissileRenderer::new);

        event.registerEntityRenderer(ModEntities.SILVER_SURPRISE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntities.FLAMED_SURPRISE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntities.FLYING_TNT.get(), ThrownItemRenderer::new);
    }
}

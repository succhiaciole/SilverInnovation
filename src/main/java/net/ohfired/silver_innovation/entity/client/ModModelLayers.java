package net.ohfired.silver_innovation.entity.client;

import com.google.common.collect.Sets;
import net.ohfired.silver_innovation.SilverInnovation;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import java.util.Set;

public class ModModelLayers {
   private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();

   public static final ModelLayerLocation SILVER_GOLEM_LAYER = new ModelLayerLocation(
           new ResourceLocation(SilverInnovation.MOD_ID, "silver_golem_layer"),"main");
}

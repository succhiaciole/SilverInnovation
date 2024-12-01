package net.coder.silver_innovation;

import com.mojang.logging.LogUtils;
import net.coder.silver_innovation.block.ModBlocks;
import net.coder.silver_innovation.block.entity.ModBlockEntities;
import net.coder.silver_innovation.effect.ModEffects;
import net.coder.silver_innovation.enchantment.ModEnchantments;
import net.coder.silver_innovation.entity.ModEntities;
import net.coder.silver_innovation.entity.client.renderer.SilverGolemRenderer;
import net.coder.silver_innovation.item.ModCreativeModeTabs;
import net.coder.silver_innovation.item.ModItems;
import net.coder.silver_innovation.loot.ModLootModifiers;
import net.coder.silver_innovation.potion.ModPotions;
import net.coder.silver_innovation.recipe.ModRecipes;
import net.coder.silver_innovation.screen.ModMenuTypes;
import net.coder.silver_innovation.screen.SilverFoundryScreen;
import net.coder.silver_innovation.sound.ModSounds;
import net.coder.silver_innovation.util.ModItemProperties;
import net.coder.silver_innovation.util.ModWoodTypes;
import net.coder.silver_innovation.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SilverInnovation.MOD_ID)
public class SilverInnovation {
    public static final String MOD_ID = "silver_innovation";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SilverInnovation() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEnchantments.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.MAHOGANY);

            EntityRenderers.register(ModEntities.SILVER_GOLEM.get(), SilverGolemRenderer::new);
            ModItemProperties.addCustomItemProperties();

            MenuScreens.register(ModMenuTypes.SILVER_FOUNDRY_MENU.get(), SilverFoundryScreen::new);
        }
    }
}
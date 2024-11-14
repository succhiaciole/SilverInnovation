package net.coder.silver_innovation.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.item.ModItems;
import net.coder.silver_innovation.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = SilverInnovation.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.STRAWBERRY.get(), 6),
                    10, 1, 0.02f));

        }
            if (event.getType() == ModVillagers.SILVER_SMITHER.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 2),
                        new ItemStack(ModItems.SILVER_INGOT.get(), 1),
                        16, 1, 0.1f));

                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3),
                        new ItemStack(ModItems.CARBON_DUST.get(), 6),
                        10, 1, 0.1f));

                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(ModItems.SILVER_SHOVEL.get(), 1),
                        8, 1, 0.35f));

                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 8),
                        new ItemStack(ModItems.SILVER_STRAWBERRY.get(), 4),
                        10, 1, 0.35f));

                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 2),
                        new ItemStack(ModItems.SILVER_HOE.get(), 1),
                        10, 1, 0.35f));

                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 10),
                        new ItemStack(ModItems.SILVER_LEGGINGS.get(), 1),
                        10, 1, 0.5f));

                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 8),
                        new ItemStack(ModItems.ANTHRACITE.get(), 3),
                        10, 1, 0.5f));

                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(ModItems.SILVER_HELMET.get(), 1),
                        10, 1, 0.75f));

                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 4),
                        new ItemStack(ModItems.SILVER_BOOTS.get(), 1),
                        10, 1, 0.75f));

                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
                        5, 1, 0.75f));

                trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 12),
                        new ItemStack(ModItems.SILVER_CHESTPLATE.get(), 1),
                        10, 1, 1f));

                trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 16),
                        new ItemStack(ModItems.STRAWBERRY_SEEDS.get(), 16),
                        10, 1, 1f));

            }
    }
}



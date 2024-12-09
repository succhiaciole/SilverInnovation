package net.coder.silver_innovation.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.coder.silver_innovation.SilverInnovation;
import net.coder.silver_innovation.enchantment.ModEnchantments;
import net.coder.silver_innovation.item.ModItems;
import net.coder.silver_innovation.item.custom.HammerItem;
import net.coder.silver_innovation.villager.ModVillagers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = SilverInnovation.MOD_ID)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        int range = 1;
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }
            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(range, initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

        @SubscribeEvent
        public static void addCustomTrades (VillagerTradesEvent event){
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
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(ModItems.SILVER_LIMB.get(), 4),
                        8, 1, 0.5f));

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

                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(ModItems.SILVER_BOW.get(), 1),
                        5, 1, 0.45f));

                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(ModItems.SILVER_HELMET.get(), 1),
                        10, 1, 0.75f));

                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 4),
                        new ItemStack(ModItems.SILVER_BOOTS.get(), 1),
                        10, 1, 0.75f));

                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 7),
                        new ItemStack(ModItems.SILVER_MISSLE.get(), 4),
                        8, 1, 0.75f));

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

                trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 8),
                        new ItemStack(ModItems.SILVER_LONGBOW.get(), 1),
                        5, 1, 1f));

                trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(ModItems.SILVER_SHORTBOW.get(), 1),
                        5, 1, 1f));

                trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 25),
                        new ItemStack(ModItems.SILVER_GOLEM_SPAWN_EGG.get(), 2),
                        3, 1, 5f));

                trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 17),
                        new ItemStack(ModItems.SILVER_HAMMER.get(), 1),
                        3, 1, 5f));
            }
        }
    }




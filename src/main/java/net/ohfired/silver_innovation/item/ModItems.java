package net.ohfired.silver_innovation.item;

import net.ohfired.silver_innovation.SilverInnovation;
import net.ohfired.silver_innovation.block.ModBlocks;
import net.ohfired.silver_innovation.entity.ModEntities;
import net.ohfired.silver_innovation.item.custom.*;
import net.ohfired.silver_innovation.item.custom.ScissorsItem;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SilverInnovation.MOD_ID);


    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_LIMB = ITEMS.register("silver_limb",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCISSORS = ITEMS.register("scissors",
            () -> new ScissorsItem(new Item.Properties().durability(238)));

    public static final RegistryObject<Item> SILVER_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("silver_upgrade_smithing_template",
            () -> new SilverUpgradeSmithingTemplateItem(new Item.Properties()));

    public static final RegistryObject<Item> CARBON_DUST = ITEMS.register("carbon_dust",
            () -> new FuelItem(new Item.Properties(), 200));
    public static final RegistryObject<Item> ANTHRACITE = ITEMS.register("anthracite",
            () -> new FuelItem(new Item.Properties(), 3500));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_BUSH.get(), new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> SILVER_STRAWBERRY = ITEMS.register("silver_strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.SILVER_STRAWBERRY)));
    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(151)));
    public static final RegistryObject<Item> SILVER_BOW = ITEMS.register("silver_bow",
            () -> new SilverBowItem(new Item.Properties().durability(376).fireResistant()));
    public static final RegistryObject<Item> SILVER_LONGBOW = ITEMS.register("silver_longbow",
            () -> new SilverLongbowItem(new Item.Properties().durability(586).fireResistant()));
    public static final RegistryObject<Item> SILVER_SHORTBOW = ITEMS.register("silver_shortbow",
            () -> new SilverShortbowItem(new Item.Properties().durability(298).fireResistant()));
    public static final RegistryObject<Item> SILVER_MISSLE = ITEMS.register("silver_missle",
            () -> new SilverMissleItem(1.7f, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_SURPRISE = ITEMS.register("silver_surprise",
            () -> new SilverSurpriseItem(new Item.Properties()));
    public static final RegistryObject<Item> FLAMED_SURPRISE = ITEMS.register("flamed_surprise",
            () -> new FlamedSurpriseItem(new Item.Properties()));
    public static final RegistryObject<Item> FLYING_TNT = ITEMS.register("flying_tnt",
            () -> new FlyingTntItem(new Item.Properties()));

    public static final RegistryObject<Item> SILVER_GOLEM_SPAWN_EGG = ITEMS.register("silver_golem_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SILVER_GOLEM, 7956848, 15265265, new Item.Properties()));
    
    public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword",
            () -> new SwordItem(ModToolTiers.SILVER,4, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SILVER, 1,-2.6f, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel",
            () -> new ShovelItem(ModToolTiers.SILVER,1f,-3f, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe",
            () -> new AxeItem(ModToolTiers.SILVER,6,-3.5f, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe",
            () -> new HoeItem(ModToolTiers.SILVER,0,-1.4f, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_HAMMER = ITEMS.register("silver_hammer",
            () -> new HammerItem(ModToolTiers.SILVER, 3,-2.9f, new Item.Properties().durability(879)));

    public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register("silver_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_LEGGINGS = ITEMS.register("silver_leggings",
            () -> new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_BOOTS = ITEMS.register("silver_boots",
            () -> new ArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> MAHOGANY_SIGN = ITEMS.register("mahogany_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.MAHOGANY_SIGN.get(), ModBlocks.MAHOGANY_WALL_SIGN.get()));
    public static final RegistryObject<Item> MAHOGANY_HANGING_SIGN = ITEMS.register("mahogany_hanging_sign",
            () -> new HangingSignItem(ModBlocks.MAHOGANY_HANGING_SIGN.get(), ModBlocks.MAHOGANY_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> REINFORCED_SCAFFOLDING = ITEMS.register("reinforced_scaffolding",
            () -> new ReinforcedScaffoldingItem(ModBlocks.REINFORCED_SCAFFOLDING.get(), new Item.Properties().fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

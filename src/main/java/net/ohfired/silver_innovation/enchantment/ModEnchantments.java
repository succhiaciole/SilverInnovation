package net.ohfired.silver_innovation.enchantment;

import net.ohfired.silver_innovation.SilverInnovation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, SilverInnovation.MOD_ID);

    public static final RegistryObject<Enchantment> FACTOR = ENCHANTMENTS.register("factor",
            () -> new FactorEnchantment(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> THICKNESS = ENCHANTMENTS.register("thickness",
            () -> new ThicknessEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}

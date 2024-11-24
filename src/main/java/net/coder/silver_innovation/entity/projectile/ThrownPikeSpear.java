package net.coder.silver_innovation.entity.projectile;

import net.coder.silver_innovation.entity.ModEntities;
import net.coder.silver_innovation.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ThrownPikeSpear extends AbstractArrow {
    public final Item referenceItem;

    public ThrownPikeSpear(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.PIKE_SPEAR.get();
    }

    public ThrownPikeSpear(Player player, Level level, Item referenceItem) {
        super(ModEntities.PIKE_SPEAR.get(), player, level);
        this.referenceItem = ModItems.PIKE_SPEAR.get();
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }
}

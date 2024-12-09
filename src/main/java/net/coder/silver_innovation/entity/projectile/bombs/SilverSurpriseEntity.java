package net.coder.silver_innovation.entity.projectile.bombs;

import net.coder.silver_innovation.entity.ModEntities;
import net.coder.silver_innovation.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class SilverSurpriseEntity extends ThrowableItemProjectile {
    public SilverSurpriseEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SilverSurpriseEntity(Level pLevel) {
        super(ModEntities.SILVER_SURPRISE.get(), pLevel);
    }

    public SilverSurpriseEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.SILVER_SURPRISE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SILVER_SURPRISE.get();
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.isInWater() && this.level().isClientSide) {
            for (int i = 0; i < 10; ++i) {
                this.level().addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
                this.level().addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
                this.level().addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if(!this.level().isClientSide){
            this.level().broadcastEntityEvent(this, ((byte) 3));
            this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
        }

        this.discard();
    }
}

package net.ohfired.silver_innovation.entity.projectile.bombs;

import net.ohfired.silver_innovation.entity.ModEntities;
import net.ohfired.silver_innovation.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class FlamedSurpriseEntity extends ThrowableItemProjectile {
    public FlamedSurpriseEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public FlamedSurpriseEntity(Level pLevel) {
        super(ModEntities.FLAMED_SURPRISE.get(), pLevel);
    }

    public FlamedSurpriseEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.FLAMED_SURPRISE.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.FLAMED_SURPRISE.get();
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.isInWater() && this.level().isClientSide) {
            for(int i = 0; i < 10; ++i) {
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
            this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 4.0F, true, Level.ExplosionInteraction.TNT);}

        this.discard();
    }
}

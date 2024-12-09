package net.coder.silver_innovation.entity.projectile.bombs;

import net.coder.silver_innovation.entity.ModEntities;
import net.coder.silver_innovation.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class FlyingTntEntity extends ThrowableItemProjectile {
    public FlyingTntEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public FlyingTntEntity(Level pLevel) {
        super(ModEntities.FLYING_TNT.get(), pLevel);
    }

    public FlyingTntEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.FLYING_TNT.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.FLYING_TNT.get();
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
            this.explode();
        }

        this.discard();
    }

    private void explode() {
            this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 2.5F, Level.ExplosionInteraction.TNT);
    }
}

package net.coder.silver_innovation.entity.projectile;

import net.coder.silver_innovation.entity.ModEntities;
import net.coder.silver_innovation.event.ModEvents;
import net.coder.silver_innovation.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.Nullable;

public class ThrownSilverPorter extends ThrowableItemProjectile {
    public ThrownSilverPorter(EntityType<? extends ThrownSilverPorter> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownSilverPorter(Level pLevel, LivingEntity pShooter) {
        super(ModEntities.SILVER_PORTER.get(), pShooter, pLevel);
    }

    protected Item getDefaultItem() {
        return ModItems.SILVER_PORTER.get();
    }

    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        pResult.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 3.0F);
    }

    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        for(int i = 0; i < 32; ++i) {
            this.level().addParticle(ParticleTypes.PORTAL, this.getX(), this.getY() + this.random.nextDouble() * 2.0D, this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
        }

        if (!this.level().isClientSide && !this.isRemoved()) {
            Entity entity = this.getOwner();
            if (entity instanceof ServerPlayer) {
                ServerPlayer serverplayer = (ServerPlayer)entity;
                if (serverplayer.connection.isAcceptingMessages() && serverplayer.level() == this.level() && !serverplayer.isSleeping()) {
                    ModEvents.SilverPorter event = ThrownSilverPorter.onSilverPorterLand(serverplayer, this.getX(), this.getY(), this.getZ(), this, 5.0F, pResult);
                    if (!event.isCanceled()) { // Don't indent to lower patch size
                        if (this.random.nextFloat() < 0.05F && this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
                            Endermite endermite = EntityType.ENDERMITE.create(this.level());
                            if (endermite != null) {
                                endermite.moveTo(entity.getX(), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                                this.level().addFreshEntity(endermite);
                            }
                        }

                        if (entity.isPassenger()) {
                            serverplayer.dismountTo(this.getX(), this.getY(), this.getZ());
                        } else {
                            entity.teleportTo(this.getX(), this.getY(), this.getZ());
                        }

                        entity.teleportTo(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        entity.resetFallDistance();
                        entity.hurt(this.damageSources().fall(), event.getAttackDamage());
                    } //Forge: End
                }
            } else if (entity != null) {
                entity.teleportTo(this.getX(), this.getY(), this.getZ());
                entity.resetFallDistance();
            }

            this.discard();
        }

    }

    public void tick() {
        Entity entity = this.getOwner();
        if (entity instanceof Player && !entity.isAlive()) {
            this.discard();
        } else {
            super.tick();
        }

    }

    @Nullable
    public Entity changeDimension(ServerLevel pServer, net.minecraftforge.common.util.ITeleporter teleporter) {
        Entity entity = this.getOwner();
        if (entity != null && entity.level().dimension() != pServer.dimension()) {
            this.setOwner((Entity)null);
        }

        return super.changeDimension(pServer, teleporter);
    }

    @ApiStatus.Internal
    public static ModEvents.SilverPorter onSilverPorterLand(ServerPlayer entity, double targetX, double targetY, double targetZ, ThrownSilverPorter thrownPorterEntity, float attackDamage, HitResult hitResult)
    {
        ModEvents.SilverPorter event = new ModEvents.SilverPorter(entity, targetX, targetY, targetZ, thrownPorterEntity, attackDamage, hitResult);
        MinecraftForge.EVENT_BUS.post(event);
        return event;
    }
}


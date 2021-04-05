package net.praaly.habitats.setup.entities.guard_traders;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.monster.ZombieEntity;

import javax.annotation.Nullable;
import java.util.EnumSet;

@SuppressWarnings("unused")
public class AbstractGuard extends VillagerEntity {
    @Nullable
    private BlockPos wanderTarget;
    private BlockPos homePos;

    public AbstractGuard(EntityType<? extends AbstractGuard> type, World worldIn) {
        super(type, worldIn);
        this.forcedLoading = true;
        //this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(Items.IRON_SWORD));
    }

    public void setHome(BlockPos pos){
        this.homePos = pos;
    }

    public boolean hasXPBar() {
        return false;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.3D));
        this.applyEntityAI();
    }
    protected void applyEntityAI() {
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, PlayerEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public void writeAdditional(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        if (this.wanderTarget != null) {
            compound.put("WanderTarget", NBTUtil.writeBlockPos(this.wanderTarget));
        }
    }

    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.PILLAGER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PILLAGER_DEATH;
    }

    public void setWanderTarget(@Nullable BlockPos pos) {
        this.wanderTarget = pos;
    }

    @Nullable
    private BlockPos getWanderTarget() {
        if (this.homePos != null && this.level.isNight()) return this.homePos;

        return this.wanderTarget;
    }

    class MoveToGoal extends Goal {
        final AbstractGuard traderEntity;
        final double maxDistance;
        final double speed;

        MoveToGoal(AbstractGuard traderEntityIn, double distanceIn, double speedIn) {
            this.traderEntity = traderEntityIn;
            this.maxDistance = distanceIn;
            this.speed = speedIn;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }


        @Override
        public boolean canUse() {
            return false;
        }

        public void tick() {
            BlockPos blockpos = this.traderEntity.getWanderTarget();
            if (blockpos != null && AbstractGuard.this.navigation.isDone()) {
                if (this.isWithinDistance(blockpos, 10.0D)) {
                    Vector3d vec3d = (new Vector3d((double) blockpos.getX() - this.traderEntity.getX(), (double) blockpos.getY() - this.traderEntity.getY(), (double) blockpos.getZ() - this.traderEntity.getZ())).normalize();
                    Vector3d vec3d1 = vec3d.scale(10.0D).add(this.traderEntity.getX(), this.traderEntity.getY(), this.traderEntity.getZ());
                    AbstractGuard.this.navigation.moveTo(vec3d1.x, vec3d1.y, vec3d1.z, this.speed);
                } else {
                    AbstractGuard.this.navigation.moveTo((double) blockpos.getX(), (double) blockpos.getY(), (double) blockpos.getZ(), this.speed);
                }
            }

        }

        private boolean isWithinDistance(BlockPos pos, double distance) {
            return !pos.closerThan(this.traderEntity.position(), distance);
        }
    }

    public static AttributeModifierMap.MutableAttribute Attributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 60.0D)
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            return super.hurt(source, amount);
        }
    }

    public boolean doHurtTarget(Entity entityIn) {
        boolean flag = entityIn.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.doEnchantDamageEffects(this, entityIn);
        }

        return flag;
    }

}
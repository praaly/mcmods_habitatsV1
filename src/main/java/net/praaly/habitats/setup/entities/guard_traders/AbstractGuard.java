package net.praaly.habitats.setup.entities.guard_traders;


import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.monster.ZombieEntity;


import javax.annotation.Nullable;
import java.util.EnumSet;

@SuppressWarnings("unused")
public class AbstractGuard extends MonsterEntity {

    ItemStack weapon = new ItemStack(Items.IRON_SWORD, 1);

    @Nullable
    private BlockPos homePos;

    public AbstractGuard(EntityType<? extends AbstractGuard> type, World worldIn) {
        super(type, worldIn);
        this.forcedLoading = true;
        //this.setItemSlot(EquipmentSlotType.MAINHAND,  new ItemStack(Items.SHIELD));
    }

    //public void setHome(BlockPos pos){
    //    this.homePos = pos;
    //}

    public boolean hasXPBar() {
        return false;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.applyEntityAI();
    }
    protected void applyEntityAI() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(GuardTradersEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, false));

    }

    public static AttributeModifierMap.MutableAttribute Attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.23F).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
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

    protected int getExperienceReward(PlayerEntity p_70693_1_) {
        if (this.isBaby()) {
            this.xpReward = (int) ((float) this.xpReward * 200.5F);
        }

        return super.getExperienceReward(p_70693_1_);
    }

    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
        if (!super.hurt(p_70097_1_, p_70097_2_)) {
            return false;
        } else if (!(this.level instanceof ServerWorld)) {
            return false;
        } else {
            ServerWorld serverworld = (ServerWorld)this.level;
            LivingEntity livingentity = this.getTarget();
            if (livingentity == null && p_70097_1_.getEntity() instanceof LivingEntity) {
                livingentity = (LivingEntity)p_70097_1_.getEntity();
            }

            int i = MathHelper.floor(this.getX());
            int j = MathHelper.floor(this.getY());
            int k = MathHelper.floor(this.getZ());

            return true;
        }
    }

    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag) {
            float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            if (this.getMainHandItem().isEmpty() && this.isOnFire() && this.random.nextFloat() < f * 0.3F) {
                p_70652_1_.setSecondsOnFire(2 * (int)f);
            }
        }

        return flag;
    }

}
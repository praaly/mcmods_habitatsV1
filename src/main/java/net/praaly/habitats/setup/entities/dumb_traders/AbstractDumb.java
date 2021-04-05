package net.praaly.habitats.setup.entities.dumb_traders;

import java.util.EnumSet;

import javax.annotation.Nullable;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.EvokerEntity;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

@SuppressWarnings("unused")
public class AbstractDumb extends AbstractVillagerEntity {
    @Nullable
    private BlockPos wanderTarget;
    private BlockPos homePos;

    protected VillagerTrades.ITrade[] sells;
    protected VillagerTrades.ITrade[] buys;

    public AbstractDumb(EntityType<? extends AbstractDumb> type, World worldIn) {
        super(type, worldIn);
        this.forcedLoading = true;
        //this.setItemSlot(EquipmentSlotType.HEAD, new ItemStack(Items.IRON_SWORD));
    }

    @Override
    protected void rewardTradeXp(MerchantOffer p_213713_1_) {

    }

    @Override
    protected void updateTrades() {
        MerchantOffers merchantoffers = this.getOffers();
        this.addOffersFromItemListings(merchantoffers, this.sells, 5);  // idk what the 5 is for
        this.addOffersFromItemListings(merchantoffers, this.buys, 5);
    }

    public void setHome(BlockPos pos){
        this.homePos = pos;
    }

    public boolean hasXPBar() {
        return false;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new TradeWithPlayerGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, ZombieEntity.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, EvokerEntity.class, 12.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, VindicatorEntity.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, VexEntity.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PillagerEntity.class, 15.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, IllusionerEntity.class, 12.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, BlazeEntity.class, 12.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.25D));
        this.goalSelector.addGoal(1, new LookAtCustomerGoal(this));
        this.goalSelector.addGoal(2, new AbstractDumb.MoveToGoal(this, 2.0D, 0.35D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.35D, false, Ingredient.of(Items.EMERALD)));
        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 0.35D));
        this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity mate) {
        return null;
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity playerIn, Hand hand) {
        if (this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (hand == Hand.MAIN_HAND) {
                playerIn.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (this.getOffers().isEmpty()) {
                return super.mobInteract(playerIn, hand);
            } else {
                if (!this.level.isClientSide) {
                    this.setTradingPlayer(playerIn);
                    this.openTradingScreen(playerIn, this.getDisplayName(), 1);
                }

                return ActionResultType.sidedSuccess(this.level.isClientSide);
            }
        } else {
            return super.mobInteract(playerIn, hand);
        }
    }

    public void writeAdditional(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        if (this.wanderTarget != null) {
            compound.put("WanderTarget", NBTUtil.writeBlockPos(this.wanderTarget));
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("WanderTarget")) {
            this.wanderTarget = NBTUtil.readBlockPos(compound.getCompound("WanderTarget"));
        }

        this.ageUp(Math.max(0, this.getAge()));
    }

    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    protected void onVillagerTrade(MerchantOffer offer) {
        if (offer.shouldRewardExp()) {
            int i = 3 + this.random.nextInt(4);
            this.level.addFreshEntity(new ExperienceOrbEntity(this.level, this.getX(), this.getY() + 0.5D, this.getZ(), i));
        }
    }

    protected SoundEvent getAmbientSound() {
        return this.isTrading() ? SoundEvents.WANDERING_TRADER_TRADE : SoundEvents.WANDERING_TRADER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.WANDERING_TRADER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.WANDERING_TRADER_DEATH;
    }

    protected SoundEvent getDrinkSound(ItemStack stack) {
        Item item = stack.getItem();
        return item == Items.MILK_BUCKET ? SoundEvents.WANDERING_TRADER_DRINK_MILK : SoundEvents.WANDERING_TRADER_DRINK_POTION;
    }

    protected SoundEvent getVillagerYesNoSound(boolean getYesSound) {
        return getYesSound ? SoundEvents.WANDERING_TRADER_YES : SoundEvents.WANDERING_TRADER_NO;
    }

    public SoundEvent getYesSound() {
        return SoundEvents.WANDERING_TRADER_YES;
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
        final AbstractDumb traderEntity;
        final double maxDistance;
        final double speed;

        MoveToGoal(AbstractDumb traderEntityIn, double distanceIn, double speedIn) {
            this.traderEntity = traderEntityIn;
            this.maxDistance = distanceIn;
            this.speed = speedIn;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.traderEntity.setWanderTarget((BlockPos) null);
            AbstractDumb.this.navigation.stop();
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            BlockPos blockpos = this.traderEntity.getWanderTarget();

            if (this.traderEntity.homePos != null && this.traderEntity.level.isNight()) return true;
            return blockpos != null && this.isWithinDistance(blockpos, this.maxDistance);
        }

        @Override
        public boolean canUse() {
            return false;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            BlockPos blockpos = this.traderEntity.getWanderTarget();
            if (blockpos != null && AbstractDumb.this.navigation.isDone()) {
                if (this.isWithinDistance(blockpos, 10.0D)) {
                    Vector3d vec3d = (new Vector3d((double) blockpos.getX() - this.traderEntity.getX(), (double) blockpos.getY() - this.traderEntity.getY(), (double) blockpos.getZ() - this.traderEntity.getZ())).normalize();
                    Vector3d vec3d1 = vec3d.scale(10.0D).add(this.traderEntity.getX(), this.traderEntity.getY(), this.traderEntity.getZ());
                    AbstractDumb.this.navigation.moveTo(vec3d1.x, vec3d1.y, vec3d1.z, this.speed);
                } else {
                    AbstractDumb.this.navigation.moveTo((double) blockpos.getX(), (double) blockpos.getY(), (double) blockpos.getZ(), this.speed);
                }
            }

        }

        private boolean isWithinDistance(BlockPos pos, double distance) {
            return !pos.closerThan(this.traderEntity.position(), distance);
        }
    }
}
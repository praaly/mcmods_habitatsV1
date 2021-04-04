package net.praaly.habitats.setup.items;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModSpawnEgg extends SpawnEggItem
{
	
	protected static final List<ModSpawnEgg> UNADDED_EGGS = new ArrayList<ModSpawnEgg>();
	private final Lazy<? extends EntityType<?>> entityTypeSupplier;

	public ModSpawnEgg(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int primaryColour, final int secondaryColour, final Item.Properties properties) {
		super(null, primaryColour, secondaryColour, properties);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		UNADDED_EGGS.add(this);
	}

	public ModSpawnEgg(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int primaryColour, final int secondaryColour, final Item.Properties properties) {
		super(null, primaryColour, secondaryColour, properties);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		UNADDED_EGGS.add(this);
	}
	
	public static void InitSpawnEggs() {
		final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
		DefaultDispenseItemBehavior dispenseBehavior = new DefaultDispenseItemBehavior() {
			@Override
			protected ItemStack execute(IBlockSource source, ItemStack stack) {
				//Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
				EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
				//type.spawn(source.getLevel(), stack, null, source.getPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
				stack.shrink(1);
			    return stack;
			}
		};
		
		for(final SpawnEggItem spawnEgg : UNADDED_EGGS) {
			EGGS.put(spawnEgg.getType(null), spawnEgg);
			DispenserBlock.registerBehavior(spawnEgg, dispenseBehavior);
		}
		UNADDED_EGGS.clear();
	}
	
	@Override
	public EntityType<?> getType(CompoundNBT nbt) {
		return this.entityTypeSupplier.get();
	}
}

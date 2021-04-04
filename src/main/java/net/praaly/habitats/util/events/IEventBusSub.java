package net.praaly.habitats.util.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface IEventBusSub {
	PlayerEntity getClientPlayer();
	World getClientWorld();
}

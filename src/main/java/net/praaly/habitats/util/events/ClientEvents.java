package net.praaly.habitats.util.events;

import net.minecraftforge.api.distmarker.Dist;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.praaly.habitats.HabitatsMain;
import net.praaly.habitats.setup.ModEntity;
import net.praaly.habitats.setup.entities.dumb_marchants.DumbMarchantRenderer;

public class ClientEvents {
	
	@EventBusSubscriber(value = {Dist.CLIENT}, modid = HabitatsMain.MOD_ID, bus = Bus.MOD)
	public static class ModClientEvents {
		@SubscribeEvent
		public static void doClientStuff(final FMLClientSetupEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ModEntity.WANDERING_FLORIST.get(), DumbMarchantRenderer::new);
	    }
	}
	
	static boolean i = false;


}

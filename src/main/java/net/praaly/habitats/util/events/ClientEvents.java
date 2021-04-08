package net.praaly.habitats.util.events;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.praaly.habitats.HabitatsMain;
import net.praaly.habitats.setup.ModContainerTypes;
import net.praaly.habitats.setup.ModEntity;
import net.praaly.habitats.setup.entities.dumb_traders.DumbTradersRenderer;
import net.praaly.habitats.setup.entities.guard_traders.GuardTradersRenderer;
import net.praaly.habitats.setup.gui.GenericStorageScreen;
import net.praaly.habitats.setup.inventory.GenericStorageContainer;

public class ClientEvents {

	@EventBusSubscriber(value = {Dist.CLIENT}, modid = HabitatsMain.MOD_ID, bus = Bus.MOD)
	public static class ModClientEvents {
		@SubscribeEvent
		public static void doClientStuff(final FMLClientSetupEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ModEntity.DUMB_TRADER.get(), DumbTradersRenderer::new);
			RenderingRegistry.registerEntityRenderingHandler(ModEntity.GUARD_TRADER.get(), GuardTradersRenderer::new);
			ScreenManager.<GenericStorageContainer, GenericStorageScreen<GenericStorageContainer>>register(
					ModContainerTypes.KITCHEN_CABINET_CONTAINER.get(), GenericStorageScreen::new);
		}
	}

	static boolean i = false;


}

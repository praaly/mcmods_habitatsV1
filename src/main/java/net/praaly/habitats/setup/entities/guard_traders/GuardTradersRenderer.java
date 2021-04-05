package net.praaly.habitats.setup.entities.guard_traders;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.praaly.habitats.HabitatsMain;

@OnlyIn(Dist.CLIENT)
public class GuardTradersRenderer extends MobRenderer<GuardTradersEntity, PlayerModel<GuardTradersEntity>> {
    private static final ResourceLocation field_217780_a = new ResourceLocation(HabitatsMain.MOD_ID, "textures/entity/guard_traders.png");

    public GuardTradersRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PlayerModel<>(0.0F, true), 0.5F);
        this.addLayer(new HeadLayer<>(this));
        this.addLayer(new CrossedArmsItemLayer<>(this));

    }


    @Override
    public ResourceLocation getTextureLocation(GuardTradersEntity entity) {
        return field_217780_a;
    }

    protected void preRenderCallback(GuardTradersEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        @SuppressWarnings("unused")
        float f = 0.9375F;
        matrixStackIn.scale(0.9375F, 0.9375F, 0.9375F);
    }
}
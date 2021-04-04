package net.praaly.habitats.setup.entities.dumb_traders;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.praaly.habitats.HabitatsMain;

@OnlyIn(Dist.CLIENT)
public class DumbTradersRenderer extends MobRenderer<DumbTradersEntity, VillagerModel<DumbTradersEntity>> {
    private static final ResourceLocation field_217780_a = new ResourceLocation(HabitatsMain.MOD_ID, "textures/entity/wandering_florist_entity.png");

    public DumbTradersRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new VillagerModel<>(0.0F), 0.5F);
        this.addLayer(new HeadLayer<>(this));
        this.addLayer(new CrossedArmsItemLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(DumbTradersEntity entity) {
        return field_217780_a;
    }

    protected void preRenderCallback(DumbTradersEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        @SuppressWarnings("unused")
        float f = 0.9375F;
        matrixStackIn.scale(0.9375F, 0.9375F, 0.9375F);
    }
}
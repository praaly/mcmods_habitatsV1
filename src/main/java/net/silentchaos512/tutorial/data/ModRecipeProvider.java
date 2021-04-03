package net.silentchaos512.tutorial.data;

import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.silentchaos512.tutorial.TutorialMod;
import net.silentchaos512.tutorial.setup.ModBlocks;
import net.silentchaos512.tutorial.setup.ModItems;
import java.util.function.Consumer;

import net.minecraft.item.Item;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.TEORITE_INGOT.get(), 9)
                .requires(ModBlocks.TEORITE_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.TEORITE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.TEORITE_BLOCK.get())
                .define('#', ModItems.TEORITE_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.TEORITE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.TEORITE_SWORD.get())
                .define('#', ModItems.TEORITE_INGOT.get())
                .define('X', Items.STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" X ")
                .unlockedBy("has_item", has(ModItems.TEORITE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.TITANIUM_SWORD.get())
                .define('#', ModItems.TITANIUM_INGOT.get())
                .define('X', Items.STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" X ")
                .unlockedBy("has_item", has(ModItems.TITANIUM_INGOT.get()))
                .save(consumer);

        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.TEORITE_ORE.get()), ModItems.TEORITE_INGOT.get(), 0.7f, 200)
                .unlockedBy("has_item", has(ModBlocks.TEORITE_ORE.get()))
                .save(consumer, modId("teorite_ingot_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.TEORITE_ORE.get()), ModItems.TEORITE_INGOT.get(), 0.7f, 100)
                .unlockedBy("has_item", has(ModBlocks.TEORITE_ORE.get()))
                .save(consumer, modId("teorite_ingot_blasting"));

        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.TITANIUM_ORE.get()), ModItems.TITANIUM_INGOT.get(), 0.7f, 200)
                .unlockedBy("has_item", has(ModBlocks.TITANIUM_ORE.get()))
                .save(consumer, modId("titanium_ingot_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.TITANIUM_ORE.get()), ModItems.TITANIUM_INGOT.get(), 0.7f, 100)
                .unlockedBy("has_item", has(ModBlocks.TITANIUM_ORE.get()))
                .save(consumer, modId("titanium_ingot_blasting"));
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(TutorialMod.MOD_ID, path);
    }
}

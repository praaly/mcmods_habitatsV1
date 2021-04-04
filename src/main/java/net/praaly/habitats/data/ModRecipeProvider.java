package net.praaly.habitats.data;

import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.praaly.habitats.HabitatsMain;
import net.praaly.habitats.setup.ModBlocks;
import net.praaly.habitats.setup.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        /*----------------------------   Equipments   ------------------------------*/
        /*----------------------------     TEORITE    ------------------------------*/
        /* RECIPE FOR TEORITE_INGOT */
        ShapelessRecipeBuilder.shapeless(ModItems.TEORITE_INGOT.get(), 9)
                .requires(ModBlocks.TEORITE_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.TEORITE_INGOT.get()))
                .save(consumer);
        /* RECIPE FOR TEORITE_BLOCK */
        ShapedRecipeBuilder.shaped(ModBlocks.TEORITE_BLOCK.get())
                .define('#', ModItems.TEORITE_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.TEORITE_INGOT.get()))
                .save(consumer);
        /* RECIPE FOR TEORITE_SWORD */
        ShapedRecipeBuilder.shaped(ModItems.TEORITE_SWORD.get())
                .define('#', ModItems.TEORITE_INGOT.get())
                .define('X', Items.STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" X ")
                .unlockedBy("has_item", has(ModItems.TEORITE_INGOT.get()))
                .save(consumer);
        /* RECIPE FOR TEORITE_PICKAXE */
        ShapedRecipeBuilder.shaped(ModItems.TEORITE_PICKAXE.get())
                .define('#', ModItems.TEORITE_INGOT.get())
                .define('X', Items.STICK)
                .pattern("###")
                .pattern(" X ")
                .pattern(" X ")
                .unlockedBy("has_item", has(ModItems.TEORITE_INGOT.get()))
                .save(consumer);
        /* RECIPE FOR TEORITE_AXE */
        ShapedRecipeBuilder.shaped(ModItems.TEORITE_AXE.get())
                .define('#', ModItems.TEORITE_INGOT.get())
                .define('X', Items.STICK)
                .pattern("## ")
                .pattern("#X ")
                .pattern(" X ")
                .unlockedBy("has_item", has(ModItems.TEORITE_INGOT.get()))
                .save(consumer);
        /* RECIPE FOR TEORITE_SHOVEL */
        ShapedRecipeBuilder.shaped(ModItems.TEORITE_SHOVEL.get())
                .define('#', ModItems.TEORITE_INGOT.get())
                .define('X', Items.STICK)
                .pattern(" # ")
                .pattern(" X ")
                .pattern(" X ")
                .unlockedBy("has_item", has(ModItems.TEORITE_INGOT.get()))
                .save(consumer);
        /* RECIPE FOR TEORITE_HOE */
        ShapedRecipeBuilder.shaped(ModItems.TEORITE_HOE.get())
                .define('#', ModItems.TEORITE_INGOT.get())
                .define('X', Items.STICK)
                .pattern("## ")
                .pattern(" X ")
                .pattern(" X ")
                .unlockedBy("has_item", has(ModItems.TEORITE_INGOT.get()))
                .save(consumer);
        /*----------------------------   Equipments   ------------------------------*/
        /*----------------------------     TITANIUM    ------------------------------*/
        /* RECIPE FOR TITANIUM SWORD */
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
        return new ResourceLocation(HabitatsMain.MOD_ID, path);
    }
}

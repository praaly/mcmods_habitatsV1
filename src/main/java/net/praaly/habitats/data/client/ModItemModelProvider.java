package net.praaly.habitats.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.praaly.habitats.HabitatsMain;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, HabitatsMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("teorite_block", modLoc("block/teorite_block"));
        withExistingParent("teorite_ore", modLoc("block/teorite_ore"));
        withExistingParent("titanium_ore", modLoc("block/titanium_ore"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        ModelFile itemHandheld = getExistingFile(mcLoc("item/handheld"));

        builder(itemGenerated, "teorite_ingot");
        builder(itemGenerated, "titanium_ingot");
        builder(itemHandheld, "teorite_sword");
        builder(itemHandheld, "teorite_pickaxe");
        builder(itemHandheld, "teorite_axe");
        builder(itemHandheld, "teorite_shovel");
        builder(itemHandheld, "teorite_hoe");
        builder(itemHandheld, "titanium_sword");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}

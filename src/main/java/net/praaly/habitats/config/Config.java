package net.praaly.habitats.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
	public static final String CATEGORY_WORLD = "world";
		public static final String SUBCATEGORY_ORES = "ores";
			public static final String SUBCATEGORY_TIN = "tin";
			public static final String SUBCATEGORY_ALUMINUM = "aluminum";
			public static final String SUBCATEGORY_COPPER = "copper";
			public static final String SUBCATEGORY_LEAD = "lead";
			public static final String SUBCATEGORY_SILVER = "silver";
			public static final String SUBCATEGORY_NICKEL = "nickel";
			public static final String SUBCATEGORY_SULFUR = "sulfur";
			public static final String SUBCATEGORY_PLATINUM = "platinum";
			public static final String SUBCATEGORY_TUNGSTEN = "tungsten";
			public static final String SUBCATEGORY_RUBY = "ruby";
			public static final String SUBCATEGORY_AMETHYST = "amethyst";
			public static final String SUBCATEGORY_SAPPHIRE = "sapphire";
			public static final String SUBCATEGORY_OPAL = "opal";
			public static final String SUBCATEGORY_TITANIUM = "titanium";
			public static final String SUBCATEGORY_URANIUM = "uranium";
			public static final String SUBCATEGORY_COBALT = "cobalt";
			public static final String SUBCATEGORY_ZINC = "zinc";
			public static final String SUBCATEGORY_SALTPETRE = "saltpetre";
			public static final String SUBCATEGORY_CHROMIUM = "chromium";
			public static final String SUBCATEGORY_THORIUM = "thorium";
		public static final String SUBCATEGORY_TREES = "trees";
		public static final String SUBCATEGORY_FEATURES = "features";
	public static final String CATEGORY_ENERGY = "energy";
	public static final String CATEGORY_MISC = "misc";
	
	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;
    
    public static ForgeConfigSpec.DoubleValue solarGenMultiplier;
    
    public static ForgeConfigSpec.BooleanValue enableCLibScreen;
    public static ForgeConfigSpec.BooleanValue enableDebug;
    
    static {
    	ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
        
        COMMON_BUILDER.comment("World Config").push(CATEGORY_WORLD);
        COMMON_BUILDER.pop();
        
        COMMON_BUILDER.comment("Energy Config").push(CATEGORY_ENERGY);
        solarGenMultiplier = energyGen(COMMON_BUILDER, "SolarGen", 1);
        COMMON_BUILDER.pop();
        
        CLIENT_BUILDER.comment("Miscellaneous Config").push(CATEGORY_MISC);
        enableCLibScreen = CLIENT_BUILDER.comment("Enable or disable the CLib warning screen that pops up when CLib is installed").define("enableScreen", true);
        enableDebug = CLIENT_BUILDER.comment("Enable or disable item tag and nbt data tootltip").define("enableDebug", false);
        CLIENT_BUILDER.pop();
        
        COMMON_CONFIG = COMMON_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }
    
    public static ForgeConfigSpec.DoubleValue energyGen(ForgeConfigSpec.Builder COMMON_BUILDER, String machine, double defaultValue) {
    	return COMMON_BUILDER.comment("The multiplier for the machine's energy production(eg. 16(FE/t)*0.5(multiplier)=8(FE/t))").defineInRange("energy" + machine, defaultValue, 0, Double.MAX_VALUE);
    }
    
    public static ForgeConfigSpec.BooleanValue oreEnableConfig(ForgeConfigSpec.Builder COMMON_BUILDER, String ore) {
    	return COMMON_BUILDER.comment("Enable or disable the ore").define("enable" + ore, true);
    }
    
    public static ForgeConfigSpec.IntValue oreVeinCountConfig(ForgeConfigSpec.Builder COMMON_BUILDER, int defaultValue, String ore) {
    	return COMMON_BUILDER.comment("The rarity of the ore").defineInRange("veinCount" + ore, defaultValue, 1, 1000);
    }
    
    public static ForgeConfigSpec.IntValue oreVeinSizeConfig(ForgeConfigSpec.Builder COMMON_BUILDER, int defaultValue, String ore) {
    	return COMMON_BUILDER.comment("The size of the ore's veins").defineInRange("veinSize" + ore, defaultValue, 1, 100);
    }
    
    public static ForgeConfigSpec.IntValue oreMinYConfig(ForgeConfigSpec.Builder COMMON_BUILDER, int defaultValue, String ore) {
    	return COMMON_BUILDER.comment("Minimum Y value your ore spawns at(MUST be lower than maxY)").defineInRange("minY" + ore, defaultValue, 0, 255);
    }
    
    public static ForgeConfigSpec.IntValue oreMaxYConfig(ForgeConfigSpec.Builder COMMON_BUILDER, int defaultValue, String ore) {
    	return COMMON_BUILDER.comment("Maximum Y value your ore spawns at(Must be higher than minY)").defineInRange("maxY" + ore, defaultValue, 0, 255);
    }
    
    public static ForgeConfigSpec.DoubleValue treeChance(ForgeConfigSpec.Builder COMMON_BUILDER, float value, String tree) {
    	return COMMON_BUILDER.comment("Chance a tree has, to spawn in the world").defineInRange(tree + "Chance", value, 0, 10.0f);
    }
}

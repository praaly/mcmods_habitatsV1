package net.praaly.habitats.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
	public static final String CATEGORY_WORLD = "world";
	public static final String CATEGORY_MISC = "misc";
	
	public static ForgeConfigSpec COMMON_CONFIG;
	public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;
    
    public static ForgeConfigSpec.DoubleValue solarGenMultiplier;
    
    public static ForgeConfigSpec.BooleanValue enableCLibScreen;
    public static ForgeConfigSpec.BooleanValue enableDebug;

}

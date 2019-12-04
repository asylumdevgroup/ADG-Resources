package asylumdev.adgresources.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {
	public static ForgeConfigSpec.IntValue advancium_chance;
	public static ForgeConfigSpec.IntValue copper_chance;
	public static ForgeConfigSpec.IntValue tin_chance;
	public static ForgeConfigSpec.IntValue aluminum_chance;
	public static ForgeConfigSpec.IntValue lead_chance;
	public static ForgeConfigSpec.IntValue silver_chance;
	public static ForgeConfigSpec.BooleanValue generate_advancium;
	public static ForgeConfigSpec.BooleanValue generate_copper;
	public static ForgeConfigSpec.BooleanValue generate_tin;
	public static ForgeConfigSpec.BooleanValue generate_aluminum;
	public static ForgeConfigSpec.BooleanValue generate_lead;
	public static ForgeConfigSpec.BooleanValue generate_silver;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Oregen Config");
		
		advancium_chance = server
				.comment("Maximum number of ore veins of Advancium ore that can spawn in one chunk.")
				.defineInRange("oregen.advancium_chance", 8, 1, 1000000);
		copper_chance = server
				.comment("Maximum number of ore veins of Copper ore that can spawn in one chunk.")
				.defineInRange("oregen.copper_chance", 8, 1, 1000000);
		tin_chance = server
				.comment("Maximum number of ore veins of Tin ore that can spawn in one chunk.")
				.defineInRange("oregen.tin_chance", 8, 1, 1000000);
		aluminum_chance = server
				.comment("Maximum number of ore veins of Aluminum ore that can spawn in one chunk.")
				.defineInRange("oregen.aluminum_chance", 7, 1, 1000000);
		lead_chance = server
				.comment("Maximum number of ore veins of Lead ore that can spawn in one chunk.")
				.defineInRange("oregen.lead_chance", 5, 1, 1000000);
		silver_chance = server
				.comment("Maximum number of ore veins of Silver ore that can spawn in one chunk.")
				.defineInRange("oregen.silver_chance", 5, 1, 1000000);
		
		generate_advancium = server
				.comment("Decide if you want Advancium ore to spawn in the overworld")
				.define("oregen.generate_advancium", true);
		generate_copper = server
				.comment("Decide if you want Copper ore to spawn in the overworld")
				.define("oregen.generate_copper", true);
		generate_tin = server
				.comment("Decide if you want Tin ore to spawn in the overworld")
				.define("oregen.generate_tin", true);
		generate_aluminum = server
				.comment("Decide if you want Aluminum ore to spawn in the overworld")
				.define("oregen.generate_aluminum", true);
		generate_lead = server
				.comment("Decide if you want Lead ore to spawn in the overworld")
				.define("oregen.generate_lead", true);
		generate_silver = server
				.comment("Decide if you want Silver ore to spawn in the overworld")
				.define("oregen.generate_silver", true);
	}
}

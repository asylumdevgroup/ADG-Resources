package asylumdev.adgresources;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import asylumdev.adgresources.block.ModBlocks;
import asylumdev.adgresources.config.Config;
import asylumdev.adgresources.item.ModItems;
import asylumdev.adgresources.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(ADGResourcesConstants.MODID)
public class ADGResources {
	public static final Logger LOGGER = LogManager.getLogger();

	public static ADGResources instance;
	public static ADGResourcesTab modGroup = new ADGResourcesTab();
	
    public ADGResources() {
    	instance = this;
    	
    	ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER, "adgresources-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT, "adgresources-client.toml");
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("adgresources-client.toml").toString());
		Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("adgresources-server.toml").toString());
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        OreGeneration.setupOreGeneration();
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    	@SubscribeEvent
    	public static void registerItems(final RegistryEvent.Register<Item> event) {
    		event.getRegistry().registerAll(
    				ModItems.iron_dust = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("iron_dust")),
    				ModItems.iron_plate = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("iron_plate")),
    				ModItems.iron_gear = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("iron_gear")),
    				ModItems.gold_dust = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("gold_dust")),
    	    		ModItems.gold_plate = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("gold_plate")),
    	    		ModItems.gold_gear = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("gold_gear")),
    				ModItems.advancium_ingot = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("advancium_ingot")),
    				ModItems.advancium_nugget = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("advancium_nugget")),
    				ModItems.advancium_dust = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("advancium_dust")),
    				ModItems.advancium_plate = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("advancium_plate")),
    				ModItems.advancium_gear = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("advancium_gear")),
    				ModItems.copper_ingot = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("copper_ingot")),
    	    		ModItems.copper_nugget = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("copper_nugget")),
    	    		ModItems.copper_dust = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("copper_dust")),
    	    		ModItems.copper_plate = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("copper_plate")),
    	    		ModItems.copper_gear = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("copper_gear")),
    	    		ModItems.tin_ingot = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("tin_ingot")),
    	    		ModItems.tin_nugget = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("tin_nugget")),
    	    		ModItems.tin_dust = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("tin_dust")),
    	    		ModItems.tin_plate = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("tin_plate")),
    	    		ModItems.tin_gear = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("tin_gear")),
    	    		ModItems.aluminum_ingot = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("aluminum_ingot")),
    	    		ModItems.aluminum_nugget = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("aluminum_nugget")),
    	    		ModItems.aluminum_dust = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("aluminum_dust")),
    	    		ModItems.aluminum_plate = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("aluminum_plate")),
    	    		ModItems.aluminum_gear = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("aluminum_gear")),
    	    		ModItems.lead_ingot = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("lead_ingot")),
    	    		ModItems.lead_nugget = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("lead_nugget")),
    	    		ModItems.lead_dust = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("lead_dust")),
    	    		ModItems.lead_plate = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("lead_plate")),
    	    		ModItems.lead_gear = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("lead_gear")),
    	    		ModItems.silver_ingot = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("silver_ingot")),
    	    		ModItems.silver_nugget = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("silver_nugget")),
    	    		ModItems.silver_dust = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("silver_dust")),
    	    		ModItems.silver_plate = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("silver_plate")),
    	    		ModItems.silver_gear = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("silver_gear")),
    	    		ModItems.bronze_ingot = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("bronze_ingot")),
    	    	    ModItems.bronze_nugget = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("bronze_nugget")),
    	    	    ModItems.bronze_dust = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("bronze_dust")),
    	    	    ModItems.bronze_plate = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("bronze_plate")),
    	    	    ModItems.bronze_gear = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("bronze_gear")),
    	    		ModItems.advancium_ore = new BlockItem(ModBlocks.advancium_ore, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.advancium_ore.getRegistryName()),
    	    		ModItems.copper_ore = new BlockItem(ModBlocks.copper_ore, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.copper_ore.getRegistryName()),
    	    		ModItems.tin_ore = new BlockItem(ModBlocks.tin_ore, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.tin_ore.getRegistryName()),
    	    		ModItems.aluminum_ore = new BlockItem(ModBlocks.aluminum_ore, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.aluminum_ore.getRegistryName()),
    	    		ModItems.lead_ore = new BlockItem(ModBlocks.lead_ore, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.lead_ore.getRegistryName()),
    	    		ModItems.silver_ore = new BlockItem(ModBlocks.silver_ore, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.silver_ore.getRegistryName()),
    	    	    ModItems.advancium_block = new BlockItem(ModBlocks.advancium_block, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.advancium_block.getRegistryName()),
    	    	    ModItems.copper_block = new BlockItem(ModBlocks.copper_block, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.copper_block.getRegistryName()),
    	    	    ModItems.tin_block = new BlockItem(ModBlocks.tin_block, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.tin_block.getRegistryName()),
    	    	    ModItems.aluminum_block = new BlockItem(ModBlocks.aluminum_block, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.aluminum_block.getRegistryName()),
    	    	    ModItems.lead_block = new BlockItem(ModBlocks.lead_block, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.lead_block.getRegistryName()),
    	    	    ModItems.silver_block = new BlockItem(ModBlocks.silver_block, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.silver_block.getRegistryName()),
    	    	    ModItems.bronze_block = new BlockItem(ModBlocks.bronze_block, new Item.Properties().group(modGroup)).setRegistryName(ModBlocks.bronze_block.getRegistryName())
    		);
    		LOGGER.info("Items registered");
    	}
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
            		ModBlocks.advancium_ore = new Block(Block.Properties.create(Material.ROCK).harvestLevel(1)).setRegistryName(location("advancium_ore")),
            		ModBlocks.copper_ore = new Block(Block.Properties.create(Material.ROCK).harvestLevel(1)).setRegistryName(location("copper_ore")),
            		ModBlocks.tin_ore = new Block(Block.Properties.create(Material.ROCK).harvestLevel(1)).setRegistryName(location("tin_ore")),
            		ModBlocks.aluminum_ore = new Block(Block.Properties.create(Material.ROCK).harvestLevel(1)).setRegistryName(location("aluminum_ore")),
            		ModBlocks.lead_ore = new Block(Block.Properties.create(Material.ROCK).harvestLevel(2)).setRegistryName(location("lead_ore")),
            		ModBlocks.silver_ore = new Block(Block.Properties.create(Material.ROCK).harvestLevel(2)).setRegistryName(location("silver_ore")),
            		ModBlocks.advancium_block = new Block(Block.Properties.create(Material.ROCK).harvestLevel(1)).setRegistryName(location("advancium_block")),
                    ModBlocks.copper_block = new Block(Block.Properties.create(Material.ROCK).harvestLevel(1)).setRegistryName(location("copper_block")),
                    ModBlocks.tin_block = new Block(Block.Properties.create(Material.ROCK).harvestLevel(1)).setRegistryName(location("tin_block")),
                    ModBlocks.aluminum_block = new Block(Block.Properties.create(Material.ROCK).harvestLevel(1)).setRegistryName(location("aluminum_block")),
                    ModBlocks.lead_block = new Block(Block.Properties.create(Material.ROCK).harvestLevel(2)).setRegistryName(location("lead_block")),
                    ModBlocks.silver_block = new Block(Block.Properties.create(Material.ROCK).harvestLevel(2)).setRegistryName(location("silver_block")),
                    ModBlocks.bronze_block = new Block(Block.Properties.create(Material.ROCK).harvestLevel(1)).setRegistryName(location("bronze_block"))
            );
            LOGGER.info("Blocks registered");
        }
        private static ResourceLocation location(String name) {
        	return new ResourceLocation(ADGResourcesConstants.MODID, name);
        }
    }
}

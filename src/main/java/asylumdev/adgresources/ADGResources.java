package asylumdev.adgresources;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import asylumdev.adgresources.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ADGResourcesConstants.MODID)
public class ADGResources {
	private static final Logger LOGGER = LogManager.getLogger();

	public static ADGResources instance;
	public static ADGResourcesTab modGroup = new ADGResourcesTab();
	
    public ADGResources() {
    	instance = this;
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
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
    	    		ModItems.silver_gear = new Item(new Item.Properties().group(modGroup)).setRegistryName(location("silver_gear"))
    				
    		);
    		LOGGER.info("Items registered");
    	}
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("Blocks registered");
        }
        private static ResourceLocation location(String name) {
        	return new ResourceLocation(ADGResourcesConstants.MODID, name);
        }
    }
}

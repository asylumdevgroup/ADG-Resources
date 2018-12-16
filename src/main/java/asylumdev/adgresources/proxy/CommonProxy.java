package asylumdev.adgresources.proxy;

import java.io.File;

import asylumdev.adgresources.ADGResourcesConstants;
import asylumdev.adgresources.api.materialsystem.material.BasicMaterial;
import asylumdev.adgresources.util.ADGResourcesConfig;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.RegistryBuilder;

@Mod.EventBusSubscriber
public class CommonProxy {
	public static Configuration config;
	
    public void preInit(FMLPreInitializationEvent e) {
    	File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "adg/adgresources.cfg"));
        ADGResourcesConfig.readConfig();
    }

    public void init(FMLInitializationEvent e) {
    	
    }

    public void postInit(FMLPostInitializationEvent e) {
    	if (config.hasChanged()) {
            config.save();
        }
    }
    @SubscribeEvent
	public static void registerMaterialRegistry(RegistryEvent.NewRegistry e)
	{
		RegistryBuilder<BasicMaterial> regBuilder = new RegistryBuilder<BasicMaterial>();
		regBuilder.setType(BasicMaterial.class);
    	regBuilder.setName(new ResourceLocation(ADGResourcesConstants.MODID, "materials"));
    	regBuilder.setIDRange(0, Short.MAX_VALUE);
    	regBuilder.setDefaultKey(new ResourceLocation (ADGResourcesConstants.MODID, "materials"));
    	regBuilder.create();
	}
    @SubscribeEvent
    public static void registerMaterials(RegistryEvent.Register<BasicMaterial> event) {
    	
    }
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	
    }
		
}
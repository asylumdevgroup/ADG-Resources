package asylumdev.adgresources;

import org.apache.logging.log4j.Logger;

import asylumdev.adglib.ADGLib;
import asylumdev.adgresources.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = ADGResourcesConstants.MODID, name = ADGResourcesConstants.NAME, version = ADGResourcesConstants.VERSION, dependencies = ADGResourcesConstants.DEPENDENCIES, useMetadata = true)
public class ADGResources {
	
	@SidedProxy(clientSide = "asylumdev.adgresources.proxy.ClientProxy", serverSide = "asylumdev.adgresources.proxy.ServerProxy")
	public static CommonProxy proxy;

	@Mod.Instance
	public static ADGResources instance;

	public static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	    logger = event.getModLog();
	    proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
	    proxy.init(e);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	    proxy.postInit(e);
	}
}

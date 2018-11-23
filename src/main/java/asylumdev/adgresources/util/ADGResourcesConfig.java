package asylumdev.adgresources.util;

import org.apache.logging.log4j.Level;

import asylumdev.adgresources.ADGResources;
import asylumdev.adgresources.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class ADGResourcesConfig {
	private static final String CATEGORY_WORLD = "worldgen";
	public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initWorldConfig(cfg);
        } catch (Exception e1) {
            ADGResources.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }
	private static void initWorldConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_WORLD, "Configure Ore Spawning Status Here. It is recommended to leave this unchanged if playing standalone.");
        // cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.
        
    }
}

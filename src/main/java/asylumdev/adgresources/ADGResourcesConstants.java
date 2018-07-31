package asylumdev.adgresources;

public class ADGResourcesConstants {
	/* Mod Information */
	public static final String MODID = "adgresources";
	public static final String NAME = "ADG Resources";
	public static final String VERSION = "0.0.0";
	public static final String MAXVERSION = "0.1.0";
	public static final String DEPENDENCIES = asylumdev.adglib.ADGLibConstants.FORGEDEPENDENCYINFO + asylumdev.adglib.ADGLibConstants.VERSION_GROUP;
	public static final String VERSION_GROUP = "required-after:" + MODID + "@[" + VERSION + "," + MAXVERSION + ");";
}

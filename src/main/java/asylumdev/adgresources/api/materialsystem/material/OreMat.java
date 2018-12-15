package asylumdev.adgresources.api.materialsystem.material;

import java.awt.Color;

public class OreMat extends BasicMat {

	private int level;
	public OreMat(String name, Color rgb, int harvestLevel) {
		super(name, rgb);
		level = harvestLevel;
	}

}

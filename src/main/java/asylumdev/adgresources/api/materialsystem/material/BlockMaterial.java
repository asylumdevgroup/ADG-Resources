package asylumdev.adgresources.api.materialsystem.material;

import java.awt.Color;

public class BlockMaterial extends ItemMaterial {

	private int harvestLevel;
	public BlockMaterial(String name, Color color, int id, int tier, int level) {
		super(name, color, id, tier);
		harvestLevel = level;
	}
	public int getHarvestLevel() {
		return harvestLevel;
	}
}

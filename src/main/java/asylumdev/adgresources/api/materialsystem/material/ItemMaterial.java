package asylumdev.adgresources.api.materialsystem.material;

import java.awt.Color;

public class ItemMaterial extends BasicMaterial {
	
	private int materialTier;
	public ItemMaterial(String name, Color color, int id, int tier) {
		super(name, color, id);
		materialTier = tier;
	}
	public int getTier() {
		return materialTier;
	}
	@Override
	public void regParts() {
		
	}
}

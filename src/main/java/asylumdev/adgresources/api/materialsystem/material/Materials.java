package asylumdev.adgresources.api.materialsystem.material;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Materials {
	public static List<BasicMaterial> materials = new ArrayList<>();
	public static BlockMaterial advancium = new BlockMaterial("advancium", new Color(150, 50, 150), 0, 1, 1);
	
	public void addMaterials() {
		materials.add(advancium);
	}
	public void registerParts() {
		for(int i = 0; i < materials.size(); i++) {
			materials.get(i).regParts();
		}
	}
}

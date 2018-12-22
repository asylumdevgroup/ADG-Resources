package asylumdev.adgresources.api.materialsystem.material;

import java.awt.Color;

import net.minecraftforge.registries.IForgeRegistryEntry;

public class BasicMaterial extends IForgeRegistryEntry.Impl<BasicMaterial> {
	private String matName;
	private Color matColor;
	private int metaId;
	public BasicMaterial(String name, Color color, int id) {
		matName = name;
		matColor = color;
		metaId = id;
	}
	public String getName() {
		return matName;
	}
	public Color getColor() {
		return matColor;
	}
	public int getId() {
		return metaId;
	}
	public void regParts() {
		
	}
}

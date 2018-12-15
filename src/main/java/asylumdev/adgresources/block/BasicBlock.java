package asylumdev.adgresources.block;

import asylumdev.adgresources.ADGResources;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block{
	protected String name;
	
	public BasicBlock(Material material, String name) {
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ADGResources.resourcesTab);
	}
	
}

package asylumdev.adgresources.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictBlock extends BasicBlock{
	private String oreName;
	public OreDictBlock(String name, String oreName) {
		super(Material.ROCK, name);
		
		this.oreName = oreName;
		setHardness(3f);
		setResistance(5f);
	}
	public void initOreDict() {
		OreDictionary.registerOre(oreName, this);
	}
	@Override
	public OreDictBlock setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}

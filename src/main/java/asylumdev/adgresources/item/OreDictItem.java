package asylumdev.adgresources.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictItem extends BasicItem {
	private String oreName;
	
	public OreDictItem(String name, String oreName) {
		super(name);
		this.oreName = oreName;
	}
	public void initOreDict() {
		OreDictionary.registerOre(oreName, this);
	}
	@Override
	public OreDictItem setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}

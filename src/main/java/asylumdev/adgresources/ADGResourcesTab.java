package asylumdev.adgresources;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ADGResourcesTab extends ItemGroup {

	public ADGResourcesTab() {
		super(ADGResourcesConstants.MODID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return new ItemStack(Blocks.IRON_ORE);
	}

}

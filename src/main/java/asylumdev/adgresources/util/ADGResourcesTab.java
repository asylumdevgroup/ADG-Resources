package asylumdev.adgresources.util;

import asylumdev.adgresources.ADGResourcesConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ADGResourcesTab extends CreativeTabs {
	public ADGResourcesTab(){
        super(ADGResourcesConstants.MODID);
    }
    @Override
    public ItemStack getTabIconItem(){
        return new ItemStack(Items.IRON_INGOT);
    }
}

package asylumdev.adgresources.item;

import asylumdev.adgresources.ADGResources;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BasicItem extends Item {
	protected String name;

    public BasicItem(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ADGResources.resourcesTab);
    }
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
    @Override
    public BasicItem setCreativeTab(CreativeTabs tab){
        super.setCreativeTab(tab);
        return this;
    }
}

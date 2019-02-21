package asylumdev.adgresources.block;

import net.minecraft.block.Block;

public class BlockBase extends Block {

	protected String name;
	public BlockBase(Properties properties, String name) {
		super(properties);
		this.name = name;
	}

}

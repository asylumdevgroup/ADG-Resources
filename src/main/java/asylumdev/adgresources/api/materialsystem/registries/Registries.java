package asylumdev.adgresources.api.materialsystem.registries;

import asylumdev.adgresources.api.materialsystem.material.BasicMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class Registries {
	public static final IForgeRegistry<BasicMaterial> CARDREGISTRY = GameRegistry.findRegistry(BasicMaterial.class);
}

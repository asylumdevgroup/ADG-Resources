package asylumdev.adgresources.material;

public class OreMat extends BasicMat {

	private int level;
	public OreMat(String name, int rgb, int harvestLevel) {
		super(name, rgb);
		level = harvestLevel;
	}

}

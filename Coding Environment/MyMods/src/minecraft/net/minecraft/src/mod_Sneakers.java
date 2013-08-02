package net.minecraft.src;

public class mod_Sneakers extends BaseMod {
	public mod_Sneakers(){
		ModLoader.addRecipe(new ItemStack(sneakers, 1), new Object[]{"SSS", "LLL", 'S', Item.silk, 'L', Item.leather});
		ModLoader.addRecipe(new ItemStack(flyingSneakers, 1), new Object[]{" J ", "SSS", "LLL", 'J', jetpack, 'S', Item.silk, 'L', Item.leather});
		ModLoader.addRecipe(new ItemStack(jetpack, 1), new Object[]{" I ", " R ", " O ", 'I', Item.ingotIron, 'R', Item.redstone, 'O', mod_Oxygen.oxymol});
	}
	
	@Override
	public String getVersion() {
		// VERSION
		return "Version 2.0";
	}

	public static final Item jetpack = new ItemJetpack(516)
	.setUnlocalizedName("jetpack")
	.setCreativeTab(CreativeTabs.tabTools)
	.setMaxStackSize(1);
	
	public static final Item sneakers = new ItemSneakers(517)
	.setUnlocalizedName("sneakers")
	.setCreativeTab(CreativeTabs.tabTools);
	
	public static final Item flyingSneakers = new ItemFlyingSneakers(518)
	.setUnlocalizedName("flyingSneakers")
	.setCreativeTab(CreativeTabs.tabTools);
	
	@Override
	public void load() {
		ModLoader.addName(sneakers, "Sneakers");
		ModLoader.addName(flyingSneakers, "Flying Sneakers");
		ModLoader.addName(jetpack, "Jetpack");
	}
}

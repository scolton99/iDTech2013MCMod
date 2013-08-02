package net.minecraft.src;

public class mod_Oxygen extends BaseMod {
	public mod_Oxygen(){
		ModLoader.addSmelting(Item.bucketWater.itemID, new ItemStack(oxymol, 1), 0.4f);
	}
	
	@Override
	public String getVersion() {
		// VERSION
		return "Version 1.0";
	}

	public static Item electric = new Item(4002)
	.setUnlocalizedName("electro")
	.setCreativeTab(CreativeTabs.tabMisc);
	
	public static Item oxymol = new Item(4001)
	.setUnlocalizedName("oxymol")
	.setCreativeTab(CreativeTabs.tabMisc);

	@Override
	public void load() {
		ModLoader.addName(oxymol, "Oxygen (O2)");
		ModLoader.addName(electric, "Electrolyzer");
	}
	
	@Override
	public int addFuel(int var1, int var2){
		if(var1==electric.itemID){
			return 2000;
		}else{
			return 0;
		}
	}
}

package net.minecraft.src;

public class mod_EmeraldTools extends BaseMod {
	public mod_EmeraldTools()
	{
		ModLoader.addRecipe(new ItemStack(swordEmerald, 1),  new Object[]{" E ", " E ", " S ", 'E', Item.emerald, 'S', Item.stick});
		ModLoader.addRecipe(new ItemStack(pickaxeEmerald, 1), new Object[]{"EEE", " S ", " S ", 'E', Item.emerald, 'S', Item.stick});
		ModLoader.addRecipe(new ItemStack(axeEmerald, 1), new Object[]{" EE", " SE", " S ", 'E', Item.emerald, 'S', Item.stick});
		ModLoader.addRecipe(new ItemStack(shovelEmerald, 1), new Object[]{" E ", " S ", " S ", 'E', Item.emerald, 'S', Item.stick});
		ModLoader.addRecipe(new ItemStack(hoeEmerald, 1), new Object[]{" EE", " S ", " S ", 'E', Item.emerald, 'S', Item.stick});
	}
	
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "Version 1.1";
	}

	public static Item swordEmerald = new ItemSword(501, EnumToolMaterial.EME)
	.setUnlocalizedName("swordEmerald")
	.setCreativeTab(CreativeTabs.tabCombat);
	
	public static Item pickaxeEmerald = new ItemPickaxe(503, EnumToolMaterial.EME)
	.setUnlocalizedName("pickaxeEmerald")
	.setCreativeTab(CreativeTabs.tabTools);
	
	public static Item axeEmerald = new ItemAxe(504, EnumToolMaterial.EME)
	.setUnlocalizedName("axeEmerald")
	.setCreativeTab(CreativeTabs.tabTools);
	
	public static Item shovelEmerald = new ItemSpade(502, EnumToolMaterial.EME)
	.setUnlocalizedName("shovelEmerald")
	.setCreativeTab(CreativeTabs.tabTools);
	
	public static Item hoeEmerald = new ItemHoe(505, EnumToolMaterial.EME)
	.setUnlocalizedName("hoeEmerald")
	.setCreativeTab(CreativeTabs.tabTools);
	
	public static Achievement emeraldSword = new Achievement(41, "Emerald Sword", 0, 0, swordEmerald, null)
	.registerAchievement();
	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		ModLoader.addName(axeEmerald, "Emerald Axe");
		ModLoader.addName(pickaxeEmerald, "Emerald Pickaxe");
		ModLoader.addName(swordEmerald, "Emerald Sword");
		ModLoader.addName(shovelEmerald, "Emerald Shovel");
		ModLoader.addName(hoeEmerald, "Emerald Hoe");

		ModLoader.addAchievementDesc(emeraldSword, "Emerald Sword", "For having the 2nd greatest tools");
	}

	public void onItemPickup(EntityPlayer ep, ItemStack is){
		if(is.itemID == swordEmerald.itemID){
			ep.addStat(emeraldSword, 1);
		}
	}
}

package net.minecraft.src;

import java.util.Map;

public class mod_LapisTools extends BaseMod {
	public mod_LapisTools(){
		ModLoader.addRecipe(new ItemStack(Item.blazeRod, 1), new Object[]{" F ", " L ", "   ", 'F', Item.flintAndSteel, 'L', stickLapis});
		
		ModLoader.addRecipe(new ItemStack(swordLapis, 1), new Object[]{" L ", " L ", " B ", 'L', new ItemStack(Item.dyePowder, 1, 4), 'B', new ItemStack(stickLapis, 1)});
		ModLoader.addRecipe(new ItemStack(shovelLapis, 1), new Object[]{" L ", " S ", " S ", 'L', new ItemStack(Item.dyePowder, 1, 4), 'S', new ItemStack(Item.stick, 1)});
		ModLoader.addRecipe(new ItemStack(pickaxeLapis, 1), new Object[]{"LLL"," S "," S ",'L', new ItemStack(Item.dyePowder, 1, 4), 'S', new ItemStack(Item.stick, 1)});
		ModLoader.addRecipe(new ItemStack(axeLapis, 1), new Object[]{" LL", " SL", " S ", 'L', new ItemStack(Item.dyePowder, 1, 4), 'S', new ItemStack(Item.stick, 1)});
		ModLoader.addRecipe(new ItemStack(hoeLapis, 1), new Object[]{" LL", " S ", " S ", 'L', new ItemStack(Item.dyePowder, 1, 4), 'S', new ItemStack(Item.stick, 1)});
		
		ModLoader.addRecipe(new ItemStack(stickLapis, 1), new Object[]{"  L", " L ", "L  ", 'L', new ItemStack(Item.dyePowder, 1, 4)});
		
		ModLoader.addRecipe(new ItemStack(helmetLapis, 1), new Object[]{"LLL", "L L", "   ", 'L', new ItemStack(Item.dyePowder, 1, 4)});
		ModLoader.addRecipe(new ItemStack(chestplateLapis, 1), new Object[]{"L L", "LLL", "LLL", 'L', new ItemStack(Item.dyePowder, 1, 4)});
		ModLoader.addRecipe(new ItemStack(leggingsLapis, 1), new Object[]{"LLL", "L L", "L L", 'L', new ItemStack(Item.dyePowder, 1, 4)});
		ModLoader.addRecipe(new ItemStack(bootsLapis, 1), new Object[]{"   ", "L L", "L L", 'L', new ItemStack(Item.dyePowder, 1, 4)});
	}
	
	@Override
	public String getVersion() {
		// VERSION
		return "Version 1.0";
	}
	
	public static Item swordLapis = new ItemSword(506, EnumToolMaterial.LAPIS)
	.setUnlocalizedName("swordLapis")
	.setCreativeTab(CreativeTabs.tabCombat);
	
	public static Item shovelLapis = new ItemSpade(507, EnumToolMaterial.LAPIS)
	.setUnlocalizedName("shovelLapis")
	.setCreativeTab(CreativeTabs.tabTools);
	
	public static Item pickaxeLapis = new ItemPickaxe(508, EnumToolMaterial.LAPIS)
	.setUnlocalizedName("pickaxeLapis")
	.setCreativeTab(CreativeTabs.tabTools);
	
	public static Item axeLapis = new ItemAxe(509, EnumToolMaterial.LAPIS)
	.setUnlocalizedName("axeLapis")
	.setCreativeTab(CreativeTabs.tabTools);
	
	public static Item hoeLapis = new ItemHoe(510, EnumToolMaterial.LAPIS)
	.setUnlocalizedName("hoeLapis")
	.setCreativeTab(CreativeTabs.tabTools);	
	
	public static Item stickLapis = new Item(511)
	.setUnlocalizedName("stickLapis")
	.setCreativeTab(CreativeTabs.tabMisc);
	
	public static Item helmetLapis = new ItemArmor(512, EnumArmorMaterial.LAPIS, 5, 0)
	.setUnlocalizedName("helmetLapis")
	.setCreativeTab(CreativeTabs.tabCombat);
	
	public static Item chestplateLapis = new ItemArmor(513, EnumArmorMaterial.LAPIS, 5, 1)
	.setUnlocalizedName("chestplateLapis")
	.setCreativeTab(CreativeTabs.tabCombat);
	
	public static Item leggingsLapis = new ItemArmor(514, EnumArmorMaterial.LAPIS, 5, 2)
	.setUnlocalizedName("leggingsLapis")
	.setCreativeTab(CreativeTabs.tabCombat);
	
	public static Item bootsLapis = new ItemArmor(515, EnumArmorMaterial.LAPIS, 5, 3)
	.setUnlocalizedName("bootsLapis")
	.setCreativeTab(CreativeTabs.tabCombat);
	
	public static Block leavesLapis = new BlockLeavesLapis(201, Material.leaves, false)
	.setUnlocalizedName("leavesLapis")
	.setCreativeTab(CreativeTabs.tabDecorations);
	
	public static Block saplingLapis = new BlockSaplingLapis(202)
	.setUnlocalizedName("saplingLapis")
	.setCreativeTab(CreativeTabs.tabDecorations);
	
	public static Block tallGrassLapis = new BlockTallGrassLapis(203)
	.setUnlocalizedName("tallgrasslapis")
	.setCreativeTab(CreativeTabs.tabDecorations);
	
	public static Block vineLapis = new BlockVine(204, true)
	.setUnlocalizedName("vineLapis")
	.setCreativeTab(CreativeTabs.tabDecorations);
	
	BiomeGenBase lapisBiome = new BiomeGenLapis(31);

	@Override
	public int addFuel(int var1, int var2) {
		return super.addFuel(var1, var2);
	}
	
	@Override
	public void load() {
		ModLoader.registerBlock(leavesLapis);
		ModLoader.registerBlock(saplingLapis);
		ModLoader.registerBlock(tallGrassLapis);
		ModLoader.registerBlock(vineLapis);
		
		ModLoader.addName(stickLapis, "Lapis Rod");
		
		ModLoader.addName(shovelLapis, "Lapis Shovel");
		ModLoader.addName(swordLapis, "Lapis Sword");
		ModLoader.addName(pickaxeLapis, "Lapis Pickaxe");
		ModLoader.addName(axeLapis, "Lapis Axe");
		ModLoader.addName(hoeLapis, "Lapis Hoe");
		
		ModLoader.addName(leavesLapis, "Lapis Leaves");
		ModLoader.addName(saplingLapis, "Lapis Sapling");
		ModLoader.addName(tallGrassLapis, "Lapis Grass");
		ModLoader.addName(vineLapis, "Lapis Vines");
		
		ModLoader.addName(helmetLapis, "Lapis Helmet");
		ModLoader.addName(chestplateLapis, "Lapis Chestplate");
		ModLoader.addName(leggingsLapis, "Lapis Leggings");
		ModLoader.addName(bootsLapis, "Lapis Boots");
		
		ModLoader.addBiome(lapisBiome);

		ModLoader.addSpawn(EntityEnderpig.class, 3, 1, 3, EnumCreatureType.creature, new BiomeGenBase[]{lapisBiome});
		
		ModLoader.registerEntityID(EntityEnderpig.class, "Lapis Pig", 101, 0x0000FF, 0x00FFFF);
		
		ModLoader.addLocalization("entity.Lapis Pig.name", "Lapis Pig");
	}
	
	public void AddRenderer (Map map){
		map.put(EntityEnderpig.class, new RenderPig(new ModelPig(), new ModelPig(), 0.5F));
	}
}

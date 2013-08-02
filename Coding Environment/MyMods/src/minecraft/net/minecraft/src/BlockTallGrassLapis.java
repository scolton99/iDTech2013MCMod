package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockTallGrassLapis extends BlockTallGrass {

	public BlockTallGrassLapis(int par1) {
		super(par1);
	}

	private Icon[] grassIcon;

	public Icon getIcon(int par1, int par2)
	{
		return this.grassIcon[0];
	}

	public void registerIcons(IconRegister par1IconRegister)
	{
		/*this.iconArray = new Icon[grassTypes.length];

        for (int var2 = 0; var2 < this.iconArray.length; ++var2)
        {
            this.iconArray[var2] = par1IconRegister.registerIcon(grassTypes[var2]);
        }

		this.grassIcon = new Icon[1];

		this.grassIcon[0] = par1IconRegister.registerIcon("tallgrasslapis");
		*/
		this.grassIcon = new Icon[1];
		
		this.grassIcon[0] = par1IconRegister.registerIcon("tallgrasslapis");
	}

	@Override
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		return 0x0000ff;
	}
	
	@Override
	public int getRenderColor(int par1){
		return 0x0000ff;
	}
	
	@Override
	public int getBlockColor()
    {
        return 0x0000ff;
    }
	
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
	{
		if (!par1World.isRemote && par2EntityPlayer.getCurrentEquippedItem() != null && par2EntityPlayer.getCurrentEquippedItem().itemID == Item.shears.itemID)
		{
			par2EntityPlayer.addStat(StatList.mineBlockStatArray[this.blockID], 1);
			this.dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(Item.dyePowder, 1, 4));
		}
		else
		{
			super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
		}
	}
	
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(mod_LapisTools.tallGrassLapis.blockID, 1, 0));
	}
	
	public int getDamageValue(World par1World, int par2, int par3, int par4)
    {
        return 0;
    }
}

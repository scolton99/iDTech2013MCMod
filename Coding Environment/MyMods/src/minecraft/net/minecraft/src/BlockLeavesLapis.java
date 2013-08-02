package net.minecraft.src;

import java.util.Random;

public class BlockLeavesLapis extends BlockLeavesBase {
	
	public BlockLeavesLapis(int par1, Material par2Material, boolean par3){
		super(par1, Material.leaves, par3);
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setStepSound(soundGrassFootstep);
		this.setLightOpacity(1);
	}

	int[] adjacentTreeBlocks;
	private Icon[][] iconArray = new Icon[2][];
	int giraffics;
	boolean giraffics2;

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		byte var7 = 1;
		int var8 = var7 + 1;

		if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
		{
			for (int var9 = -var7; var9 <= var7; ++var9)
			{
				for (int var10 = -var7; var10 <= var7; ++var10)
				{
					for (int var11 = -var7; var11 <= var7; ++var11)
					{
						int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);

						if (var12 == mod_LapisTools.leavesLapis.blockID)
						{
							int var13 = par1World.getBlockMetadata(par2 + var9, par3 + var10, par4 + var11);
							par1World.setBlockMetadataWithNotify(par2 + var9, par3 + var10, par4 + var11, var13 | 8, 4);
						}
					}
				}
			}
		}
	}

	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4){
		return 0x0000ff;
	}
	
	public int getRenderColor(int par1){
		return 0x0000ff;
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			int var6 = par1World.getBlockMetadata(par2, par3, par4);

			if ((var6 & 8) != 0 && (var6 & 4) == 0)
			{
				byte var7 = 4;
				int var8 = var7 + 1;
				byte var9 = 32;
				int var10 = var9 * var9;
				int var11 = var9 / 2;

				if (this.adjacentTreeBlocks == null)
				{
					this.adjacentTreeBlocks = new int[var9 * var9 * var9];
				}

				int var12;

				if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
				{
					int var13;
					int var14;
					int var15;

					for (var12 = -var7; var12 <= var7; ++var12)
					{
						for (var13 = -var7; var13 <= var7; ++var13)
						{
							for (var14 = -var7; var14 <= var7; ++var14)
							{
								var15 = par1World.getBlockId(par2 + var12, par3 + var13, par4 + var14);

								if (var15 == Block.wood.blockID)
								{
									this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
								}
								else if (var15 == mod_LapisTools.leavesLapis.blockID)
								{
									this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
								}
								else
								{
									this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
								}
							}
						}
					}

					for (var12 = 1; var12 <= 4; ++var12)
					{
						for (var13 = -var7; var13 <= var7; ++var13)
						{
							for (var14 = -var7; var14 <= var7; ++var14)
							{
								for (var15 = -var7; var15 <= var7; ++var15)
								{
									if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1)
									{
										if (this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2)
										{
											this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2)
										{
											this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2)
										{
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2)
										{
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2)
										{
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2)
										{
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
										}
									}
								}
							}
						}
					}
				}

				var12 = this.adjacentTreeBlocks[var11 * var10 + var11 * var9 + var11];

				if (var12 >= 0)
				{
					par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 & -9, 4);
				}
				else
				{
					this.removeLeaves(par1World, par2, par3, par4);
				}
			}
		}
	}

	private void removeLeaves(World par1World, int par2, int par3, int par4)
	{
		this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
		par1World.setBlockToAir(par2, par3, par4);
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return mod_LapisTools.saplingLapis.blockID;
	}

	public Icon getIcon(int par1, int par2)
	{
		return iconArray[giraffics][0];
	}

	public void setGraphicsLevel(boolean par1){
		if(par1){
			this.giraffics = 0;
			this.giraffics2 = par1;
		}else{
			this.giraffics = 1;
			this.giraffics2 = par1;
		}
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
        /*for (int var2 = 0; var2 < field_94396_b.length; ++var2)
        {
            this.iconArray[var2] = new Icon[field_94396_b[var2].length];

            for (int var3 = 0; var3 < field_94396_b[var2].length; ++var3)
            {
                this.iconArray[var2][var3] = par1IconRegister.registerIcon(field_94396_b[var2][var3]);
            }
        }*/
		this.iconArray[0] = new Icon[1];
		this.iconArray[0][0] = par1IconRegister.registerIcon("leavesLapis");
    }
	
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        if (!par1World.isRemote && par2EntityPlayer.getCurrentEquippedItem() != null && par2EntityPlayer.getCurrentEquippedItem().itemID == Item.shears.itemID)
        {
            par2EntityPlayer.addStat(StatList.mineBlockStatArray[this.blockID], 1);
            this.dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(mod_LapisTools.leavesLapis.blockID, 1, 0));
        }
        else
        {
            super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
        }
    }
	
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        if (!par1World.isRemote)
        {
            int var8 = 20;

            if ((par5 & 3) == 3)
            {
                var8 = 40;
            }

            if (par7 > 0)
            {
                var8 -= 2 << par7;

                if (var8 < 10)
                {
                    var8 = 10;
                }
            }

            if (par1World.rand.nextInt(var8) == 0)
            {
                this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(mod_LapisTools.saplingLapis.blockID, 1, 0));
            }

            var8 = 200;

            if (par7 > 0)
            {
                var8 -= 10 << par7;

                if (var8 < 40)
                {
                    var8 = 40;
                }
            }
        }
    }
}

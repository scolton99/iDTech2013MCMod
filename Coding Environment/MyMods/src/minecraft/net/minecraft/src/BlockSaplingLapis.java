package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockSaplingLapis extends BlockSapling {

	Icon saplingIconLapis;
	public BlockSaplingLapis(int par1) {
		super(par1);
	}

	public void growTree(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		int var6 = par1World.getBlockMetadata(par2, par3, par4) & 3;
		Object var7 = null;
		int var8 = 0;
		int var9 = 0;
		boolean var10 = false;
		
		
		
		for (var8 = 0; var8 >= -1; --var8)
        {
            for (var9 = 0; var9 >= -1; --var9)
            {
                if (this.isSameSapling(par1World, par2 + var8, par3, par4 + var9, 3) && this.isSameSapling(par1World, par2 + var8 + 1, par3, par4 + var9, 3) && this.isSameSapling(par1World, par2 + var8, par3, par4 + var9 + 1, 3) && this.isSameSapling(par1World, par2 + var8 + 1, par3, par4 + var9 + 1, 3))
                {
                    var7 = new WorldGenHugeTrees(true, 10 + par5Random.nextInt(20), 3, 3, true);
                    var10 = true;
                    break;
                }
            }

            if (var7 != null)
            {
                break;
            }
        }

        if (var7 == null)
        {
            var9 = 0;
            var8 = 0;
            var7 = new WorldGenTrees(false, 4, 0, 0, false, true);
        }
		
		//if (par5Random.nextInt(10) == 0)
		//{
		//   var7 = new WorldGenBigTree(true);
		//}
        
		if (var10)
        {
            par1World.setBlock(par2 + var8, par3, par4 + var9, 0, 0, 4);
            par1World.setBlock(par2 + var8 + 1, par3, par4 + var9, 0, 0, 4);
            par1World.setBlock(par2 + var8, par3, par4 + var9 + 1, 0, 0, 4);
            par1World.setBlock(par2 + var8 + 1, par3, par4 + var9 + 1, 0, 0, 4);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, 0, 0, 4);
        }

        if (!((WorldGenerator)var7).generate(par1World, par5Random, par2 + var8, par3, par4 + var9))
        {
            if (var10)
            {
                par1World.setBlock(par2 + var8, par3, par4 + var9, this.blockID, var6, 4);
                par1World.setBlock(par2 + var8 + 1, par3, par4 + var9, this.blockID, var6, 4);
                par1World.setBlock(par2 + var8, par3, par4 + var9 + 1, this.blockID, var6, 4);
                par1World.setBlock(par2 + var8 + 1, par3, par4 + var9 + 1, this.blockID, var6, 4);
            }
            else
            {
                par1World.setBlock(par2, par3, par4, this.blockID, var6, 4);
            }
        }
	}
	
	public void registerIcons(IconRegister par1IconRegister)
    {
		this.saplingIconLapis = par1IconRegister.registerIcon("saplingLapis");
    }
	
	public Icon getIcon(int par1, int par2)
    {
        return this.saplingIconLapis;
    }
	
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }
	
	@Override
	public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5)
    {
		if(par1World.getBlockId(par2, par3, par4) == this.blockID){
			return true;
		}else{
			return false;
		}
    }
}

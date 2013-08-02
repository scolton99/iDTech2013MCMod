package net.minecraft.src;

public class ItemSneakers extends Item {
	protected ItemSneakers(int par1){
		super(par1);
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		if(entityplayer.onGround == true){
		do{
			entityplayer.motionX *= 7.5D;
			entityplayer.motionZ *= 7.5D;
		}while(Math.abs(entityplayer.motionX) + Math.abs(entityplayer.motionZ) <= 2.0D && entityplayer.getItemInUse() == new ItemStack(mod_Sneakers.sneakers, 1) && entityplayer.onGround == true);
		}
		return itemstack;
	}
}

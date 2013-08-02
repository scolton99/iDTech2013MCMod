package net.minecraft.src;

public class ItemJetpack extends Item {
	public ItemJetpack(int par1){
		super(par1);
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		entityplayer.motionY+=1;
		entityplayer.isJetpack = true;
		if(Math.abs(entityplayer.motionX) + Math.abs(entityplayer.motionZ) <= 3.0){
			entityplayer.motionX *=1.25D;
			entityplayer.motionZ *=1.25D;
		}
		return itemstack;
	}
}

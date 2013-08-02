package net.minecraft.src;

public class ItemFlyingSneakers extends ItemSneakers {
	public ItemFlyingSneakers(int par1){
		super(par1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		if(entityplayer.onGround == false){
			/*float yaw;
			boolean yawIsNeg;
			double changz, changx;
			do{
				yaw = entityplayer.getRotationYawHead()%360;

				if(yaw > 0){
					yawIsNeg = false;
				}else{
					yawIsNeg = true;
				}

				if(yawIsNeg && yaw < 0){
					if(0 < Math.abs(yaw) && Math.abs(yaw) < 90){
						if(0 < Math.abs(yaw) && Math.abs(yaw) <= 45){
							changx = Math.sin(Math.abs(yaw));
							changz = Math.cos(Math.abs(yaw));
							entityplayer.motionX -= changx;
							entityplayer.motionZ += changz;
						}else{
							changx = Math.cos(90-Math.abs(yaw));
							changz = Math.sin(90-Math.abs(yaw));
							entityplayer.motionX -= changx;
							entityplayer.motionZ += changz;
						}
					}
					if(90 < Math.abs(yaw) && Math.abs(yaw) < 180){
						if(90 < Math.abs(yaw) && Math.abs(yaw) <= 135){
							changx = Math.cos(Math.abs(yaw)-90);
							changz = Math.sin(Math.abs(yaw)-90);
							entityplayer.motionX -=changx;
							entityplayer.motionZ -=changz;
						}else{
							changx = Math.sin(180-Math.abs(yaw));
							changz = Math.cos(180-Math.abs(yaw));
							entityplayer.motionX -=changx;
							entityplayer.motionZ -=changz;
						}
					}
					if(180 < Math.abs(yaw) && Math.abs(yaw) < 270){
						if(180 < Math.abs(yaw) && Math.abs(yaw) <= 225){
							changx = Math.sin(Math.abs(yaw)-180);
							changz = Math.cos(Math.abs(yaw)-180);
							entityplayer.motionX +=changx;
							entityplayer.motionZ -=changz;
						}else{
							changx = Math.cos(Math.abs(270-yaw));
							changz = Math.sin(Math.abs(270-yaw));
							entityplayer.motionX +=changx;
							entityplayer.motionZ -=changz;
						}
					}
					if(270 < Math.abs(yaw) && Math.abs(yaw) < 360){
						if(270 < Math.abs(yaw) && Math.abs(yaw) <= 315){
							changx = Math.cos(Math.abs(yaw)-270);
							changz = Math.sin(Math.abs(yaw)-270);
							entityplayer.motionX +=changx;
							entityplayer.motionZ +=changz;
						}else{
							changx = Math.sin(Math.abs(360-yaw));
							changz = Math.cos(Math.abs(360-yaw));
							entityplayer.motionX +=changx;
							entityplayer.motionZ +=changz;
						}
					}
				}else{ // Yawisneg
					if(0 < Math.abs(yaw) && Math.abs(yaw) < 90){
						if(0 < Math.abs(yaw) && Math.abs(yaw) <= 45){
							changx = Math.sin(Math.abs(yaw));
							changz = Math.cos(Math.abs(yaw));
							entityplayer.motionX += changx;
							entityplayer.motionZ += changz;
						}else{
							changx = Math.cos(90-Math.abs(yaw));
							changz = Math.sin(90-Math.abs(yaw));
							entityplayer.motionX += changx;
							entityplayer.motionZ += changz;
						}
					}
					if(90 < Math.abs(yaw) && Math.abs(yaw) < 180){
						if(90 < Math.abs(yaw) && Math.abs(yaw) <= 135){
							changx = Math.sin(90-Math.abs(yaw));
							changz = Math.cos(90-Math.abs(yaw));
							entityplayer.motionX -=changx;
							entityplayer.motionZ +=changz;
						}else{
							changx = Math.cos(180-Math.abs(yaw));
							changz = Math.sin(180-Math.abs(yaw));
							entityplayer.motionX -=changx;
							entityplayer.motionZ +=changz;
						}
					}
					if(180 < Math.abs(yaw) && Math.abs(yaw) < 270){
						if(180 < Math.abs(yaw) && Math.abs(yaw) <= 225){
							changx = Math.sin(180-Math.abs(yaw));
							changz = Math.cos(180-Math.abs(yaw));
							entityplayer.motionX +=changx;
							entityplayer.motionZ +=changz;
						}else{
							changx = Math.cos(270-Math.abs(yaw));
							changz = Math.sin(270-Math.abs(yaw));
							entityplayer.motionX +=changx;
							entityplayer.motionZ +=changz;
						}
					}
					if(270 < Math.abs(yaw) && Math.abs(yaw) < 360){
						if(270 < Math.abs(yaw) && Math.abs(yaw) <= 315){
							changx = Math.cos(270-Math.abs(yaw));
							changz = Math.sin(270-Math.abs(yaw));
							entityplayer.motionX +=changx;
							entityplayer.motionZ -=changz;
						}else{
							changx = Math.sin(360-Math.abs(yaw));
							changz = Math.cos(360-Math.abs(yaw));
							entityplayer.motionX +=changx;
							entityplayer.motionZ -=changz;
						}
					}

				}
			}while(Math.abs(entityplayer.motionX) + Math.abs(entityplayer.motionZ) <= 3.0D && entityplayer.getItemInUse() == new ItemStack(mod_Sneakers.sneakers, 1));
			 */	
			if(Math.abs(entityplayer.motionX) + Math.abs(entityplayer.motionZ) <= 3.0){
				entityplayer.motionX *=1.25D;
				entityplayer.motionZ *=1.25D;
			}
			
		}
		return itemstack;
	}
}

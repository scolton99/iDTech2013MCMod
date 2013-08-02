package net.minecraft.src;

import java.util.Calendar;
import java.util.Random;
import java.util.List;

public class EntityEnderpig extends EntityPig {

	private boolean telebool;
	
	public EntityEnderpig(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
		this.texture = "/mob/enderpig.png";
		this.moveSpeed = 0.23F;
		this.tasks.addTask(3, new EntityAIMate(this, 0.23F));
	}

	@Override
	public int getMaxHealth() {
		// TODO Auto-generated method stub
		return 20;
	}

	public void onLivingUpdate()
	{
		if(worldObj.isDaytime() && !worldObj.isRemote)
		{
			float f = this.getBrightness(1.0F);
			if(f > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)))
			{
				
			}
	
		}
		super.onLivingUpdate();
	}
	
	public EntityItem dropItemWithOffset(int par1, int par2, float par3)
    {
        return this.entityDropItem(new ItemStack(Item.dyePowder.itemID, 1, 4), par3);
    }
	
	protected String getLivingSound(){
		return "mob.endermen.scream";
	}
	
	protected String getHurtSound(){
		return "mob.enderman.hit";
	}
	
	protected String getDeathSound(){
		return "mob.endermen.death";
	}
	
	protected boolean teleportRandomly()
    {
        double var1 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
        double var3 = this.posY + (double)(this.rand.nextInt(64) - 32);
        double var5 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
        return this.teleportTo(var1, var3, var5);
    }
	
	protected boolean teleportTo(double par1, double par3, double par5)
    {
        double var7 = this.posX;
        double var9 = this.posY;
        double var11 = this.posZ;
        this.posX = par1;
        this.posY = par3;
        this.posZ = par5;
        boolean var13 = false;
        int var14 = MathHelper.floor_double(this.posX);
        int var15 = MathHelper.floor_double(this.posY);
        int var16 = MathHelper.floor_double(this.posZ);
        int var18;

        if (this.worldObj.blockExists(var14, var15, var16))
        {
            boolean var17 = false;

            while (!var17 && var15 > 0)
            {
                var18 = this.worldObj.getBlockId(var14, var15 - 1, var16);

                if (var18 != 0 && Block.blocksList[var18].blockMaterial.blocksMovement())
                {
                    var17 = true;
                }
                else
                {
                    --this.posY;
                    --var15;
                }
            }

            if (var17)
            {
                this.setPosition(this.posX, this.posY, this.posZ);

                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
                {
                    var13 = true;
                }
            }
        }

        if (!var13)
        {
            this.setPosition(var7, var9, var11);
            return false;
        }
        else
        {
            short var30 = 128;

            for (var18 = 0; var18 < var30; ++var18)
            {
                double var19 = (double)var18 / ((double)var30 - 1.0D);
                float var21 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float var22 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float var23 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                double var24 = var7 + (this.posX - var7) * var19 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                double var26 = var9 + (this.posY - var9) * var19 + this.rand.nextDouble() * (double)this.height;
                double var28 = var11 + (this.posZ - var11) * var19 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                this.worldObj.spawnParticle("portal", var24, var26, var28, (double)var21, (double)var22, (double)var23);
            }

            this.worldObj.playSoundEffect(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
            this.playSound("mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }
	
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		Random rand = new Random();
		if(rand.nextInt(65) <= 33){
			int var3 = 0;
			while(var3 < 64){
				var3++;
				return this.teleportRandomly() ? true : false;
			}
			return false;
		}
		else
		{
			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}
	
	public EntityEnderpig spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityEnderpig(this.worldObj);
    }
}

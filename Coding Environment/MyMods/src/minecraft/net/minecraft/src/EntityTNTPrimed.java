package net.minecraft.src;

public class EntityTNTPrimed extends Entity
{
	/** How long the fuse is */
	public int fuse;
	private EntityLiving tntPlacedBy;
	private boolean quickTNT;

	public EntityTNTPrimed(World par1World)
	{
		super(par1World);
		this.fuse = 0;
		this.preventEntitySpawning = true;
		this.setSize(0.98F, 0.98F);
		this.yOffset = this.height / 2.0F;
	}
	
	public EntityTNTPrimed(World par1World, double par2, double par4, double par6, EntityLiving par8EntityLiving)
	{
		this(par1World);
		this.setPosition(par2, par4, par6);
		float var9 = (float)(Math.random() * Math.PI * 2.0D);
		this.motionX = (double)(-((float)Math.sin((double)var9)) * 0.02F);
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double)(-((float)Math.cos((double)var9)) * 0.02F);
		this.fuse = 80;
		this.prevPosX = par2;
		this.prevPosY = par4;
		this.prevPosZ = par6;
		this.tntPlacedBy = par8EntityLiving;
	}

	public EntityTNTPrimed(World par1World, double par2, double par4, double par6, EntityLiving par8EntityLiving, boolean isQuick)
	{
		this(par1World);
		this.setPosition(par2, par4, par6);
		float var9 = (float)(Math.random() * Math.PI * 2.0D);
		this.motionX = (double)(-((float)Math.sin((double)var9)) * 0.02F);
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double)(-((float)Math.cos((double)var9)) * 0.02F);
		this.fuse = 1;
		this.quickTNT = true;
		this.prevPosX = par2;
		this.prevPosY = par4;
		this.prevPosZ = par6;
		this.tntPlacedBy = par8EntityLiving;
	}

	protected void entityInit() {}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	 * prevent them from trampling crops
	 */
	protected boolean canTriggerWalking()
	{
		return false;
	}

	/**
	 * Returns true if other Entities should be prevented from moving through this Entity.
	 */
	public boolean canBeCollidedWith()
	{
		return !this.isDead;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= 0.03999999910593033D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;

		if (this.onGround)
		{
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}

		if (this.fuse-- <= 0)
		{
			this.setDead();

			if (!this.worldObj.isRemote)
			{
				this.explode();
			}
		}
		else
		{
			for(int x = 0; x <= 5; x++){
				this.worldObj.spawnParticle("heart", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	private void explode()
	{
		float var1 = 3.0F;
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, var1, true);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		par1NBTTagCompound.setByte("Fuse", (byte)this.fuse);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		this.fuse = par1NBTTagCompound.getByte("Fuse");
	}

	public float getShadowSize()
	{
		return 0.0F;
	}

	/**
	 * returns null or the entityliving it was placed or ignited by
	 */
	public EntityLiving getTntPlacedBy()
	{
		return this.tntPlacedBy;
	}
}

package net.minecraft.src;

public class CommandChickens extends CommandBase {

	public CommandChickens() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "chickens";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		// TODO Auto-generated method stub
		System.out.println("Chickens!");
		EntityPlayerMP thisPlayer = this.getCommandSenderAsPlayer(var1);
		for(int i = 1; i<=500; i++){
			EntityChicken chicken = new EntityChicken(thisPlayer.worldObj);
			chicken.setLocationAndAngles(thisPlayer.posX, thisPlayer.posY, thisPlayer.posZ, thisPlayer.rotationYaw, 0.0f);
			thisPlayer.worldObj.spawnEntityInWorld(chicken);
		}
	}
	public int getRequiredPermissionLevel()
    {
        return 0;
    }

	public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "/chickens";
    }
}

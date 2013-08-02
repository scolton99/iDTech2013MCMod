package net.minecraft.src;

public class CommandExplode extends CommandBase {

	public CommandExplode() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "explode";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		// TODO Auto-generated method stub
		EntityPlayerMP thisPlayer = this.getCommandSenderAsPlayer(var1);
		if(var2.length > 0){
			thisPlayer.worldObj.createExplosion(thisPlayer, thisPlayer.posX, thisPlayer.posY, thisPlayer.posZ, Float.parseFloat(var2[0]), true);
			var1.sendChatToPlayer("Exploded with power of " + var2[0] + ".");
		}else{
			thisPlayer.worldObj.createExplosion(thisPlayer, thisPlayer.posX, thisPlayer.posY, thisPlayer.posZ, 4.0F, true);
			var1.sendChatToPlayer("Exploded with power of 1.");
		}
	}
	
	public int getRequiredPermissionLevel()
    {
        return 0;
    }

	public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "/explode <strength>";
    }
}

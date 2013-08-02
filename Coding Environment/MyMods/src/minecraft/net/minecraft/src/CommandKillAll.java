package net.minecraft.src;

import java.util.List;

public class CommandKillAll extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "killall";
	}
	
	public int getRequiredPermissionLevel(){
		return 0;
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		// TODO Auto-generated method stub
		EntityPlayerMP var3 = getCommandSenderAsPlayer(var1);
		List entities = var3.worldObj.loadedEntityList;
		boolean isEmpty = false;
		for(int var4 = 0; var4 < entities.size(); var4++){
			Entity curentity = (Entity) entities.get(var4);
			if(!(curentity instanceof EntityPlayer)){
				curentity.attackEntityFrom(DamageSource.outOfWorld, 1000);
			}
		}
		
	}

}

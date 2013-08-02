package net.minecraft.src;

import java.util.Map;

public class mod_Cars extends BaseMod {

	public mod_Cars() {
		// TODO Auto-generated constructor stub
	}

	public static Item car = new ItemMinecart(205, 6)
	.setUnlocalizedName("car")
	.setCreativeTab(CreativeTabs.tabTransport);
	
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "Version 1.0";
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		ModLoader.addName(car, "Car");
	}

	public void AddRenderer (Map map){
		map.put(EntityCar.class, new RenderCar());
	}
}

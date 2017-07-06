package com.IntegralPhysics.IntegralPhysics;

import com.IntegralPhysics.IntegralPhysics.Client.IPTab;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = IntegralPhysics.MODID, version = IntegralPhysics.VERSION, name = IntegralPhysics.NAME)
public class IntegralPhysics {

	public static final String MODID = "integralphysics";
	public static final String VERSION = "1.0";
	public static final String NAME = "Integral Physics";
	
	
	public static final IPTab TAB = new IPTab("Integral Physics");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}

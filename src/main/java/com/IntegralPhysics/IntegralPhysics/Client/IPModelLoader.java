package com.IntegralPhysics.IntegralPhysics.Client;

import com.IntegralPhysics.IntegralPhysics.IntegralPhysics;
import com.IntegralPhysics.IntegralPhysics.Client.Models.WireIModel;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class IPModelLoader implements ICustomModelLoader{
	
	@Override
	public void onResourceManagerReload(IResourceManager rm){
		
	}
	
	@Override
	public boolean accepts(ResourceLocation loc){
		return loc.getResourceDomain().equals(IntegralPhysics.MODID) &&
				loc.getResourcePath().contains("wire");
	}
	
	@Override
	public IModel loadModel(ResourceLocation loc) throws Exception{
		if(loc.getResourcePath().contains("wire"))
			return new WireIModel();
		
		return null;
	}

}

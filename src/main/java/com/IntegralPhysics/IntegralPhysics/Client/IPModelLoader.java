package com.IntegralPhysics.IntegralPhysics.Client;

import java.util.HashMap;
import java.util.List;

import com.IntegralPhysics.IntegralPhysics.IntegralPhysics;
import com.google.common.collect.Maps;

import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class IPModelLoader implements ICustomModelLoader{
	
	public static HashMap<String,List<BakedQuad>> cache = Maps.newHashMap();
	
	@Override
	public void onResourceManagerReload(IResourceManager rm){
		cache.clear();
	}
	
	@Override
	public boolean accepts(ResourceLocation loc){
		return loc.getResourceDomain().equals(IntegralPhysics.MODID) &&
				loc.getResourcePath().contains("wire");
	}
	
	@Override
	public IModel loadModel(ResourceLocation loc) throws Exception{
		
		return null;
	}

}

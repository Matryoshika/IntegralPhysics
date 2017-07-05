package com.IntegralPhysics.IntegralPhysics.Client;

import com.IntegralPhysics.IntegralPhysics.IntegralPhysics;
import com.IntegralPhysics.IntegralPhysics.Common.IPRegistry;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@EventBusSubscriber
public class IPModelRegistry {
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event){
		OBJLoader.INSTANCE.addDomain(IntegralPhysics.MODID);
		
		for(Block block : IPRegistry.blocks)
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

}

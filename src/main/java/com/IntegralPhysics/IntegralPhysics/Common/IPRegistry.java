package com.IntegralPhysics.IntegralPhysics.Common;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.BlockSteamTurbine;
import com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.IMetaBlock;
import com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.ItemBlockMeta;
import com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.Wiring.BlockWire;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class IPRegistry {
	
	public static Block TURBINE;
	public static Block WIRE;
	
	public static Set<Block> blocks = new HashSet<Block>();
	public static Set<Item> items = new HashSet<Item>();
	
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event){
		blocks.add(TURBINE = new BlockSteamTurbine());
		blocks.add(WIRE = new BlockWire());
		blocks.forEach(event.getRegistry()::register);
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event){
		blocks.stream().map(block -> getIb(block)).collect(Collectors.toList()).forEach(event.getRegistry()::register);
	}
	
	public static ItemBlock getIb(Block block){
		return block instanceof IMetaBlock ? 
			(ItemBlock) new ItemBlockMeta(block).setRegistryName(block.getRegistryName()) : 
			(ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
	}

}

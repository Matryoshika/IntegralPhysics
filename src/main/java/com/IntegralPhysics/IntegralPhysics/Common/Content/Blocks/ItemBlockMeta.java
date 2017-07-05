package com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMeta extends ItemBlock{
	
	public ItemBlockMeta(Block block){
		super(block);
		if(!(block instanceof IMetaBlock))
			throw new IllegalArgumentException(String.format("The given Block %s is not an instance of IMetaBlock!", block.getRegistryName().toString()));
		
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	public int getMetadata(int damage){
		return damage;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		return super.getUnlocalizedName(stack) + "_" +  ((IMetaBlock)this.block).getDerivedName(stack);
	}

}

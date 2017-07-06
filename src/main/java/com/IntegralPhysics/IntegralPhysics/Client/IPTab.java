package com.IntegralPhysics.IntegralPhysics.Client;

import com.IntegralPhysics.IntegralPhysics.Common.IPRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IPTab extends CreativeTabs{
	
	public IPTab(String label){
		super(label);
	}
	
	@Override
	public Item getTabIconItem(){
		return Item.getItemFromBlock(IPRegistry.TURBINE);
	}
	
	@Override
	public String getTranslatedTabLabel(){
		return getTabLabel();
	}

}

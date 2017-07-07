package com.IntegralPhysics.IntegralPhysics.Common.Content.Items;

import com.IntegralPhysics.IntegralPhysics.IntegralPhysics;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemDebugger extends Item{
	
	public ItemDebugger(){
		setRegistryName(IntegralPhysics.MODID, "debugger");
		setUnlocalizedName(getRegistryName().toString());
		setCreativeTab(IntegralPhysics.TAB);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        System.out.println(world.getBlockState(pos));
		
		return EnumActionResult.PASS;
    }

}

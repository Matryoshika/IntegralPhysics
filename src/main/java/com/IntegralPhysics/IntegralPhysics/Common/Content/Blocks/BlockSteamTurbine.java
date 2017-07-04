package com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks;

import java.util.List;

import com.IntegralPhysics.IntegralPhysics.IntegralPhysics;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSteamTurbine extends Block{
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumType.class);

	public BlockSteamTurbine() {
		super(Material.IRON);
		setRegistryName(IntegralPhysics.MODID,"steam_turbine");
		setUnlocalizedName(getRegistryName().toString());
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.BLADE));
	}
	
	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, new IProperty[]{TYPE});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta){
		//Defaults to blade as that is the cheapest variation, in case of metadata voiding
		return getDefaultState().withProperty(TYPE, meta == 0 ? EnumType.MAIN : meta == 1 ? EnumType.SHAFT : EnumType.BLADE);
	}
	
	@Override
	public int getMetaFromState(IBlockState state){
		EnumType type = (EnumType) state.getValue(TYPE);
		return type.getID();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
	    return getMetaFromState(state);
	}
	
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
		for(EnumType en : EnumType.values()){
			list.add(new ItemStack(itemIn, 1, en.getID()));
		}
	}
	
	
	public enum EnumType implements IStringSerializable {
	    MAIN(0, "main"),
	    SHAFT(1, "shaft"),
	    BLADE(2, "blade");

	    private int ID;
	    private String name;
	    
	    private EnumType(int ID, String name) {
	        this.ID = ID;
	        this.name = name;
	    }
	    
	    @Override
	    public String getName() {
	        return name;
	    }

	    public int getID() {
	        return ID;
	    }
	    
	    @Override
	    public String toString() {
	        return getName();
	    }
	}

}

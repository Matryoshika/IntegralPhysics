package com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.Wiring;

import java.util.HashMap;
import java.util.List;

import com.IntegralPhysics.IntegralPhysics.IntegralPhysics;
import com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.IMetaBlock;
import com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.BlockSteamTurbine.EnumType;
import com.IntegralPhysics.IntegralPhysics.Common.Utils.IPEnums.Axii;
import com.IntegralPhysics.IntegralPhysics.Common.Utils.IPEnums.Conducters;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog.EnumAxis;
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
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWire extends Block implements IMetaBlock {

	// Measured in m³
	private final double cableVolume = 0.023235;
	// Measured in cm
	private final double cableRadius = 8.6;
	private final Conducters baseMaterial;
	
	public static final PropertyEnum AXII = PropertyEnum.create("axii", Axii.class);
	
	public final int[][] neighbours = new int[][]{{0,1,0},{0,-1,0},{1,0,0},{-1,0,0},{0,0,1},{0,0,-1}};
	

	public BlockWire(Conducters material) {
		super(Material.IRON);
		baseMaterial = material;
	}

	public double getResistance() {
		return (baseMaterial.getResistance() * 1) / (Math.PI * (cableRadius * cableRadius));
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		IBlockState placed = getDefaultState().withProperty(AXII, Axii.NONE);
		
		if(getTowards(EnumFacing.UP, world, pos)){
			if(getTowards(EnumFacing.WEST, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.UP_LEFT);
			else if(getTowards(EnumFacing.EAST, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.UP_RIGHT);
			else if(getTowards(EnumFacing.NORTH, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.UP_FRONT);
			else if(getTowards(EnumFacing.SOUTH, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.UP_BACK);
			else if(getTowards(EnumFacing.DOWN, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.UP_DOWN);
			else
				placed = getDefaultState().withProperty(AXII, Axii.UP_DOWN);
		}
		else if(getTowards(EnumFacing.WEST, world, pos)){
			if(getTowards(EnumFacing.EAST, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.LEFT_RIGHT);
			else if(getTowards(EnumFacing.NORTH, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.LEFT_FRONT);
			else if(getTowards(EnumFacing.SOUTH, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.LEFT_BACK);
			else if(getTowards(EnumFacing.DOWN, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.LEFT_DOWN);
			else
				placed = getDefaultState().withProperty(AXII, Axii.LEFT_RIGHT);
		}
		else if(getTowards(EnumFacing.EAST, world, pos)){
			if(getTowards(EnumFacing.NORTH, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.RIGHT_FRONT);
			else if(getTowards(EnumFacing.SOUTH, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.RIGHT_BACK);
			else if(getTowards(EnumFacing.DOWN, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.RIGHT_DOWN);
			else
				placed = getDefaultState().withProperty(AXII, Axii.LEFT_RIGHT);
		}
		else if(getTowards(EnumFacing.SOUTH, world, pos)){
			if(getTowards(EnumFacing.DOWN, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.BACK_DOWN);
			else if(getTowards(EnumFacing.NORTH, world, pos))
				placed = getDefaultState().withProperty(AXII, Axii.BACK_FRONT);
			else
				placed = getDefaultState().withProperty(AXII, Axii.BACK_FRONT);
		}
		
		else if(getTowards(EnumFacing.DOWN, world, pos) && getTowards(EnumFacing.NORTH, world, pos))
			placed = getDefaultState().withProperty(AXII, Axii.DOWN_FRONT);
		
		return placed;
	}
	
	public boolean getTowards(EnumFacing facing, World world, BlockPos pos){
		return world.getBlockState(pos.offset(facing)).getBlock() instanceof BlockWire && ((BlockWire)world.getBlockState(pos.offset(EnumFacing.UP)).getBlock()).baseMaterial == this.baseMaterial;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {});
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch(meta){
		case 0: return getDefaultState().withProperty(AXII, Axii.UP_LEFT);
		case 1: return getDefaultState().withProperty(AXII, Axii.UP_RIGHT);
		case 2: return getDefaultState().withProperty(AXII, Axii.UP_FRONT);
		case 3: return getDefaultState().withProperty(AXII, Axii.UP_BACK);
		case 4: return getDefaultState().withProperty(AXII, Axii.UP_DOWN);
		
		case 5: return getDefaultState().withProperty(AXII, Axii.LEFT_RIGHT);
		case 6: return getDefaultState().withProperty(AXII, Axii.LEFT_FRONT);
		case 7: return getDefaultState().withProperty(AXII, Axii.LEFT_BACK);
		case 8: return getDefaultState().withProperty(AXII, Axii.LEFT_DOWN);
		
		case 9: return getDefaultState().withProperty(AXII, Axii.RIGHT_FRONT);
		case 10: return getDefaultState().withProperty(AXII, Axii.RIGHT_BACK);
		case 11: return getDefaultState().withProperty(AXII, Axii.RIGHT_DOWN);
		
		case 12: return getDefaultState().withProperty(AXII, Axii.BACK_DOWN);
		case 13: return getDefaultState().withProperty(AXII, Axii.BACK_FRONT);
		
		case 14: return getDefaultState().withProperty(AXII, Axii.DOWN_FRONT);
		
		case 15: return getDefaultState().withProperty(AXII, Axii.NONE);
		default: return getDefaultState().withProperty(AXII, Axii.NONE);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		Axii axii = (Axii) state.getValue(AXII);
		return axii.getID();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public String getDerivedName(ItemStack stack) {
		return baseMaterial.getName();
	}

}

package com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.Wiring;

import java.util.List;

import com.IntegralPhysics.IntegralPhysics.IntegralPhysics;
import com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.IMetaBlock;
import com.IntegralPhysics.IntegralPhysics.Common.Utils.IPEnums.Conducters;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockWire extends Block implements IMetaBlock{

	// Measured in m³
	private final double cableVolume = 0.023235;
	// Measured in cm
	private final double cableRadius = 8.6;
	public static final PropertyEnum TYPE = PropertyEnum.create("type", Conducters.class);

	public BlockWire() {
		super(Material.IRON);
		setRegistryName(IntegralPhysics.MODID, "cable");
		setUnlocalizedName(getRegistryName().toString());
		setCreativeTab(IntegralPhysics.TAB);

		setDefaultState(blockState.getBaseState().withProperty(TYPE, Conducters.ALUMINUM));
	}
	
	public double getResistance(IBlockState state){
		Conducters type = (Conducters) state.getValue(TYPE);
		return (type.getResistance() * 1) / (Math.PI * (cableRadius * cableRadius));
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
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, new IProperty[]{TYPE});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta){
		return getDefaultState().withProperty(TYPE,
				meta == 3 ? Conducters.SUPER : 
					meta == 2 ? Conducters.SILVER : 
						meta == 1 ? Conducters.COPPER : 
							meta == 0 ? Conducters.ALUMINUM : 
								Conducters.ALUMINUM);
	}
	
	@Override
	public int getMetaFromState(IBlockState state){
		Conducters type = (Conducters) state.getValue(TYPE);
		return type.getID();
	}
	
	@Override
	public int damageDropped(IBlockState state){
		return getMetaFromState(state);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list){
		for(Conducters cond : Conducters.values())
			list.add(new ItemStack(item, 1, cond.getID()));
	}

	@Override
	public String getDerivedName(ItemStack stack) {
		switch (stack.getMetadata()){
		case 0: return Conducters.ALUMINUM.getName().toLowerCase();
		case 1: return Conducters.COPPER.getName().toLowerCase();
		case 2: return Conducters.SILVER.getName().toLowerCase();
		case 3: return Conducters.SUPER.getName().toLowerCase();
		default: return Conducters.ALUMINUM.getName().toLowerCase();
		}
	}

}

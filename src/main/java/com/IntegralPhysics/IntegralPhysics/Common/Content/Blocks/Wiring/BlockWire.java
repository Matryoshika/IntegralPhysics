package com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.Wiring;

import com.IntegralPhysics.IntegralPhysics.Common.Utils.IPEnums.Conducters;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class BlockWire extends BlockAbstractWire{

	public BlockWire(Conducters material) {
		super(material);
	}
	
	@Override
	protected BlockStateContainer createBlockState(){
		return new BlockStateContainer(this, CONNECTED_PROPERTIES.toArray(new IProperty[CONNECTED_PROPERTIES.size()]));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta){
		return getDefaultState();
	}
	
	@Override
	public int getMetaFromState(IBlockState state){
		return 0;
	}

}

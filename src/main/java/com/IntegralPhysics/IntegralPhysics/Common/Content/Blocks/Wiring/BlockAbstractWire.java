package com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.Wiring;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.IntegralPhysics.IntegralPhysics.IntegralPhysics;
import com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.IMetaBlock;
import com.IntegralPhysics.IntegralPhysics.Common.Utils.IPEnums.Conducters;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockAbstractWire extends Block implements IMetaBlock {

	public static final float PIPE_MIN_POS = 0.25f;
	public static final float PIPE_MAX_POS = 0.75f;

	public static final ImmutableList<IProperty<Boolean>> CONNECTED_PROPERTIES = ImmutableList.copyOf(Stream
			.of(EnumFacing.VALUES).map(facing -> PropertyBool.create(facing.getName())).collect(Collectors.toList()));

	public static final ImmutableList<AxisAlignedBB> CONNECTED_BOUNDING_BOXES = ImmutableList
			.copyOf(Stream.of(EnumFacing.VALUES).map(facing -> {
				Vec3i directionVec = facing.getDirectionVec();
				return new AxisAlignedBB(getMinBound(directionVec.getX()), getMinBound(directionVec.getY()),
						getMinBound(directionVec.getZ()), getMaxBound(directionVec.getX()),
						getMaxBound(directionVec.getY()), getMaxBound(directionVec.getZ()));
			}).collect(Collectors.toList()));
	
	public final Conducters wireMaterial;

	public BlockAbstractWire(Conducters material) {
		super(Material.IRON);
		setRegistryName(IntegralPhysics.MODID, "wire_"+material.getName().toLowerCase());
		setUnlocalizedName(getRegistryName().toString());

		setCreativeTab(IntegralPhysics.TAB);

		setHardness(1.0f);
		wireMaterial = material;
	}

	private static float getMinBound(int dir) {
		return dir == -1 ? 0 : PIPE_MIN_POS;
	}

	private static float getMaxBound(int dir) {
		return dir == 1 ? 1 : PIPE_MAX_POS;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	protected boolean isValidConnection(IBlockState ownState, IBlockState neighbourState, IBlockAccess world,
			BlockPos ownPos, EnumFacing neighbourDirection) {
		return neighbourState.getBlock() instanceof BlockAbstractWire && ((BlockAbstractWire)neighbourState.getBlock()).wireMaterial == wireMaterial;
	}

	private boolean canConnectTo(IBlockState ownState, IBlockAccess worldIn, BlockPos ownPos,
			EnumFacing neighbourDirection) {
		final BlockPos neighbourPos = ownPos.offset(neighbourDirection);
		final IBlockState neighbourState = worldIn.getBlockState(neighbourPos);
		final Block neighbourBlock = neighbourState.getBlock();

		final boolean neighbourIsValidForThis = isValidConnection(ownState, neighbourState, worldIn, ownPos,
				neighbourDirection);
		final boolean thisIsValidForNeighbour = !(neighbourBlock instanceof BlockAbstractWire) || ((BlockAbstractWire) neighbourBlock)
				.isValidConnection(neighbourState, ownState, worldIn, neighbourPos, neighbourDirection.getOpposite());

		return neighbourIsValidForThis && thisIsValidForNeighbour;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		for (final EnumFacing facing : EnumFacing.VALUES)
			state = state.withProperty(CONNECTED_PROPERTIES.get(facing.getIndex()),
					canConnectTo(state, world, pos, facing));

		return state;
	}

	public final boolean isConnected(IBlockState state, EnumFacing facing) {
		return state.getValue(CONNECTED_PROPERTIES.get(facing.getIndex()));
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB mask,
			List<AxisAlignedBB> list, @Nullable Entity collidingEntity) {
		final AxisAlignedBB bb = new AxisAlignedBB(PIPE_MIN_POS, PIPE_MIN_POS, PIPE_MIN_POS, PIPE_MAX_POS, PIPE_MAX_POS,
				PIPE_MAX_POS);
		addCollisionBoxToList(pos, mask, list, bb);

		state = getActualState(state, worldIn, pos);

		for (final EnumFacing facing : EnumFacing.VALUES) {
			if (isConnected(state, facing)) {
				final AxisAlignedBB axisAlignedBB = CONNECTED_BOUNDING_BOXES.get(facing.getIndex());
				addCollisionBoxToList(pos, mask, list, axisAlignedBB);
			}
		}
	}

	@Override
	public String getDerivedName(ItemStack stack) {
		return wireMaterial.getName().toLowerCase();
	}

}

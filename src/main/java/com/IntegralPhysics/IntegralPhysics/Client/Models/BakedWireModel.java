package com.IntegralPhysics.IntegralPhysics.Client.Models;

import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IPerspectiveAwareModel;

public class BakedWireModel implements IPerspectiveAwareModel{

	@Override
	public List<BakedQuad> getQuads(IBlockState someState, EnumFacing side, long rand){
		
		
		
		
		
		
		return ImmutableList.of();
	}
	
	@Override
	public boolean isAmbientOcclusion(){
		return false;
	}
	
	@Override
	public boolean isGui3d(){
		return true;
	}
	
	@Override
	public boolean isBuiltInRenderer(){
		return false;
	}
	
	@Override
	public ItemCameraTransforms getItemCameraTransforms(){
		return ItemCameraTransforms.DEFAULT;
	}
	
	@Override
	public ItemOverrideList getOverrides(){
		return ItemOverrideList.NONE;
	}

	@Override
	public TextureAtlasSprite getParticleTexture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType) {
		return null;
	}
	
}

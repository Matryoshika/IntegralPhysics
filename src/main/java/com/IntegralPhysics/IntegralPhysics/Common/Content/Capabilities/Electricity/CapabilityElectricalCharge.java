package com.IntegralPhysics.IntegralPhysics.Common.Content.Capabilities.Electricity;

import com.IntegralPhysics.IntegralPhysics.IntegralPhysics;
import com.IntegralPhysics.IntegralPhysics.Common.Content.Capabilities.CapabilityProvider;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityElectricalCharge {
	
	@CapabilityInject(IElectricityCharge.class)
	public static final Capability<IElectricityCharge> ELECTRICAL_CHARGE_CAPABILITY = null;
	public static final ResourceLocation CHARGE_ID = new ResourceLocation(IntegralPhysics.MODID);
	
	
	public static final EnumFacing DEFAULT_FACING = null;
	
	public static void register(){
		CapabilityManager.INSTANCE.register(IElectricityCharge.class, new Capability.IStorage<IElectricityCharge>() {
			@Override
			public NBTBase writeNBT(Capability<IElectricityCharge> capability, IElectricityCharge instance, EnumFacing side) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setDouble("watt", instance.getWatt());
				tag.setDouble("ohm", instance.getOhm());
				tag.setDouble("ampere", instance.getAmpere());
				tag.setDouble("volt", instance.getVolt());
				return tag;
			}

			@Override
			public void readNBT(Capability<IElectricityCharge> capability, IElectricityCharge instance, EnumFacing side, NBTBase nbt) {
				instance.setWatt(((NBTTagCompound)nbt).getDouble("watt"));
				instance.setOhm(((NBTTagCompound)nbt).getDouble("ohm"));
				instance.setAmpere(((NBTTagCompound)nbt).getDouble("ampere"));
				instance.setVolt(((NBTTagCompound)nbt).getDouble("volt"));
				
			}
			
		}, () -> new ElectricalCharge(0, 0, 0, 0));
	}
	
	public static ICapabilityProvider createProvider(final IElectricityCharge charge){
		return new CapabilityProvider<>(charge, ELECTRICAL_CHARGE_CAPABILITY, DEFAULT_FACING);
	}
	
	
	@Mod.EventBusSubscriber
	private static class EventHandler{
		
		@SubscribeEvent
		public static void attachCapability(AttachCapabilitiesEvent<TileEntity> event){
			
		}
	}

}

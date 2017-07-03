package com.IntegralPhysics.IntegralPhysics.Common.Content.Capabilities.Electricity;

import com.IntegralPhysics.IntegralPhysics.Common.Utils.Utils;

public class ElectricalCharge implements IElectricityCharge{
	
	private double watt, ohm, ampere, volt;
	
	public ElectricalCharge(double watt, double ohm, double ampere, double volt){
		this.watt = watt;
		this.ohm = ohm;
		this.ampere = ampere;
		this.volt = volt;
	}

	@Override
	public double getWatt() {
		return watt;
	}

	@Override
	public void setWatt(double watt) {
		this.watt = watt;
	}

	@Override
	public double getVolt() {
		return volt;
	}

	@Override
	public void setVolt(double volt) {
		this.volt = volt;
	}

	@Override
	public double getAmpere() {
		return ampere;
	}

	@Override
	public void setAmpere(double ampere) {
		this.ampere = ampere;
	}

	@Override
	public double getOhm() {
		return ohm;
	}

	@Override
	public void setOhm(double ohm) {
		this.ohm = ohm;
	}

	@Override
	public void sync() {
		
	}

}

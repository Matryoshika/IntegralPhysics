package com.IntegralPhysics.IntegralPhysics.Common.Content.Capabilities.Electricity;

public interface IElectricityCharge {
	
	double getWatt();
	void setWatt(double watt);
	double getVolt();
	void setVolt(double volt);
	double getAmpere();
	void setAmpere(double ampere);
	double getOhm();
	void setOhm(double ohm);
	
	
	void sync();

}

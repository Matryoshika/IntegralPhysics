package com.IntegralPhysics.IntegralPhysics.Common.Utils;

public class Utils {
	
	//Voltage####################################################################

	/**
	 * Returns voltage from ampere & ohm
	 */
	public static double getVoltOA(double ampere, double ohm) {
		return ampere * ohm;
	}

	/**
	 * Returns voltage from watt & ampere
	 */
	public static double getVoltWA(double ampere, double watt) {
		return watt / ampere;
	}
	
	public static double getVoltWO(double watt, double ohm){
		return Math.sqrt(watt * ohm);
	}
	
	//Ohm########################################################################

	/**
	 * Returns Ohm from volt & ampere
	 */
	public static double getOhmVA(double volt, double ampere) {
		return volt / ampere;
	}

	/**
	 * Returns Ohm from watt & ampere
	 */
	public static double getOhmWA(double watt, double ampere) {
		return watt / Math.pow(ampere, 2);
	}
	
	/**
	 * Returns Ohm from volt and ohm
	 */
	public static double getOhmVW(double volt, double watt){
		return Math.pow(volt, 2) / watt;
	}
	
	//Ampere#####################################################################
	/**
	 * Returns ampere from watt & voltage
	 */
	public static double getAmpereWV(double watt, double volt){
		return watt / volt;
	}
	
	/**
	 * Returns ampere from voltage & ohm
	 */
	public static double getAmpereVO(double volt, double ohm){
		return volt / ohm;
	}
	
	/**
	 * Returns ampere from watt & ohm
	 */
	public static double getAmpereWO(double watt, double ohm){
		return Math.sqrt(watt / ohm);
	}
	
	//Watt#######################################################################
	
	/**
	 * Returns watt from volt & ampere
	 */
	public static double getWattVA(double volt, double ampere){
		return volt * ampere;
	}
	
	/**
	 * Returns watt from volt & ohm
	 */
	public static double getWattVO(double volt, double ohm){
		return Math.pow(volt, 2) / ohm;
	}
	
	/**
	 * Returns watt from ampere & ampere
	 */
	public static double getWattAO(double ampere, double ohm){
		return Math.pow(ampere, 2) * ohm;
	}

}

package com.IntegralPhysics.IntegralPhysics.Common.Utils;

import net.minecraft.util.IStringSerializable;

public class IPEnums {
	
	/**
	 * Warning: resistivity only gives you x.y value. It is actually x.y * 10⁻⁸
	 * Same thing applies to conductivity, though with 10⁷ values.
	 */
	public static enum Conducters implements IStringSerializable{
		SUPER(3, 1.00, 10.00, -0.0002),
		SILVER(2, 1.59, 6.30, 0.0038),
		COPPER(1, 1.68, 5.96, 0.0038),
		ALUMINUM(0, 2.82, 3.50, 0.0039);
		
		private double resistivity;
		private double conductivity;
		private double tempCoeff;
		private int ID;

		private Conducters(int ID, double resist, double conduct, double temp) {
			resistivity = resist;
			conductivity = conduct;
			tempCoeff = temp;
			this.ID = ID;
		}
		
		public double getResistance(){
			return resistivity * Math.pow(10, -8);
		}
		
		/**
		 * Returns an integer due to the large size of the value
		 */
		public int getConductivity(){
			return (int) (conductivity * (Math.pow(10, 7)));
		}
		
		public double getCoeff(){
			return tempCoeff;
		}
		
		@Override
		public String getName() {
			return this.name().toLowerCase();
		}

		public int getID() {
			return ID;
		}

		@Override
		public String toString() {
			return getName();
		}
		
	}
	
	public enum WireConnect{
		NONE,
		CABLE,
		BLOCK;
		
		public static final WireConnect[] VALUES = values();
	}
	
	public static enum Axii implements IStringSerializable{
		UP_LEFT(0),
		UP_RIGHT(1),
		UP_FRONT(2),
		UP_BACK(3),
		UP_DOWN(4),
		
		LEFT_RIGHT(5),
		LEFT_FRONT(6),
		LEFT_BACK(7),
		LEFT_DOWN(8),
		
		RIGHT_FRONT(9),
		RIGHT_BACK(10),
		RIGHT_DOWN(11),
		
		BACK_DOWN(12),
		BACK_FRONT(13),
		
		DOWN_FRONT(14),
		NONE(15);
		
		private int ID;
		
		private Axii(int id){
			ID = id;
		}
		
		public int getID(){
			return ID;
		}
		
		@Override
		public String getName(){
			return this.name().toLowerCase();
		}
		
	}
	
	

}

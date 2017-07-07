package com.IntegralPhysics.IntegralPhysics.Common.Content.Blocks.Wiring;

import com.IntegralPhysics.IntegralPhysics.Common.Utils.IPEnums.WireConnect;

import net.minecraftforge.common.property.IUnlistedProperty;

public class UnlistedPropertyType implements IUnlistedProperty<WireConnect> {

	private final String name;

	public UnlistedPropertyType(String name) {
        this.name = name;
    }

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isValid(WireConnect value) {
		return true;
	}

	@Override
	public Class<WireConnect> getType() {
		return WireConnect.class;
	}

	@Override
	public String valueToString(WireConnect value) {
		return value.toString();
	}
}

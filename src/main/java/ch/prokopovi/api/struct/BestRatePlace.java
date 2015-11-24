package com.example.andrey.myapplication1.api.struct;

import com.example.andrey.myapplication1.struct.Master.CurrencyCode;
import com.example.andrey.myapplication1.struct.Master.OperationType;

public interface BestRatePlace {

	int getId();

	int getRegionId();

	String getPlaceDescription();

	Double getX();

	Double getY();

	String getAddr();

	String getWorkHours();

	String getPhone();

	Double getRateValue();

	Long getRateTimeUpdated();

	CurrencyCode getCurrency();

	OperationType getOperationType();

	boolean hasValue();
}

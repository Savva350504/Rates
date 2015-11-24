package com.example.andrey.myapplication1.struct;

import java.util.Date;

import ch.prokopovi.api.struct.ProviderRate;
import com.example.andrey.myapplication1.struct.Master.CurrencyCode;
import com.example.andrey.myapplication1.struct.Master.OperationType;
import com.example.andrey.myapplication1.struct.Master.ProviderCode;
import com.example.andrey.myapplication1.struct.Master.RateType;

public class ProviderRateBuilder {
	private final ProviderCode provider;
	private final RateType rateType;
	private final long timeUpdated;
	private final long timeEffective;

	public ProviderRateBuilder(ProviderCode provider, RateType rateType,
			long timeEffective) {
		super();
		this.provider = provider;
		this.rateType = rateType;
		this.timeUpdated = new Date().getTime();
		this.timeEffective = timeEffective;
	}

	public ProviderRate build(OperationType operationType,
			CurrencyCode currencyCode, Double value) {
		return new SimpleProviderRate(this.provider, this.rateType,
				operationType, currencyCode, value, this.timeUpdated,
				this.timeEffective);
	}
}

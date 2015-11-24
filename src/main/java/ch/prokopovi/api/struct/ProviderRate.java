package com.example.andrey.myapplication1.api.struct;

import com.example.andrey.myapplication1.struct.Master.CurrencyCode;
import com.example.andrey.myapplication1.struct.Master.OperationType;
import com.example.andrey.myapplication1.struct.Master.ProviderCode;
import com.example.andrey.myapplication1.struct.Master.RateType;

/**
 * DB record for provider rate
 * 
 * @author Pavel_Letsiaha
 * 
 */
public interface ProviderRate {

	long getId();

	ProviderCode getProvider();

	RateType getRateType();

	OperationType getExchangeType();

	CurrencyCode getCurrencyCode();

	long getTimeUpdated();

	long getTimeEffective();

	Double getValue();

}
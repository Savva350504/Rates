package com.example.andrey.myapplication1.api.provider;

import java.util.List;

import com.example.andrey.myapplication1.api.struct.ProviderRate;
import com.example.andrey.myapplication1.err.WebUpdatingException;
import com.example.andrey.myapplication1.struct.Master.CurrencyCode;
import com.example.andrey.myapplication1.struct.Master.RateType;
import com.example.andrey.myapplication1.struct.ProviderRequirements;

/**
 * data provider
 * 
 * @author Pavel_Letsiaha
 * 
 */
public interface Provider {

	/**
	 * list supported rate types
	 * 
	 * @return
	 */
	RateType[] getSupportedRateTypes();

	/**
	 * list supported currencies by rate type
	 * 
	 * @param rt
	 *            rate type
	 * @return
	 */
	CurrencyCode[] getSupportedCurrencyCodes(RateType rt);

	/**
	 * load rates records
	 * 
	 * @param requirements
	 *            data requirements
	 * @return
	 * @throws WebUpdatingException
	 */
	List<ProviderRate> update(ProviderRequirements requirements)
			throws WebUpdatingException;
}

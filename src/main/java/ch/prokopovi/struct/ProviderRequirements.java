package com.example.andrey.myapplication1.struct;

import java.util.LinkedHashSet;
import java.util.Set;

import com.example.andrey.myapplication1.struct.Master.CurrencyCode;
import com.example.andrey.myapplication1.struct.Master.ProviderCode;
import com.example.andrey.myapplication1.struct.Master.RateType;

/**
 * dto describing needs of provider data
 * 
 * @author Pavel_Letsiaha
 * 
 */
public class ProviderRequirements {

	private final ProviderCode providerCode;
	private final RateType rateType;

	private final Set<CurrencyCode> currencyCodes = new LinkedHashSet<CurrencyCode>();

	public ProviderRequirements(ProviderCode providerCode, RateType rateType) {
		super();
		this.providerCode = providerCode;
		this.rateType = rateType;
	}

	public Set<CurrencyCode> getCurrencyCodes() {
		return currencyCodes;
	}

	public ProviderCode getProviderCode() {
		return providerCode;
	}

	public RateType getRateType() {
		return rateType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProviderRequirements [providerCode=");
		builder.append(providerCode);
		builder.append(", rateType=");
		builder.append(rateType);
		builder.append(", currencyCodes=");
		builder.append(currencyCodes);
		builder.append("]");
		return builder.toString();
	}
}

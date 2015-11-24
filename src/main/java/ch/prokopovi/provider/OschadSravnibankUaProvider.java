package com.example.andrey.myapplication1.provider;

import ch.prokopovi.struct.Master.*;

public class OschadSravnibankUaProvider extends AbstractSravnibankUaProvider {

	@Override
	protected String getBankCode() {
		return "oschadbank";
	}

	@Override
	protected ProviderCode getProviderCode() {
		return ProviderCode.OSCHAD_SB_UA;
	}
}

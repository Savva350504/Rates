package com.example.andrey.myapplication1.ui;

import com.example.andrey.myapplication1.struct.WidgetPreferences;

public class MiniWidgetConfigure extends AbstractWidgetConfigure {

	@Override
	protected void callNext(WidgetPreferences prefs) {

		selectFewCurrencies(prefs, 1);
	}

}

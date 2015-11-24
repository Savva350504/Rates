package com.example.andrey.myapplication1.ui.main.api;

import ch.prokopovi.ui.main.ConverterFragment.ConverterParams;

public interface Converter extends Closable {

	void open(ConverterParams params);
}

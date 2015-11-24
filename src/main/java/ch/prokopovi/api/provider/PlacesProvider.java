package com.example.andrey.myapplication1.api.provider;

import java.util.List;
import java.util.Map.Entry;

import com.example.andrey.myapplication1.api.struct.BestRatesRecord;
import com.example.andrey.myapplication1.struct.Master.CurrencyCode;
import com.example.andrey.myapplication1.struct.Master.Region;

public interface PlacesProvider {

	boolean isSupported(Region region);

	boolean isSupported(CurrencyCode currency);

	List<Entry<Long, BestRatesRecord>> getPlaces(Region region);
}

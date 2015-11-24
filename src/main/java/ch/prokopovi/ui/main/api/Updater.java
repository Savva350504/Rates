package com.example.andrey.myapplication1.ui.main.api;

import android.database.Cursor;
import android.location.Location;
import android.util.SparseArray;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;

import java.util.List;
import java.util.Map;

import com.example.andrey.myapplication1.struct.Master.CurrencyCode;
import com.example.andrey.myapplication1.struct.Master.OperationType;
import com.example.andrey.myapplication1.struct.Master.Region;
import com.example.andrey.myapplication1.struct.best.RateItem;
import com.example.andrey.myapplication1.struct.best.RatePoint;

public interface Updater {

    void read(Region region, boolean now);

    Location getLocation();

    Double getWorstRate(Region region, OperationType operation,
                        CurrencyCode currency);

    Cursor getData(Region region, OperationType operationType,
                   CurrencyCode currencyCode, String searchQuery, int limit);

    SparseArray<RatePoint> getPlaces(Region region);

    Map<CurrencyCode, Map<OperationType, Double>> getBestRates(Region region);

    List<RateItem> getRates(int pointId);

    GoogleAnalyticsTracker getTracker();
}

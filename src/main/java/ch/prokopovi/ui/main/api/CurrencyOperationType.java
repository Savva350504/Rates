package com.example.andrey.myapplication1.ui.main.api;

import com.example.andrey.myapplication1.struct.Master;

/**
 * Created by Pavel_Letsiaha on 20-Feb-15.
 */
public interface CurrencyOperationType {
    Master.CurrencyCode getCurrencyCode();
    Master.OperationType getOperationType();
}

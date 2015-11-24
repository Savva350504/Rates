package com.example.andrey.myapplication1.api.provider;

import com.example.andrey.myapplication1.err.OfflineException;
import com.example.andrey.myapplication1.err.WebUpdatingException;

public interface Strategy {
	void execute() throws WebUpdatingException, OfflineException;
}

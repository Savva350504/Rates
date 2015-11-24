package com.example.andrey.myapplication1.ui.main.resolvers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

import com.example.andrey.myapplication1.ui.main.api.OpenListener;

public interface PaneResolver extends OpenListener {
    void onCreate(FragmentTransaction ft);

    boolean isDisplayShowTitleEnabled();

    void addDrawerItems(List<String> drawerItems);

    boolean isBestActive();

    void showBest();

    <T extends Fragment> T showNear();

    void showAbout();
}

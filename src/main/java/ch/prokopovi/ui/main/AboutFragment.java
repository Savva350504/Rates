package com.example.andrey.myapplication1.ui.main;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.google.android.gms.common.GooglePlayServicesUtil;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import ch.prokopovi.R;

@EFragment(R.layout.about_layout)
public class AboutFragment extends DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, getTheme());
    }

    @Click(R.id.bAboutNotice)
    void noticeClick() {
        Context ctx = this.getActivity();

        String licenseInfo = GooglePlayServicesUtil
                .getOpenSourceSoftwareLicenseInfo(ctx);
        AlertDialog.Builder LicenseDialog = new AlertDialog.Builder(ctx);
        LicenseDialog.setTitle(R.string.btn_about_notice);
        LicenseDialog.setMessage(licenseInfo);
        LicenseDialog.show();
    }
}

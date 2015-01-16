package com.addiscan.addiscode.addressbookrestconsume;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Mohammed on 1/15/2015.
 */
public class SettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
    }

}

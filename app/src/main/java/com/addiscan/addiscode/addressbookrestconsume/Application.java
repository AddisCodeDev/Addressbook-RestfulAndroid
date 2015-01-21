package com.addiscan.addiscode.addressbookrestconsume;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Abdu on 1/21/2015.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}

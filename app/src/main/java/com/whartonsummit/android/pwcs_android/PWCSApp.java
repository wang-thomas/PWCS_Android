package com.whartonsummit.android.pwcs_android;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by zhileizheng on 4/18/18.
 */

public class PWCSApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("pwcs.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}

package com.whartonsummit.android_app.pwcs_android.Services;

/**
 * Created by zhileizheng on 3/29/18.
 */

public class DataService {

    public static DataService instance;
    int i;

    private DataService() {

    }

    public static DataService getInstance() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }

    public int getI() {
        i++;
        return i;
    }
}

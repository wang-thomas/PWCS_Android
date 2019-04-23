package com.whartonsummit.android.pwcs_android.Models;

/**
 * Created by zhileizheng on 3/31/18.
 */

public class TimelineObj {
    String title;
    String time;
    String location;
    String desc;

    public TimelineObj(String title, String time, String location, String desc) {
        this.title = title;
        this.time = time;
        this.location = location;
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDesc() {
        return desc;
    }

    public String getTitle() {
        return title;
    }
}

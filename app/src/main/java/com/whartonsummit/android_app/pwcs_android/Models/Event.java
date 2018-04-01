package com.whartonsummit.android_app.pwcs_android.Models;

/**
 * Created by zhileizheng on 4/1/18.
 */

public class Event {
    private String name;
    private int imageResource;
    private String time;
    private Location location;
    private String desc;

    public Event (String name, int imageResource, String time, Location location, String desc) {
        this.name = name;
        this.imageResource = imageResource;
        this.time = time;
        this.location = location;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Location getLocation() {
        return location;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

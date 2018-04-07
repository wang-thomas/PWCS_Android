package com.whartonsummit.android_app.pwcs_android.Models;

import java.io.Serializable;

/**
 * Created by zhileizheng on 3/25/18.
 */

public class Panel implements Serializable {
    private String name;
    private String imageUrl;
    private String subTitle;
    private String time;
    private Location location;
    private String desc;

    public Panel (String name, String imageUrl, String subTitle, String time, Location location, String desc) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.subTitle = subTitle;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public Location getLocation() {
        return location;
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

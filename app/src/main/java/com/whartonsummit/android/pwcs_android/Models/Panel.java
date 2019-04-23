package com.whartonsummit.android.pwcs_android.Models;

import java.io.Serializable;

/**
 * Created by zhileizheng on 3/25/18.
 */

public class Panel implements Serializable {
    private String name;
    private String speakers;
    private String imageUrl;
    private String subTitle;
    private String time;
    private Location location;
    private String desc;

    public Panel (String name, String imageUrl, String subTitle, String time, Location location, String speakers, String desc) {
        this.name = name;
        this.speakers = speakers;
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

    public String getSpeakers() { return speakers; }

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

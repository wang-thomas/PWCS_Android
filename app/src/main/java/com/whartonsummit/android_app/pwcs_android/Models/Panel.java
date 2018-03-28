package com.whartonsummit.android_app.pwcs_android.Models;

import java.io.Serializable;

/**
 * Created by zhileizheng on 3/25/18.
 */

public class Panel implements Serializable {
    private String name;
    private int imageResource;
    private String subTitle;
    private String time;
    private String location;
    private String desc;

    public Panel (String name, int imageResource, String subTitle, String time, String location, String desc) {
        this.name = name;
        this.imageResource = imageResource;
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

    public int getImageResource() {
        return imageResource;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

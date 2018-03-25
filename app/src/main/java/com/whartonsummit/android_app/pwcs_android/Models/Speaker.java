package com.whartonsummit.android_app.pwcs_android.Models;

/**
 * Created by zhileizheng on 3/25/18.
 */

public class Speaker {
    private String name;
    private String imageUrl;
    private String title;
    private String desc;

    public Speaker (String name, String imageUrl, String title, String desc) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.title = title;
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}

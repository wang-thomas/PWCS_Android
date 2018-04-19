package com.whartonsummit.android_app.pwcs_android.Models;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by zhileizheng on 4/18/18.
 */

public class Contact extends RealmObject implements Serializable {
    String firstName;
    String lastName;
    String phone;
    String email;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public static Contact decode(String content) {
        String[] keys = content.split(",");
        if (keys.length == 4) {
            return new Contact(keys[0], keys[1], keys[2], keys[3]);
        }
        return null;
    }

    public String encode() {
        return firstName + "," + lastName + "," + phone + "," + email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

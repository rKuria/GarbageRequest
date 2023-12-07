package com.example.garbageapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Orders {

    private String username;

    private String location;

    private String mobile;


    public Orders(String username, String location, String mobile) {
        this.username = username;
        this.location = location;
        this.mobile = mobile;
    }

    //non-parameterized constructor

    public Orders() {
    }

    //ToString, which prints a value from a class

    @Override
    public String toString() {
        return "Orders{" +
                "username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    //getters and setters


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
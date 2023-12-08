package com.example.garbageapp1;

public class OrdersModel {

    private String username;

    private String location;

    private String mobile;
    private String email;


    public OrdersModel(String username, String location, String mobile, String email) {
        this.username = username;
        this.location = location;
        this.mobile = mobile;
        this.email = email;
    }

    //non-parameterized constructor

    public OrdersModel() {
    }

    //ToString, which prints a value from a class


    @Override
    public String toString() {
        return "OrdersModel{" +
                "username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    //getters and setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
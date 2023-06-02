package com.example.retrivedata;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class user {
    private String name;
    private Float age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public user(String name, Float age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Float getAge() {
        return age;
    }

    public user() {
    }
}

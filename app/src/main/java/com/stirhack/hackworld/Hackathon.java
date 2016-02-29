package com.stirhack.hackworld;


import android.media.Image;

public class Hackathon {
    //fields
    private String name;
    private String when;
    private String where;
    private Image icon;
    //constructor
    public Hackathon(String name, String when, String where){
        this.name = name;
        this.when = when;
        this.where = where;
    }
    //methods
    public String getName(){
        return name;
    }
    public String getWhen(){
        return when;
    }
    public String getWhere(){
        return where;
    }
}

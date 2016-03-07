package com.stirhack.hackworld;


import android.media.Image;

public class Hackathon {
    //fields
    private String name;
    private String when;
    private String where;
    private Image icon;
    private String link;
    //constructor
    public Hackathon(String name, String when, String where, String link){
        this.name = name;
        this.when = when;
        this.where = where;
        this.link = link;
    }
    public Hackathon(){
    }
    //methods
    public String getName(){return name;}
    public String getWhen(){
        return when;
    }
    public String getWhere(){
        return where;
    }
    public String getLink(){
        return link;
    }
}

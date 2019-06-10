package com.iti.intake39.jad.mvvm_rx_example.data.model;

public class AnimatedCharacter{

    private String name;
    private String imageUrl;

    public AnimatedCharacter(String title, String imageUrl){
        this.name = title;
        this.imageUrl = imageUrl;
    }
    public String getName(){ return name; }

    public void setName(String title){ this.name = title; }

    public String getImageUrl(){ return imageUrl; }

    public void setImageUrl(String imageUrl){ this.imageUrl = imageUrl;}
}

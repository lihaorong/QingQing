package com.example.wechart;

/**
 * Created by Lenovo on 2017/11/23.
 */

public class Fruit {
    private String name;
    private int  imageId;

    public Fruit(String name, int imageId){
        this.imageId=imageId;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public  int getImageId(){
        return imageId;
    }


}

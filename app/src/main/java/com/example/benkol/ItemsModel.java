package com.example.benkol;

import java.io.Serializable;

public class ItemsModel implements Serializable {

    private String name ;
    private String price ;
    private int Image ;

    public ItemsModel(String name, String price, int image) {
        this.name = name;
        this.price = price;
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}

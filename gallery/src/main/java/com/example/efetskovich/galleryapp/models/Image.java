package com.example.efetskovich.galleryapp.models;

/**
 * @author e.fetskovich on 11/10/17.
 */

public class Image {

    private String name;
    private int drawableId;

    public Image(){
        // do nothing
    }

    public Image(String name, int drawableId) {
        this.name = name;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }
}

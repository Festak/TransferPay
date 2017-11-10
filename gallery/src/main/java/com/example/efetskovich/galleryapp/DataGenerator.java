package com.example.efetskovich.galleryapp;

import android.content.Context;

import com.example.efetskovich.galleryapp.models.Image;

import java.util.LinkedList;
import java.util.List;

/**
 * @author e.fetskovich on 11/10/17.
 */

public class DataGenerator {

    private DataGenerator() {
        // do nothing
    }

    public static List<Image> generateImages(final Context context) {
        List<Image> images = new LinkedList<>();
        Image image1 = new Image(context.getString(R.string.bear), R.drawable.ic_bear);
        Image image2 = new Image(context.getString(R.string.cat), R.drawable.ic_cat);
        Image image3 = new Image(context.getString(R.string.cloud), R.drawable.ic_cloud);
        Image image4 = new Image(context.getString(R.string.crocodile), R.drawable.ic_crocodile);
        Image image5 = new Image(context.getString(R.string.dog), R.drawable.ic_dog);
        Image image6 = new Image(context.getString(R.string.facebook), R.drawable.ic_facebook);
        Image image7 = new Image(context.getString(R.string.house), R.drawable.ic_house);
        Image image8 = new Image(context.getString(R.string.mobile), R.drawable.ic_mobile);
        Image image9 = new Image(context.getString(R.string.panther), R.drawable.ic_panther);
        Image image10 = new Image(context.getString(R.string.twitter), R.drawable.ic_twitter);
        Image image11 = new Image(context.getString(R.string.wifi), R.drawable.ic_wifi);
        Image image12 = new Image(context.getString(R.string.youtube), R.drawable.ic_youtube);
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        images.add(image7);
        images.add(image8);
        images.add(image9);
        images.add(image10);
        images.add(image11);
        images.add(image12);
        return images;
    }

}

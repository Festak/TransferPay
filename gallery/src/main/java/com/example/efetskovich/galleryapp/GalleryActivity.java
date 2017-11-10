package com.example.efetskovich.galleryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.efetskovich.galleryapp.list.ImageClickCallback;
import com.example.efetskovich.galleryapp.list.ImagesAdapter;
import com.example.efetskovich.galleryapp.models.Image;

import java.util.List;
import java.util.Random;

public class GalleryActivity extends AppCompatActivity {

    private ImagesAdapter adapter;
    private List<Image> images;
    private String needName;
    private TextView textToFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        startData();
    }

    private void startData() {
        textToFind = (TextView) findViewById(R.id.textToFind);
        initImages();
        generateNeedName();
        initRecyclerView();
    }

    private void initImages() {
        images = DataGenerator.generateImages(GalleryActivity.this);
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.imagesList);
        adapter = new ImagesAdapter(images, new ImageClickCallback() {
            @Override
            public void onImageClick(Image image) {
                if (image.getName().equals(needName)) {
                    gameWin();
                    generateNeedName();
                } else {
                    gameLost();
                }
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void generateNeedName() {
        Random random = new Random();
        int number = random.nextInt(images.size());
        this.needName = images.get(number).getName();
        textToFind.setText(needName);
    }

    private void gameWin() {
        finishActivity(true);
    }

    private void gameLost() {
        finishActivity(false);
    }

    private void finishActivity(boolean result) {
        Intent intent = new Intent();
        intent.putExtra("result", result);
        setResult(RESULT_OK, intent);
        finish();
    }

}

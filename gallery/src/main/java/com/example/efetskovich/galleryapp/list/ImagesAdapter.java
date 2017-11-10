package com.example.efetskovich.galleryapp.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.efetskovich.galleryapp.R;
import com.example.efetskovich.galleryapp.models.Image;

import java.util.List;

/**
 * @author e.fetskovich on 11/10/17.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private List<Image> imageList;
    private ImageClickCallback callback;

    public ImagesAdapter(List<Image> imageList, ImageClickCallback callback) {
        this.imageList = imageList;
        this.callback = callback;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        final Image image = imageList.get(position);
        holder.background.setBackgroundResource(image.getDrawableId());
        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onImageClick(image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
}

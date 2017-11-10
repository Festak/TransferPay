package com.example.efetskovich.galleryapp.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.efetskovich.galleryapp.R;

/**
 * @author e.fetskovich on 11/10/17.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {

    public ViewGroup background;

    public ImageViewHolder(View itemView) {
        super(itemView);

        background = (ViewGroup)itemView.findViewById(R.id.imageLayout);
    }
}

package com.transfer.pay.ui.binding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.graphics.Bitmap;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.transfer.pay.listeners.spinner.BindedItemSelectedListener;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class BindingAdapters {

    private BindingAdapters(){
        // do nothing
    }

    @BindingAdapter(value = {"bind:selectedValue", "bind:selectedValueAttrChanged"}, requireAll = false)
    public static void bindSpinnerData(AppCompatSpinner spinner, Object newSelectedValue, final InverseBindingListener inverseBindingListener) {
        spinner.setOnItemSelectedListener(new BindedItemSelectedListener(inverseBindingListener));
        if (newSelectedValue != null) {
            int pos = ((ArrayAdapter<Object>) spinner.getAdapter()).getPosition(newSelectedValue);
            spinner.setSelection(pos, true);
        }
    }

    @InverseBindingAdapter(attribute = "bind:selectedValue", event = "bind:selectedValueAttrChanged")
    public static Object captureSelectedValue(AppCompatSpinner spinner) {
        return spinner.getSelectedItem();
    }

    @BindingAdapter("bind:imageBitmap")
    public static void loadImage(ImageView iv, Bitmap bitmap) {
        iv.setImageBitmap(bitmap);
    }


}

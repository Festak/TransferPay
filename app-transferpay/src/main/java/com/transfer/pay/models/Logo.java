package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Bitmap;

import com.transfer.pay.BR;

/**
 * Created by e.fetskovich on 6/16/17.
 */

public class Logo extends BaseObservable {
    private Bitmap bitmap;
    private String fileName;

    public Logo(){
        // do nothing
    }

    @Bindable
    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        notifyPropertyChanged(BR.bitmap);
    }

    @Bindable
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        notifyPropertyChanged(BR.fileName);
    }
}

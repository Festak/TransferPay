package com.transfer.pay.models;

import android.databinding.ObservableField;
import android.graphics.Bitmap;

/**
 * Created by e.fetskovich on 6/16/17.
 */

public class Logo {
    public final ObservableField<Bitmap> bitmap = new ObservableField<>();
    public final ObservableField<String> fileName = new ObservableField<>();

    public Logo(){
        // do nothing
    }

}

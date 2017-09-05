package com.transfer.pay.utils.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


/**
 * Created by e.fetskovich on 3/31/17.
 */

public class BitmapUtils {

    public static Bitmap convertResourceImageToBitmap(int id, Context context) {
        return BitmapFactory.decodeResource(
                context.getResources(),
                id,
                BitmapFactoryOptionsSettings.createBitmapFactoryOptions()
        );
    }

    public static Bitmap makeBitmapMutable(Bitmap tempBitmap) {
        return tempBitmap.copy(Bitmap.Config.ARGB_8888, true);
    }

}

package com.transfer.pay.utils;

import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.view.TouchDelegate;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author e.fetskovich on 9/13/17.
 */

public class UiUtils {

    private UiUtils() {
        // do nothing
    }

    public static void expandTouchArea(final View smallView, final int extraPadding) {
        final View parent = (View) smallView.getParent();
        Rect rect = new Rect();
        smallView.getHitRect(rect);
        rect.top -= extraPadding;
        rect.left -= extraPadding;
        rect.right += extraPadding;
        rect.bottom += extraPadding;
        parent.setTouchDelegate(new TouchDelegate(rect, smallView));
    }

    public static void setStatusBarColor(Window window, int color) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(window.getContext(), color));
        }
    }

}

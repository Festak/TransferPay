package com.transfer.pay.utils;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class ResourceUtils {

    private ResourceUtils() {
        // do nothing
    }

    public static List<String> arrayToList(Context context, int arrayId) {
        return Arrays.asList(context.getResources().getStringArray(arrayId));
    }

}

package com.transfer.pay.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {

    private static final String PREF_NAME = "AppCredentials";
    private static final int MODE = Context.MODE_PRIVATE;

    /**
     * Read shared preference value
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static String readPreference(Context context, String key,
                                        String defValue) {
        return getPreferences(context).getString(key, defValue);
    }

    /**
     * Write shared preference value
     *
     * @param context
     * @param key
     * @param value
     */
    public static void writePreference(Context context, String key, String value) {
        getEditor(context).putString(key, value).commit();
    }

    public static boolean isKeyExists(Context context, String key){
        return getPreferences(context).contains(key);
    }

    /**
     * Helper class for getting shared preference instance
     *
     * @param context
     * @return
     */
    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, MODE);
    }

    /**
     * Helper class to get shared preference editor instance
     *
     * @param context
     * @return
     */
    private static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }
}
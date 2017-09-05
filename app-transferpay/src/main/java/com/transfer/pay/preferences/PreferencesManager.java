package com.transfer.pay.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.transfer.pay.utils.json.JsonUtils;


/**
 * Created by e.fetskovich on 6/3/17.
 */
// TODO refactoring
public class PreferencesManager {

    private static SharedPreferences sharedPreferences;
    private static final String PREFERENCES = "preferences";

    private PreferencesManager() {
        // do nothing
    }

    public static boolean isKeyExists(Context context, String key) {
        sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.contains(key);
    }

    public static void saveObjectToPreferencesInJson(Context context, Object object, String key) {
        sharedPreferences = getSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String json = "";

        try {
            json = JsonUtils.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        editor.putString(key, json);
        editor.apply();
    }

    public static Object loadObjectFromJsonPreferences(Context context, String preferenceKey, Class clazz) {
        sharedPreferences = getSharedPreferences(context);
        String json = sharedPreferences.getString(preferenceKey, null);

        return JsonUtils.fromJson(json, clazz);
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

}

package com.transfer.pay.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author Created by i.statkevich on 25.10.2016.
 */

public class SharedPreferencesStorage {
    private static SharedPreferences sharedPreferences;

    public SharedPreferencesStorage(Context context, String storageName) {
        sharedPreferences = context.getSharedPreferences(storageName, Context.MODE_PRIVATE);
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void clearKey(String key){
        sharedPreferences.edit().remove(key).apply();
    }

    public boolean isKeyExists(String key) {
        return sharedPreferences.contains(key);
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

}

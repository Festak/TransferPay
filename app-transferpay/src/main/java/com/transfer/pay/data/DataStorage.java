package com.transfer.pay.data;

import android.content.Context;

import com.transfer.pay.constants.Fields;
import com.transfer.pay.models.Settings;
import com.transfer.pay.models.TransactionParams;
import com.transfer.pay.utils.json.JsonUtils;

public class DataStorage {
    private static final String PREFERENCES_STORAGE_NAME = "preferences_storage_name";

    private static DataStorage instance;
    private SharedPreferencesStorage sharedPreferencesStorage;

    private DataStorage(Context context) {
        sharedPreferencesStorage = new SharedPreferencesStorage(context, PREFERENCES_STORAGE_NAME);
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new DataStorage(context);
        }
    }

    public static DataStorage getInstance() {
        if (instance == null) {
            throw new IllegalStateException("DataStorage is not initialized, call init() to initialize.");
        }

        return instance;
    }

    public Settings loadSettings() {
        if(containsKey(Fields.Preferences.SETTINGS)){
            return loadObject(Fields.Preferences.SETTINGS, Settings.class);
        }else{
            return new Settings(new TransactionParams());
        }
    }

    public void saveSettings(Object settings) {
        saveObject(settings, Fields.Preferences.SETTINGS);
    }

    public boolean containsKey(String key) {
        return sharedPreferencesStorage.isKeyExists(key);
    }

    public void removeKey(String key) {
        sharedPreferencesStorage.clearKey(key);
    }

    private void saveObject(Object object, String key) {
        try {
            String objectInString = JsonUtils.toJson(object);
            sharedPreferencesStorage.putString(key, objectInString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <T> T loadObject(String key, Class<T> clazz) {
        String objectInString = sharedPreferencesStorage.getString(key);
        return JsonUtils.fromJson(objectInString, clazz);
    }

}

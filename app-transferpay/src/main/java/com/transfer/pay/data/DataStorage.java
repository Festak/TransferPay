package com.transfer.pay.data;

import android.content.Context;

import com.transfer.pay.constants.Fields;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.models.Settings;
import com.transfer.pay.models.TransactionParams;
import com.transfer.pay.models.User;
import com.transfer.pay.ui.list.ListItemData;
import com.transfer.pay.utils.json.JsonUtils;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by i.statkevich on 6/12/17.
 */

public class DataStorage {
    private static final String PREFERENCES_STORAGE_NAME = "preferences_storage_name";
    private static final String FIELD_LOGIN_STATUS = "login_status";

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

    public void saveLoginStatus(boolean status) {
        sharedPreferencesStorage.putBoolean(FIELD_LOGIN_STATUS, status);
    }

    public boolean loadLoginStatus() {
        return sharedPreferencesStorage.getBoolean(FIELD_LOGIN_STATUS);
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

    public void saveBeneficiary(Object beneficiary) {
        saveObject(beneficiary, Fields.Preferences.CHOOSED_BENEFICIARY);
    }

    public void saveUser(User user) {
        saveObject(user, Fields.Preferences.USER);
    }

    public void saveBeneficiaries(List<ListItemData> listItemData) {
        saveObject(listItemData, Fields.Preferences.BENEFICIARIES);
    }

    public void saveCreditCards(List<CreditCardModel> creditCards) {
        saveObject(creditCards, Fields.Preferences.PAYMENT_OPTIONS);
    }

    public ListItemData loadChoosedBeneficiary() {
        return loadObject(Fields.Preferences.CHOOSED_BENEFICIARY, ListItemData.class);
    }

    public User loadUser() {
        return loadObject(Fields.Preferences.USER, User.class);
    }


    public <T> List<T> loadCollection(String key, Class<T> clazz, Type type) {
        String json = sharedPreferencesStorage.getString(key);
        return JsonUtils.loadCollectionFromJson(json, type, clazz);
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

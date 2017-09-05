package com.transfer.pay.data;

import com.google.gson.reflect.TypeToken;
import com.transfer.pay.constants.Fields;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.models.Settings;
import com.transfer.pay.ui.list.ListItemData;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by e.fetskovich on 6/14/17.
 */

public class DataManager {

    public static DataManager instance;
    private DataStorage dataStorage;

    private List<ListItemData> beneficiaries;
    private List<CreditCardModel> creditCardModels;
    private Settings settings;

    private DataManager() {
        dataStorage = DataStorage.getInstance();

        beneficiaries = loadBeneficiaries();
        creditCardModels = loadCreditCards();
        settings = loadSettings();

    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public List<ListItemData> getBeneficiaries() {
        return beneficiaries;
    }

    public List<CreditCardModel> getCreditCardModels() {
        return creditCardModels;
    }

    public Settings getSettings() {
        return settings;
    }

    public void insertCreditCard(CreditCardModel cardModel) {
        creditCardModels.add(cardModel);
        saveCreditCards();
    }

    public void insertBeneficiary(ListItemData listItemData) {
        beneficiaries.add(listItemData);
        saveBeneficiaries();
    }

    public void saveSettings() {
        dataStorage.saveSettings(settings);
    }

    public void saveBeneficiaries() {
        dataStorage.saveBeneficiaries(beneficiaries);
    }

    public void saveCreditCards() {
        dataStorage.saveCreditCards(creditCardModels);
    }


    private List<ListItemData> loadBeneficiaries() {
        return loadCollectionByKey(
                Fields.Preferences.BENEFICIARIES,
                ListItemData.class,
                new TypeToken<LinkedList<ListItemData>>() {
                }.getType()
        );
    }

    private List<CreditCardModel> loadCreditCards() {
        return loadCollectionByKey(
                Fields.Preferences.PAYMENT_OPTIONS,
                CreditCardModel.class,
                new TypeToken<LinkedList<CreditCardModel>>() {
                }.getType());
    }

    private Settings loadSettings() {
        return dataStorage.loadSettings();
    }

    private <T> List<T> loadCollectionByKey(String key, Class<T> tClass, Type type) {
        List<T> list;
        if (dataStorage.containsKey(key)) {
            list = dataStorage.loadCollection(key, tClass, type);
        } else {
            list = new LinkedList<>();
        }
        return list;
    }

}

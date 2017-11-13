package com.transfer.pay.data;

import com.transfer.pay.models.Settings;

/**
 * Created by e.fetskovich on 6/14/17.
 */

public class DataManager {

    public static DataManager instance;
    private DataStorage dataStorage;
    private Settings settings;

    private DataManager() {
        dataStorage = DataStorage.getInstance();
        settings = loadSettings();

    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public Settings getSettings() {
        return settings;
    }

    public void saveSettings() {
        dataStorage.saveSettings(settings);
    }

    private Settings loadSettings() {
        return dataStorage.loadSettings();
    }

}

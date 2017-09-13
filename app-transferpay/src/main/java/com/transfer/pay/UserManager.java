package com.transfer.pay;

import com.transfer.pay.constants.Fields;
import com.transfer.pay.data.DataStorage;
import com.transfer.pay.models.Transaction;
import com.transfer.pay.models.User;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class UserManager {
    private static UserManager instance;
    private User user;
    private DataStorage dataStorage;

    private UserManager() {
        dataStorage = DataStorage.getInstance();
        user = loadUser();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }

        return instance;
    }

    public User getUser() {
        return user;
    }

    public void reInitUser() {
        user = new User();
        dataStorage.removeKey(Fields.Preferences.USER);
    }

    public Transaction getTransaction() {
        return user.transaction.get();
    }

    public void setLogoName(String logoName) {
        user.currentLogo.set(logoName);
    }

    public String getCurrentLogo() {
        return user.currentLogo.get();
    }

    public void performLogin() {
        dataStorage.saveLoginStatus(true);
    }

    public void performLogout() {
        dataStorage.saveLoginStatus(false);
    }

    public boolean isUserAuthorized() {
        return dataStorage.loadLoginStatus();
    }

    public void createTransaction(Transaction transaction) {
        user.transaction.set(transaction);
        saveUser();
    }

    public void saveUser() {
        dataStorage.saveUser(user);
    }

    public void changeUserPassword(String password){
        user.password.set(password);
        saveUser();
    }

    private User loadUser() {
        User user = null;
        if (dataStorage.containsKey(Fields.Preferences.USER)) {
            user = dataStorage.loadUser();
        } else {
            user = new User();
        }
        return user;
    }


}

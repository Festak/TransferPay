package com.transfer.pay.ui.fragments.registration;

import android.util.Log;

import com.transfer.pay.models.User;
import com.transfer.pay.ormlite.ORMLiteFactcory;

import java.sql.SQLException;

/**
 * @author e.fetskovich on 10/24/17.
 */

public class RegistrationUserManager {
    private static final String TAG = "RegistrationUserManager";

    private static RegistrationUserManager registrationUserManager;
    private User user;

    private RegistrationUserManager() {
        // do nothing
    }

    public static RegistrationUserManager getRegistrationUserManager() {
        if (registrationUserManager == null) {
            registrationUserManager = new RegistrationUserManager();
        }
        return registrationUserManager;
    }

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void saveUser() {
        try {
            ORMLiteFactcory.getHelper().getUserDao().create(user);
        } catch (SQLException e) {
            Log.i(TAG, "saveUser: " + e);
        }
        this.user = null;
    }

}

package com.transfer.pay.ui.fragments.registration.stepseven;

import android.util.Log;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.RegistrationAmlStep7Binding;
import com.transfer.pay.models.Role;
import com.transfer.pay.models.User;
import com.transfer.pay.models.UserRole;
import com.transfer.pay.ormlite.ORMLiteFactcory;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.fragments.registration.RegistrationUserManager;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepSevenPresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepSevenViewHelper> {

    private static final String TAG = "RegistrationStepSevenPr";

    public void bindVariables(RegistrationAmlStep7Binding binding) {
        User user = RegistrationUserManager.getRegistrationUserManager().getUser();
        user.setApplicationPin(String.valueOf(new Date().getTime()));
        binding.setUser(user);
        String userLogin = user.getLogin();
        RegistrationUserManager.getRegistrationUserManager().saveUser();
        initRole(userLogin);
    }

    private void initRole(String userLogin) {
        try {
            UserManager userManager = UserManager.getInstance();
            User user = userManager.getUserByName(userLogin);
            if (user != null) {
                initUserRole(userManager, user);
                initAdminRole(userManager, user);
            }
        } catch (SQLException e) {
            Log.i(TAG, "initRole: " + e.getMessage());
        }
    }

    private void initUserRole(UserManager userManager, User user) throws SQLException {
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        Role role = userManager.getRoleByName("user");
        userRole.setRole(role);
        ORMLiteFactcory.getHelper().getUserRoleDao().create(userRole);
    }

    private void initAdminRole(UserManager userManager, User user) throws SQLException {
        if (user.getLogin().equals("Admin")) {
            UserRole userRole1 = new UserRole();
            userRole1.setUser(user);
            Role admin = userManager.getRoleByName("admin");
            userRole1.setRole(admin);
            ORMLiteFactcory.getHelper().getUserRoleDao().create(userRole1);
        }
    }

}

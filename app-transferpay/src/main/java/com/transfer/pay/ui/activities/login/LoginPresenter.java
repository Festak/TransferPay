package com.transfer.pay.ui.activities.login;

import android.view.MenuItem;
import android.view.View;

import com.istatkevich.cmvp.core.BackStackListener;
import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.constants.Constants;
import com.transfer.pay.databinding.LoginBinding;
import com.transfer.pay.models.User;
import com.transfer.pay.ui.TransferPayBasePresenter;

public class LoginPresenter extends TransferPayBasePresenter<LoginViewModel, LoginViewHelper> implements BackStackListener {

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.productionItem:
                Constants.PRODUCTION = true;
                return true;
            case R.id.debugItem:
                Constants.PRODUCTION = false;
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onUserBackPressed() {
        return isFakeAsyncOperationRunning();
    }

    public void onForgotPasswordClick(View view) {
        // do nothing
    }

    public void onBindVariables(LoginBinding binding) {
        binding.setPresenter(this);
        binding.setUser(new User());
    }

    public void onSignUpClick(View view) {
        getRemittanceRouter().openRegistrationActivity();
    }

    public void onLoginButtonClick(View view) {
        performFakeAsyncOperation(new Runnable() {
            @Override
            public void run() {
                if (compareUsers()) {
                    getRemittanceRouter().openTwoFactorAuthActivity();
                } else {
                    getViewHelper().showInvalidLogin();
                }
            }
        });
    }

    private boolean compareUsers() {
        User currentUser = getViewHelper().getBinding().getUser();
        User savedUser = UserManager.getInstance().getUserByName(currentUser.getLogin());

        if (savedUser != null) {
            String currentUserPassword = currentUser.getPassword();
            String savedUserPassword = savedUser.getPassword();

            if (currentUserPassword != null && currentUserPassword.equals(savedUserPassword)) {
                UserManager.getInstance().setUser(savedUser);
                return true;
            }
        }

        return false;
    }

}

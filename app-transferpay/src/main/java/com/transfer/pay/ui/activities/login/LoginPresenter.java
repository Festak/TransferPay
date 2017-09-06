package com.transfer.pay.ui.activities.login;

import android.view.MenuItem;
import android.view.View;

import com.istatkevich.cmvp.core.BackStackListener;
import com.transfer.pay.data.DataStorage;
import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.constants.Fields;
import com.transfer.pay.databinding.LoginBinding;
import com.transfer.pay.models.User;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * @author Created by i.statkevich on 5/24/17.
 */

public class LoginPresenter extends TransferPayBasePresenter<LoginViewModel, LoginViewHelper> implements BackStackListener {

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_spa_settings:
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
        cleanAllData();
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
                UserManager.getInstance().performLogin();
                getRemittanceRouter().openTwoFactorAuthActivity();
            }
        });
    }

    private boolean compareUsers() {
        User currentUser = getViewHelper().getBinding().getUser();
        User savedUser = UserManager.getInstance().getUser();
        String currentUserPassword = currentUser.password.get();
        String currentUserLogin = currentUser.login.get();

        String savedUserPassword = savedUser.password.get();
        String savedUserLogin = savedUser.login.get();

        return true;
    }

    private void cleanAllData() {
        DataStorage.getInstance().removeKey(Fields.Preferences.BENEFICIARIES);
        DataStorage.getInstance().removeKey(Fields.Preferences.CHOOSED_BENEFICIARY);
        DataStorage.getInstance().removeKey(Fields.Preferences.PAYMENT_OPTIONS);
        DataStorage.getInstance().removeKey(Fields.Preferences.USER);
        DataStorage.getInstance().removeKey(Fields.Preferences.SETTINGS);
    }
}

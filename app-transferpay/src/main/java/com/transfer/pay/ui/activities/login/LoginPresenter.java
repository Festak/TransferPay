package com.transfer.pay.ui.activities.login;

import android.view.MenuItem;
import android.view.View;

import com.istatkevich.cmvp.core.BackStackListener;
import com.transfer.pay.data.DataStorage;
import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.constants.Fields;
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
        // Consumes event if isFakeAsyncOperationRunning() = true
        return isFakeAsyncOperationRunning();
    }

    public void onForgotPasswordClick(View view) {
        getViewHelper().showToast("onForgotPasswordClick");
        // TODO: Temp method for removing all data
        cleanAllData();
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

    private void cleanAllData(){
        DataStorage.getInstance().removeKey(Fields.Preferences.BENEFICIARIES);
        DataStorage.getInstance().removeKey(Fields.Preferences.CHOOSED_BENEFICIARY);
        DataStorage.getInstance().removeKey(Fields.Preferences.PAYMENT_OPTIONS);
        DataStorage.getInstance().removeKey(Fields.Preferences.USER);
        DataStorage.getInstance().removeKey(Fields.Preferences.SETTINGS);
    }
}

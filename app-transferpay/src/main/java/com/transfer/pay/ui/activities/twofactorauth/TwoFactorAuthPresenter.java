package com.transfer.pay.ui.activities.twofactorauth;

import android.view.View;
import android.widget.Toast;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.utils.thread.SendEmailAsyncTask;

import java.util.Date;

/**
 * Created by e.fetskovich on 6/7/17.
 */

public class TwoFactorAuthPresenter extends TransferPayBasePresenter<EmptyViewModel, TwoFactorAuthViewHelper> {

    public void onVerifyButtonClick(View v) {
        //loginWithSendEmail();
        loginWithoutSendEmail();
    }

    public void onResendClick() {
        sendEmail(emailCode);
    }

    private String emailCode;

    @Override
    protected void onPresenterReady() {
        super.onPresenterReady();
        emailCode = String.valueOf(new Date().getTime() / 400);
        sendEmail(emailCode);
    }


    private void sendEmail(final String message) {
        final String userEmail = UserManager.getInstance().getUser().email.get();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new SendEmailAsyncTask(message, userEmail).execute();
            }
        });
        thread.start();
        getViewHelper().showToast(R.string.registration_aml_code_send_successfully, Toast.LENGTH_SHORT);
    }

    private void loginWithSendEmail() {
        if (emailCode != null && getViewHelper().getEnteredCodeFromText().equals(emailCode)) {
            getRemittanceRouter().openHomeActivity();
        } else {
            getViewHelper().showToast(R.string.registration_aml_wrong_send_code, Toast.LENGTH_SHORT);
        }
    }

    private void loginWithoutSendEmail() {
        getRemittanceRouter().openHomeActivity();
    }


}

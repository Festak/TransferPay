package com.transfer.pay.ui.activities.twofactorauth;

import android.view.View;
import android.widget.Toast;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.constants.Constants;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.utils.connection.ConnectionChecker;
import com.transfer.pay.utils.thread.SendEmailAsyncTask;

import java.util.Date;

/**
 * Created by e.fetskovich on 6/7/17.
 */

// TODO: To use sending email delete commentaries in this class
public class TwoFactorAuthPresenter extends TransferPayBasePresenter<EmptyViewModel, TwoFactorAuthViewHelper> {

    private ConnectionChecker checker;

    public TwoFactorAuthPresenter(ConnectionChecker checker) {
        this.checker = checker;
    }

    public void onVerifyButtonClick(View v) {
        if (Constants.PRODUCTION) {
            loginWithSendEmail();
        } else {
            loginWithoutSendEmail();
        }
    }


    public void onResendClick() {
        sendEmail(emailCode);
    }

    private String emailCode;

    @Override
    protected void onPresenterReady() {
        super.onPresenterReady();
        if (Constants.PRODUCTION) {
            emailCode = String.valueOf(new Date().getTime() / 400);
            sendEmail(emailCode);
        }
    }


    private void sendEmail(final String message) {
        if (checker.check()) {
            final String userEmail = UserManager.getInstance().getUser().getEmail();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    new SendEmailAsyncTask(message, userEmail).execute();
                }
            });
            thread.start();
            getViewHelper().showToast(R.string.registration_aml_code_send_successfully, Toast.LENGTH_SHORT);
        } else {
            getViewHelper().showToast(R.string.internet_connection_not_found, Toast.LENGTH_SHORT);
        }
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

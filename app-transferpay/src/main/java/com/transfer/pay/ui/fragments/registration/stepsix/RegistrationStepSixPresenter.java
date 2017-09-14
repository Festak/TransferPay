package com.transfer.pay.ui.fragments.registration.stepsix;

import android.widget.Toast;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.activities.registration.RegistrationPresenter;
import com.transfer.pay.utils.connection.ConnectionChecker;
import com.transfer.pay.utils.thread.SendEmailAsyncTask;

import java.util.Date;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepSixPresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepSixViewHelper> {

    private String emailCode;
    private ConnectionChecker checker;

    public RegistrationStepSixPresenter(ConnectionChecker checker) {
        this.checker = checker;
    }

    @Override
    protected void onPresenterReady() {
        super.onPresenterReady();
        emailCode = String.valueOf(new Date().getTime() / 400);
        sendEmail(emailCode);
    }

    public void onVerifyButtonClick() {
        if (emailCode != null && getViewHelper().getEnteredCodeFromText().equals(emailCode)) {
            RegistrationPresenter presenter = getViewHelper().getRegistrationPresenter();
            presenter.onConfirmButtonClick();
        } else {
            getViewHelper().showToast(R.string.registration_aml_wrong_send_code, Toast.LENGTH_SHORT);
        }
    }

    public void onReSendButtonClick() {
        sendEmail(emailCode);
    }

    private void sendEmail(final String message) {
        if(checker.check()) {
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

}

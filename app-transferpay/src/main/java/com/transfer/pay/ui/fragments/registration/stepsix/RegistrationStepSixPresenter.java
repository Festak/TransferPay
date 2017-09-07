package com.transfer.pay.ui.fragments.registration.stepsix;

import android.widget.Toast;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.activities.registration.RegistrationPresenter;
import com.transfer.pay.utils.email.GMailSender;

import java.util.Date;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepSixPresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepSixViewHelper> {

    private String emailCode;

    @Override
    protected void onPresenterReady() {
        super.onPresenterReady();
        sendEmail();
    }

    public void onVerifyButtonClick(){
        // TODO: need to
       // if(emailCode != null && getViewHelper().getEnteredCodeFromText().equals(emailCode)) {
            RegistrationPresenter presenter = getViewHelper().getRegistrationPresenter();
            presenter.onConfirmButtonClick();
     /*   } else {
            getViewHelper().showToast(R.string.registration_aml_wrong_send_code, Toast.LENGTH_SHORT);
        }*/
    }

    public void onReSendButtonClick(){
        sendEmail();
    }

    private void sendEmail(){
        try {
            emailCode = String.valueOf(new Date().getTime()/400);
            GMailSender sender = new GMailSender("rpbafiatskovich@gmail.com", "!Q@w3e4r5");
            sender.sendMail("TransferPay code",
                    "Your auth code: " + emailCode,
                    "fiatskovich.w@gmail.com",
                    "fiatskovich.w@gmail.com");
            getViewHelper().showToast(R.string.registration_aml_code_send_successfully, Toast.LENGTH_SHORT);
        } catch (Exception e) {
            getViewHelper().showToast(R.string.registration_aml_code_send_failed, Toast.LENGTH_SHORT);
        }
    }

}

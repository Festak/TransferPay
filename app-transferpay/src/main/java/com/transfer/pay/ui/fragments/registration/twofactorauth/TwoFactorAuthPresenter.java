package com.transfer.pay.ui.fragments.registration.twofactorauth;

import android.Manifest;
import android.telephony.SmsManager;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.activities.registration.RegistrationPresenter;
import com.transfer.pay.ui.customviews.AdaptiveButtonLayout;

import java.util.Date;

/**
 * Created by e.fetskovich on 6/21/17.
 */

public class TwoFactorAuthPresenter extends TransferPayBasePresenter<EmptyViewModel, TwoFactorAuthViewHelper> {

    private String smsCode;

    @Override
    protected void onPresenterReady() {
        super.onPresenterReady();
        sendSms();
    }

    @Override
    public String[] getRequiredPermissions() {
        return new String[]{
                Manifest.permission.SEND_SMS
        };
    }


    public void onVerifyButtonClick() {
        if (smsCode != null && smsCode.equals(getViewHelper().getTwoFactorEnteredNumber())) {
            RegistrationPresenter presenter = getViewHelper().getRegistrationPresenter();
            presenter.onConfirmButtonClick();
            presenter.getViewData().putAdaptiveButtonType(AdaptiveButtonLayout.ONE_BUTTON);
        } else {
            getViewHelper().showToast(R.string.registration_aml_two_factor_auth_sms_validation);
        }
    }

    private void sendSms() {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsCode = String.valueOf((int) new Date().getTime() / 400);
            String userNumber = UserManager.getInstance().getUser().getMobileNumber();
            smsManager.sendTextMessage(userNumber, null, smsCode, null, null);
            getViewHelper().showToast(R.string.registration_aml_two_factor_auth_sms_ok);
        } catch (Exception e) {
            getViewHelper().showToast(R.string.registration_aml_two_factor_auth_sms_wrong);
        }
    }

}

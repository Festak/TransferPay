package com.transfer.pay.ui.activities.twofactorauth;

import android.view.View;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * Created by e.fetskovich on 6/7/17.
 */

public class TwoFactorAuthPresenter extends TransferPayBasePresenter<EmptyViewModel, TwoFactorAuthViewHelper> {

    public void onVerifyButtonClick(View v) {
        getRemittanceRouter().openHomeActivity();
    }

    public void onResendClick() {
        // do nothing
    }

}

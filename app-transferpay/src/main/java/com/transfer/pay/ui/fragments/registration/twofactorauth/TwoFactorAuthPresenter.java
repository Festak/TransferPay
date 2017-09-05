package com.transfer.pay.ui.fragments.registration.twofactorauth;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.activities.registration.RegistrationPresenter;
import com.transfer.pay.ui.customviews.AdaptiveButtonLayout;

/**
 * Created by e.fetskovich on 6/21/17.
 */

public class TwoFactorAuthPresenter extends TransferPayBasePresenter<EmptyViewModel, TwoFactorAuthViewHelper> {

    public void onVerifyButtonClick(){
        RegistrationPresenter presenter = getViewHelper().getRegistrationPresenter();
        presenter.onConfirmButtonClick();
        presenter.getViewData().putAdaptiveButtonType(AdaptiveButtonLayout.ONE_BUTTON);
    }

}

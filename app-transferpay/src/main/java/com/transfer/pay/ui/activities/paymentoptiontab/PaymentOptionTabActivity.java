package com.transfer.pay.ui.activities.paymentoptiontab;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseActivity;

/**
 * @author e.fetskovich on 11/1/17.
 */

public class PaymentOptionTabActivity extends TransferPayBaseActivity<EmptyViewModel, PaymentOptionTabViewHelper, PaymentOptionTabPresenter> {

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected PaymentOptionTabPresenter createPresenter() {
        return new PaymentOptionTabPresenter();
    }

    @Override
    protected PaymentOptionTabViewHelper createViewHelper() {
        return new PaymentOptionTabViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Activity.PAYMENT_OPTION_TAB_ACTIVITY;
    }
}

package com.transfer.pay.ui.fragments.paymentoptions;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class PaymentOptionsFragment extends TransferPayBaseFragment<EmptyViewModel, PaymentOptionsViewHelper, PaymentOptionsPresenter> {

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected PaymentOptionsPresenter createPresenter() {
        return new PaymentOptionsPresenter();
    }

    @Override
    protected PaymentOptionsViewHelper createViewHelper() {
        return new PaymentOptionsViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.PAYMENT_OPTIONS;
    }
}

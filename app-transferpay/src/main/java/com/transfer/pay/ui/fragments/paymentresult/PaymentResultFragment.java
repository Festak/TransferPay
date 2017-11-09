package com.transfer.pay.ui.fragments.paymentresult;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * @author e.fetskovich on 11/9/17.
 */

public class PaymentResultFragment extends TransferPayBaseFragment<EmptyViewModel, PaymentResultViewHelper, PaymentResultPresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected PaymentResultPresenter createPresenter() {
        return new PaymentResultPresenter();
    }

    @Override
    protected PaymentResultViewHelper createViewHelper() {
        return new PaymentResultViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.PAYMENT_RESULT;
    }
}

package com.transfer.pay.ui.fragments.paymentresult;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.PaymentResultFragmentBinding;

/**
 * @author e.fetskovich on 11/9/17.
 */

public class PaymentResultViewHelper extends ViewHelper<PaymentResultPresenter, PaymentResultFragmentBinding> {

    @Override
    protected void onBindVariables(PaymentResultFragmentBinding binding) {
        super.onBindVariables(binding);
    }

    @Override
    protected void onInitView() {
        super.onInitView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.payment_result_fragment;
    }
}

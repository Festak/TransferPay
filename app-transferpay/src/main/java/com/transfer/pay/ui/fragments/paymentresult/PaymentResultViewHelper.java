package com.transfer.pay.ui.fragments.paymentresult;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.SharedPreferenceConstants;
import com.transfer.pay.databinding.PaymentResultFragmentBinding;
import com.transfer.pay.utils.SharedPreferenceHelper;

/**
 * @author e.fetskovich on 11/9/17.
 */

public class PaymentResultViewHelper extends ViewHelper<PaymentResultPresenter, PaymentResultFragmentBinding> {

    @Override
    protected void onBindVariables(PaymentResultFragmentBinding binding) {
        getPresenter().onBindVariables(binding);
    }

    @Override
    protected void onInitView() {
        super.onInitView();
        initPaymentResult();
    }

    private void initPaymentResult() {
        String text;
        Context context = getRoot().getContext();
        TextView paymentResultText = getBinding().paymentResultText;
        if (SharedPreferenceHelper.readPreferenceBoolean(context, SharedPreferenceConstants.PAYMENT_RESULT, false)) {
            text = context.getString(R.string.payment_result_successfully);
            paymentResultText.setTextColor(Color.GREEN);
        } else {
            text = context.getString(R.string.payment_result_wrong);
            paymentResultText.setTextColor(Color.RED);
        }
        paymentResultText.setText(text);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.payment_result_fragment;
    }
}

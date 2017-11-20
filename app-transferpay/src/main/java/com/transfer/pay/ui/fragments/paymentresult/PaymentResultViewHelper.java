package com.transfer.pay.ui.fragments.paymentresult;

import android.os.AsyncTask;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.SharedPreferenceConstants;
import com.transfer.pay.databinding.PaymentResultFragmentBinding;
import com.transfer.pay.ui.customviews.ViewFactory;
import com.transfer.pay.ui.customviews.authresult.AuthResultView;
import com.transfer.pay.ui.customviews.authresult.AuthStatus;
import com.transfer.pay.utils.SharedPreferenceHelper;

import java.util.concurrent.TimeUnit;

/**
 * @author e.fetskovich on 11/9/17.
 */

public class PaymentResultViewHelper extends ViewHelper<PaymentResultPresenter, PaymentResultFragmentBinding>
        implements AuthResultView {

    @Override
    protected void onBindVariables(PaymentResultFragmentBinding binding) {
        getPresenter().onBindVariables(binding);
    }

    private AuthResultView delegateAuthResultView;
    private boolean paymentResultSuccess;

    @Override
    protected void onInitView() {
        super.onInitView();
        delegateAuthResultView = ViewFactory.createAuthResultView(getActivityContainer());
        initPaymentResultValue();
        initPaymentResultDialog();
    }

    private void initPaymentResultDialog() {
        showAuthResult();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (paymentResultSuccess) {
                    switchState(AuthStatus.SUCCESSFUL);
                } else {
                    switchState(AuthStatus.ERROR);
                }
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
        showAuthResult();
    }

    public boolean initPaymentResultValue(){
        this.paymentResultSuccess = SharedPreferenceHelper.readPreferenceBoolean(
                getRoot().getContext(),
                SharedPreferenceConstants.PAYMENT_RESULT, false
        );
        return paymentResultSuccess;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.payment_result_fragment;
    }

    @Override
    public void showAuthResult() {
        delegateAuthResultView.showAuthResult();
    }

    @Override
    public void switchState(AuthStatus authStatus) {
        delegateAuthResultView.switchState(authStatus);
    }
}

package com.transfer.pay.ui.fragments.paymentoptions;

import android.content.Intent;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

import static android.app.Activity.RESULT_OK;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class PaymentOptionsFragment extends TransferPayBaseFragment<EmptyViewModel, PaymentOptionsViewHelper, PaymentOptionsPresenter> {

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            getPresenter().onActivityResultFromFragment(data, requestCode);
        }
    }

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

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onPresenterReady();
    }
}

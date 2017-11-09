package com.transfer.pay.ui.fragments.transactionoverview;

import android.content.Intent;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

import static android.app.Activity.RESULT_OK;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class TransactionOverviewFragment extends TransferPayBaseFragment<EmptyViewModel, TransactionOverviewViewHelper, TransactionOverviewPresenter> {

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == TransactionOverviewViewHelper.SNAKE_INTENT) {
                boolean result = data.getBooleanExtra("result", false);
                getPresenter().operateResult(result);
            }
        }
    }

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected TransactionOverviewPresenter createPresenter() {
        return new TransactionOverviewPresenter();
    }

    @Override
    protected TransactionOverviewViewHelper createViewHelper() {
        return new TransactionOverviewViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.TRANSACTION_OVERVIEW;
    }
}

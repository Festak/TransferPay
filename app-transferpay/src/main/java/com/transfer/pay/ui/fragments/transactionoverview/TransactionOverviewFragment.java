package com.transfer.pay.ui.fragments.transactionoverview;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class TransactionOverviewFragment extends TransferPayBaseFragment<EmptyViewModel, TransactionOverviewViewHelper, TransactionOverviewPresenter> {

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

package com.transfer.pay.ui.fragments.transactionhistory;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class TransactionHistoryFragment extends TransferPayBaseFragment<EmptyViewModel, TransactionHistoryViewHelper, TransactionHistoryPresenter> {

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected TransactionHistoryPresenter createPresenter() {
        return new TransactionHistoryPresenter();
    }

    @Override
    protected TransactionHistoryViewHelper createViewHelper() {
        return new TransactionHistoryViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.BENEFICIARIES;
    }
}

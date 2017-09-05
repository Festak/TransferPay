package com.transfer.pay.ui.fragments.transactionhistory;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.TransactionHistoryBinding;

/**
 * Created by i.statkevich on 5/25/17.
 */


public class TransactionHistoryViewHelper extends ViewHelper<TransactionHistoryPresenter, TransactionHistoryBinding> {

    @Override
    protected void onInitView() {
        super.onInitView();
    }

    @Override
    protected void onBindVariables(TransactionHistoryBinding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.transaction_history;
    }

}

package com.transfer.pay.ui.fragments.transactionhistory;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.databinding.TransactionHistoryBinding;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class TransactionHistoryPresenter extends TransferPayBasePresenter<EmptyViewModel, TransactionHistoryViewHelper> {

    public void bindVariables(TransactionHistoryBinding binding) {
        binding.setPresenter(this);
    }

}

package com.transfer.pay.ui.list.binder;

import com.transfer.pay.R;
import com.transfer.pay.databinding.TransactionHistoryItemBinding;
import com.transfer.pay.models.Transaction;

/**
 * @author e.fetskovich on 10/26/17.
 */

public class HistoryItemBinder implements ViewHolderBinder<TransactionHistoryItemBinding, Transaction> {
    @Override
    public int getLayoutId() {
        return R.layout.transaction_history_item;
    }

    @Override
    public void bindHolder(TransactionHistoryItemBinding binding, Transaction item, int position) {
        binding.setTransaction(item);
    }
}

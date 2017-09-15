package com.transfer.pay.ui.list.binder;

import com.transfer.pay.R;
import com.transfer.pay.databinding.BeneficiaryItemBankAccountBinding;
import com.transfer.pay.models.BankAccountModel;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;
import com.transfer.pay.ui.list.listener.OnItemClickListener;
import com.transfer.pay.ui.list.listener.OnLongItemClickListener;

/**
 * Created by i.statkevich on 6/2/17.
 */

public class BeneficiaryBankAccountBinder implements ViewHolderBinder<BeneficiaryItemBankAccountBinding, BankAccountModel> {

    private OnClickedItemListener listener;
    private OnClickedItemListener onLongItemClickListener;

    public BeneficiaryBankAccountBinder(OnClickedItemListener listener, OnClickedItemListener longItemClickListener) {
        this.listener = listener;
        this.onLongItemClickListener = longItemClickListener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.beneficiary_item_bank_account;
    }

    @Override
    public void bindHolder(BeneficiaryItemBankAccountBinding binding, BankAccountModel item, int position) {
        binding.setModel(item);

        OnItemClickListener itemClickedListener = new OnItemClickListener(listener, position);
        binding.setListener(itemClickedListener);

        OnLongItemClickListener onLongItemClickListener = new OnLongItemClickListener(listener, position);
        binding.setLongListener(onLongItemClickListener);

    }
}

package com.transfer.pay.ui.list.binder;

import com.transfer.pay.R;
import com.transfer.pay.databinding.BeneficiaryItemCreditCardBinding;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;
import com.transfer.pay.ui.list.listener.OnItemClickListener;
import com.transfer.pay.ui.list.listener.OnLongItemClickListener;

/**
 * Created by i.statkevich on 6/2/17.
 */

public class BeneficiaryCreditCardBinder implements ViewHolderBinder<BeneficiaryItemCreditCardBinding, CreditCardModel> {

    private OnClickedItemListener listener;
    private OnClickedItemListener onLongItemClickListener;

    public BeneficiaryCreditCardBinder(OnClickedItemListener listener, OnClickedItemListener onLongItemClickListener) {
        this.listener = listener;
        this.onLongItemClickListener = onLongItemClickListener;

    }

    @Override
    public int getLayoutId() {
        return R.layout.beneficiary_item_credit_card;
    }

    @Override
    public void bindHolder(BeneficiaryItemCreditCardBinding binding, CreditCardModel item, int position) {
        binding.setModel(item);

        OnItemClickListener itemClickedListener = new OnItemClickListener(listener, position);
        binding.setListener(itemClickedListener);

        OnLongItemClickListener onLongItemClickListener = new OnLongItemClickListener(listener, position);
        binding.setLongListener(onLongItemClickListener);

    }
}

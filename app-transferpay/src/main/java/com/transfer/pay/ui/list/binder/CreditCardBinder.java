package com.transfer.pay.ui.list.binder;

import com.transfer.pay.R;
import com.transfer.pay.databinding.CreditCardItemBinding;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;
import com.transfer.pay.ui.list.listener.OnItemClickListener;
import com.transfer.pay.ui.list.listener.OnLongItemClickListener;

/**
 * Created by e.fetskovich on 6/7/17.
 */

public class CreditCardBinder implements ViewHolderBinder<CreditCardItemBinding, CreditCardModel> {

    private OnClickedItemListener listener;
    private OnClickedItemListener longListener;

    public CreditCardBinder(OnClickedItemListener listener, OnClickedItemListener longListener) {
        this.listener = listener;
        this.longListener = longListener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.credit_card_item;
    }

    @Override
    public void bindHolder(CreditCardItemBinding binding, CreditCardModel item, int position) {
        binding.setModel(item);

        OnItemClickListener itemClickedListener = new OnItemClickListener(listener, position);
        binding.setListener(itemClickedListener);

        OnLongItemClickListener longItemClickListener = new OnLongItemClickListener(listener, position);
        binding.setLongListener(longItemClickListener);

    }

}

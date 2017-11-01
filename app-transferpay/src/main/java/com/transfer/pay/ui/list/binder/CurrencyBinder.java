package com.transfer.pay.ui.list.binder;

import com.transfer.pay.R;
import com.transfer.pay.databinding.CurrencyItemBinding;
import com.transfer.pay.models.Currency;

/**
 * @author e.fetskovich on 11/1/17.
 */

public class CurrencyBinder implements ViewHolderBinder<CurrencyItemBinding, Currency> {
    @Override
    public int getLayoutId() {
        return R.layout.currency_item;
    }

    @Override
    public void bindHolder(CurrencyItemBinding binding, Currency item, int position) {
        binding.setCurrency(item);
    }
}

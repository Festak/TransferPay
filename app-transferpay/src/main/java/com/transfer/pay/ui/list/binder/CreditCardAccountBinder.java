package com.transfer.pay.ui.list.binder;

import com.transfer.pay.R;
import com.transfer.pay.databinding.BeneficiaryItemCreditAccountCardBinding;
import com.transfer.pay.models.CreditCardAccountModel;
import com.transfer.pay.models.CreditCardTypeLayout;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;
import com.transfer.pay.ui.list.listener.OnItemClickListener;
import com.transfer.pay.ui.list.listener.OnLongItemClickListener;

/**
 * @author e.fetskovich on 10/24/17.
 */

public class CreditCardAccountBinder implements ViewHolderBinder<BeneficiaryItemCreditAccountCardBinding, CreditCardAccountModel> {
    private OnClickedItemListener listener;
    private OnClickedItemListener onLongItemClickListener;

    public CreditCardAccountBinder(OnClickedItemListener listener, OnClickedItemListener longItemClickListener) {
        this.listener = listener;
        this.onLongItemClickListener = longItemClickListener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.beneficiary_item_credit_account_card;
    }

    @Override
    public void bindHolder(BeneficiaryItemCreditAccountCardBinding binding, CreditCardAccountModel item, int position) {
        binding.setModel(item);

        OnItemClickListener itemClickedListener = new OnItemClickListener(listener, position);
        binding.setListener(itemClickedListener);

        OnLongItemClickListener onLongItemClickListener = new OnLongItemClickListener(listener, position);
        binding.setLongListener(onLongItemClickListener);

        initCreditCardTypeByItem(binding, item);

    }

    private void initCreditCardTypeByItem(BeneficiaryItemCreditAccountCardBinding binding, CreditCardAccountModel item) {
        CreditCardTypeLayout creditCardTypeLayout = new CreditCardTypeLayout();
        if (item.getCardType().equals("VISA_CARD")) {
            creditCardTypeLayout.setVisa(true);
        } else if (item.getCardType().equals("MASTER_CARD")) {
            creditCardTypeLayout.setMaster(true);
        } else if (item.getCardType().equals("AMEX_CARD")) {
            creditCardTypeLayout.setAmex(true);
        } else {
            creditCardTypeLayout.setDefaultType(true);
        }

        binding.setCreditCardTypeLayout(creditCardTypeLayout);

    }

}

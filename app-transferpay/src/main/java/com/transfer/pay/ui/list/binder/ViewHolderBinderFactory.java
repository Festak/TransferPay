package com.transfer.pay.ui.list.binder;

import com.transfer.pay.ui.list.ListItemType;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;

public class ViewHolderBinderFactory implements BinderFactory {

    private OnClickedItemListener listener;
    private OnClickedItemListener longListener;

    public ViewHolderBinderFactory(OnClickedItemListener listener, OnClickedItemListener longListener) {
        this.listener = listener;
        this.longListener = longListener;
    }

    public ViewHolderBinderFactory() {
        // do nothing
    }

    @Override
    public ViewHolderBinder create(ListItemType type) {
        switch (type) {
            case BENEFICIARY_CREDIT_CARD:
                return new BeneficiaryCreditCardBinder(listener, longListener);
            case BENEFICIARY_BANK_ACCOUNT:
                return new BeneficiaryBankAccountBinder(listener, longListener);
            case CREDIT_CARD:
                return new CreditCardBinder(listener, longListener);
            case UNDEFINED:
            default:
                return null;
        }
    }
}

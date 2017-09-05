package com.transfer.pay.ui.list.binder;

import com.transfer.pay.ui.list.ListItemType;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;

/**
 * Created by i.statkevich on 6/2/17.
 */

public class ViewHolderBinderFactory implements BinderFactory {

    private OnClickedItemListener listener;

    public ViewHolderBinderFactory(OnClickedItemListener listener) {
        this.listener = listener;
    }

    public ViewHolderBinderFactory() {
        // do nothing
    }

    @Override
    public ViewHolderBinder create(ListItemType type) {
        switch (type) {
            case BENEFICIARY_CREDIT_CARD:
                return new BeneficiaryCreditCardBinder(listener);
            case BENEFICIARY_BANK_ACCOUNT:
                return new BeneficiaryBankAccountBinder(listener);
            case CREDIT_CARD:
                return new CreditCardBinder(listener);
            case UNDEFINED:
            default:
                return null;
        }
    }
}

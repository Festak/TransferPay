package com.transfer.pay.ui.fragments.paymentoptions;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class PaymentOptionsPresenter extends TransferPayBasePresenter<EmptyViewModel, PaymentOptionsViewHelper> {

    @Override
    protected void onPresenterReady() {
        getViewHelper().updateData(DataManager.getInstance().getCreditCardModels());
    }

    public void onNewCreditCardClick() {
        getViewHelper().openFragmentId(TransferPayFragmentFactory.ID_ADD_CARD);
    }

    @Override
    public void onActivityResume() {
        super.onActivityResume();
        getViewHelper().notifyDataInRecyclerChanged();
    }
}

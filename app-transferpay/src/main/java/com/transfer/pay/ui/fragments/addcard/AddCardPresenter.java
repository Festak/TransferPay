package com.transfer.pay.ui.fragments.addcard;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.databinding.AddCardBinding;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class AddCardPresenter extends TransferPayBasePresenter<EmptyViewModel, AddCardViewHelper> {

    @Override
    protected void onPresenterReady() {
        super.onPresenterReady();
    }

    public void onSaveButtonClick(final CreditCardModel card) {
        performFakeAsyncOperation(new Runnable() {
            @Override
            public void run() {
                DataManager.getInstance().insertCreditCard(card);
                getScreen().closeScreen();
            }
        });

    }

    public void bindVariables(AddCardBinding binding) {
        binding.setPresenter(this);
        binding.setCard(new CreditCardModel());
    }

}

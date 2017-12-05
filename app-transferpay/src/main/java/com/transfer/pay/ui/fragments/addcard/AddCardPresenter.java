package com.transfer.pay.ui.fragments.addcard;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.TempDataManager;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.AddCardBinding;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.ormlite.ORMLiteFactcory;
import com.transfer.pay.ui.TransferPayBasePresenter;

import java.sql.SQLException;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class AddCardPresenter extends TransferPayBasePresenter<EmptyViewModel, AddCardViewHelper> {

    @Override
    protected void onPresenterReady() {
        super.onPresenterReady();
    }

    public void bindVariables(AddCardBinding binding) {
        binding.setPresenter(this);
        binding.setCard(TempDataManager.getDataManager().getCreditCardModel());
    }

    public void changeCardHolder(){
        CreditCardModel creditCardModel = getViewHelper().getBinding().getCard();
        try {
            ORMLiteFactcory.getHelper().getCreditCardDao().update(creditCardModel);
            UserManager.getInstance().updateUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

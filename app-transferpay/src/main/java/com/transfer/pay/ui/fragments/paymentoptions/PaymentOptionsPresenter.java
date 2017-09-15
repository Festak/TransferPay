package com.transfer.pay.ui.fragments.paymentoptions;

import android.content.Intent;

import com.cooltechworks.creditcarddesign.CreditCardUtils;
import com.cooltechworks.creditcarddesign.CreditCardView;
import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class PaymentOptionsPresenter extends TransferPayBasePresenter<EmptyViewModel, PaymentOptionsViewHelper> {

    @Override
    protected void onPresenterReady() {
        getViewHelper().updateData(DataManager.getInstance().getCreditCardModels());
    }

    public void onNewCreditCardClick() {
       // getViewHelper().openFragmentId(TransferPayFragmentFactory.ID_ADD_CARD);
        getViewHelper().addCreditCardIntent();
    }

    public void onActivityResultFromFragment(Intent data, int requestCode){
        String name = data.getStringExtra(CreditCardUtils.EXTRA_CARD_HOLDER_NAME);
        String cardNumber = data.getStringExtra(CreditCardUtils.EXTRA_CARD_NUMBER);
        String expiry = data.getStringExtra(CreditCardUtils.EXTRA_CARD_EXPIRY);
        String cvv = data.getStringExtra(CreditCardUtils.EXTRA_CARD_CVV);

        if (requestCode == PaymentOptionsViewHelper.CREATE_NEW_CARD) {

            CreditCardView creditCardView = new CreditCardView(getViewHelper().getRoot().getContext());

            creditCardView.setCVV(cvv);
            creditCardView.setCardHolderName(name);
            creditCardView.setCardExpiry(expiry);
            creditCardView.setCardNumber(cardNumber);

            DataManager.getInstance().insertCreditCard(initCreditCardModel(creditCardView));
            getViewHelper().notifyDataInRecyclerChanged();

        }
    }

    private CreditCardModel initCreditCardModel(CreditCardView cardView){
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setValidDate(cardView.getExpiry());
        creditCardModel.setCVV(cardView.getCVV());
        creditCardModel.setCardHolderName(cardView.getCardHolderName());
        creditCardModel.setCreditCardNumber(cardView.getCardNumber());
        creditCardModel.setCardType(creditCardModel.getCardType());
        return creditCardModel;
    }

}

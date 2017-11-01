package com.transfer.pay.ui.fragments.carddata;

import android.view.View;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.TempDataManager;
import com.transfer.pay.databinding.CardDataBinding;
import com.transfer.pay.models.CreditCardData;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.models.Currency;
import com.transfer.pay.ormlite.ORMLiteFactcory;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.utils.Converter;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 11/1/17.
 */

public class CardDataPresenter extends TransferPayBasePresenter<EmptyViewModel, CardDataViewHelper> {

    private List<Currency> currencyList = null;

    @Override
    protected void onPresenterReady() {
        super.onPresenterReady();
        initCurrencies();
        if (currencyList != null) {
            getViewHelper().updateData(currencyList);
            getViewHelper().initSpinnerList(currencyList);
        }
    }

    public void onSaveButtonClick() {
        CardDataBinding binding = getViewHelper().getBinding();
        setCreditCardData((Currency) binding.currenciesToChose.getSelectedItem(), binding.money.getText().toString());
    }

    public void setCreditCardData(Currency currency, String money) {
        double moneyToAdd = Converter.convertStringToDouble(money);

        if (currency != null) {
            addCardDataToCardModel(currency, moneyToAdd);
        }
    }

    public void initCardDataFields(CardDataBinding cardDataBinding) {
        CreditCardModel model = TempDataManager.getDataManager().getCreditCardModel();

        if (model.getCreditCardData() == null || model.getCreditCardData().getCurrency() == null) {
            cardDataBinding.userCurrency.setVisibility(View.GONE);
            cardDataBinding.currenciesToChose.setVisibility(View.VISIBLE);
            cardDataBinding.totalMoney.setText("0");
        } else {
            cardDataBinding.currenciesToChose.setVisibility(View.GONE);
            cardDataBinding.userCurrency.setVisibility(View.VISIBLE);
            cardDataBinding.userCurrency.setText(String.valueOf(model.getCreditCardData().getCurrency().getName()));
            cardDataBinding.totalMoney.setText(String.valueOf(model.getCreditCardData().getMoney()));
        }

    }

    private void addCardDataToCardModel(Currency currency, double money) {
        CreditCardModel model = TempDataManager.getDataManager().getCreditCardModel();
        if (model != null) {
            CreditCardData cardData = model.getCreditCardData();
            if (cardData == null) {
                cardData = new CreditCardData();
            }
            if (cardData.getCurrency() == null) {
                cardData.setCurrency(currency);
                getViewHelper().getBinding().currenciesToChose.setVisibility(View.GONE);
            }

            double totalMoney = cardData.getMoney() + money;

            cardData.setMoney(totalMoney);
            getViewHelper().getBinding().totalMoney.setText(String.valueOf(totalMoney));

            try {
                ORMLiteFactcory.getHelper().getCreditCardDataDao().createOrUpdate(cardData);
                CreditCardModel creditCardModel = ORMLiteFactcory.getHelper().getCreditCardDao().getCreditCardModel(model.getCreditCardNumber());
                creditCardModel.setCreditCardData(cardData);
                ORMLiteFactcory.getHelper().getCreditCardDao().refresh(model);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            model.setCreditCardData(cardData);
        }
    }

    private void initCurrencies() {
        try {
            currencyList = ORMLiteFactcory.getHelper().getCurrencyDao().getCurrencies();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

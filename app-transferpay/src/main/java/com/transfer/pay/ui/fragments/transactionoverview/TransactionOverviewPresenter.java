package com.transfer.pay.ui.fragments.transactionoverview;

import android.widget.Toast;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.TempDataManager;
import com.transfer.pay.UserManager;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.databinding.TransactionOverviewBinding;
import com.transfer.pay.models.CreditCardData;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.models.Transaction;
import com.transfer.pay.models.User;
import com.transfer.pay.ormlite.ORMLiteFactcory;
import com.transfer.pay.ui.TransferPayBasePresenter;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class TransactionOverviewPresenter extends TransferPayBasePresenter<EmptyViewModel, TransactionOverviewViewHelper> {

    private Transaction transaction;

    public void onPayNowClick(final Transaction transaction) {
        this.transaction = transaction;
        performFakeAsyncOperation(new Runnable() {
            @Override
            public void run() {
                if (transaction.getPaymentOption().getCreditCardDataOne() != null) {
                    if (transaction.getYouSend() / transaction.getExchangeRate() > 10) {
                        if (transaction.
                                getPaymentOption().
                                getCreditCardDataOne().
                                getMoney() / transaction.getExchangeRate() > com.transfer.pay.utils.Converter
                                .convertStringToDouble(transaction.getExchangeAmount())) {

                            getViewHelper().startSnakeIntent();

                   /*         transaction.setTransactionDate(new Date().toString());
                            UserManager.getInstance().insertTransaction(transaction);
                            calculateNewUserMoney(transaction);
                            UserManager.getInstance().updateUser();
                            getViewHelper().changeFragment(TransferPayFragmentFactory.ID_PAYMENT_RESULT);*/


                        } else {
                            getViewHelper().showNotEnoughMoneyMessage();
                        }
                    } else {
                        getViewHelper().showMinimumSendMessage();
                    }
                } else {
                    getViewHelper().showToast(R.string.validation_card_data, Toast.LENGTH_LONG);
                }
            }
        });
    }

    public Transaction initTransaction() {
        Transaction transaction = new Transaction(DataManager.getInstance().getSettings().getTransactionParams());

        transaction.setBankAccount(TempDataManager.getDataManager().getBankAccountModel());
        transaction.setCreditCard(TempDataManager.getDataManager().getCreditCardAccountModel());
        TempDataManager.getDataManager().deleteAllData();
        return transaction;
    }

    public void bindVariables(TransactionOverviewBinding binding) {
        binding.setPresenter(this);
        binding.setTransaction(initTransaction());
        binding.setHasPaymentOptions(isUserHasPaymentOptions());
    }

    public List<CreditCardModel> getPaymentOptions() {
        Collection<CreditCardModel> cards = UserManager.getInstance().getUser().getCreditCards();
        List<CreditCardModel> creditCardModels = new LinkedList<>();
        for (CreditCardModel model : cards) {
            creditCardModels.add(model);
        }
        return creditCardModels;
    }

    public void operateResult(boolean result) {
        if (result) {
            getViewHelper().showToast("Одобрено");
        } else {
            getViewHelper().showToast("Не одобрено");
        }
    }

    private void calculateNewUserMoney(final Transaction transaction) {
        CreditCardModel creditCardModel = UserManager.getInstance().getCreditCardById(transaction.getPaymentOption().getCreditCardId());
        CreditCardData creditCardData = creditCardModel.getCreditCardDataOne();
        creditCardData.setMoney(creditCardData.getMoney() - transaction.getYouSend());

        try {
            ORMLiteFactcory.getHelper().getCreditCardDataDao().createOrUpdate(creditCardData);
            ORMLiteFactcory.getHelper().getCreditCardDao().refresh(creditCardModel);
            ORMLiteFactcory.getHelper().getUserDao().refresh(UserManager.getInstance().getUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private boolean isUserHasPaymentOptions() {
        User user = UserManager.getInstance().getUser();
        return user.getCreditCards() != null && user.getCreditCards().size() > 0;
    }

}

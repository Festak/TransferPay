package com.transfer.pay.ui.fragments.transactionoverview;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.TempDataManager;
import com.transfer.pay.UserManager;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.databinding.TransactionOverviewBinding;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.models.Transaction;
import com.transfer.pay.models.User;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class TransactionOverviewPresenter extends TransferPayBasePresenter<EmptyViewModel, TransactionOverviewViewHelper> {

    public void onPayNowClick(final Transaction transaction) {
        performFakeAsyncOperation(new Runnable() {
            @Override
            public void run() {
                transaction.setTransactionDate(new Date().toString());
                UserManager.getInstance().insertTransaction(transaction);
                UserManager.getInstance().updateUser();
                User user = UserManager.getInstance().getUser();
                getViewHelper().changeFragment(TransferPayFragmentFactory.ID_TRANSACTION_HISTORY);

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
    }

    public List<CreditCardModel> getPaymentOptions() {
        Collection<CreditCardModel> cards = UserManager.getInstance().getUser().getCreditCards();
        List<CreditCardModel> creditCardModels = new LinkedList<>();
        for (CreditCardModel model : cards) {
            creditCardModels.add(model);
        }
        return creditCardModels;
    }

}

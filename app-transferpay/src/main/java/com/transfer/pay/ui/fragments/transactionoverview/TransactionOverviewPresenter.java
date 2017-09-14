package com.transfer.pay.ui.fragments.transactionoverview;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.data.DataStorage;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.TransactionOverviewBinding;
import com.transfer.pay.models.BankAccountModel;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.models.Transaction;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;
import com.transfer.pay.ui.list.ListItemData;
import com.transfer.pay.ui.list.ListItemType;

import java.util.Date;
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
                UserManager.getInstance().createTransaction(transaction);
                getViewHelper().changeFragment(TransferPayFragmentFactory.ID_TRANSACTION_HISTORY);
            }
        });
    }

    public Transaction initTransaction() {
        Transaction transaction = new Transaction(DataManager.getInstance().getSettings().getTransactionParams());
        ListItemData model = DataStorage.getInstance().loadChoosedBeneficiary();
        Object object = model.getData();

        if (model.getType() == ListItemType.BENEFICIARY_BANK_ACCOUNT) {
            transaction.setBankAccount((BankAccountModel)object);
        } else if (model.getType() == ListItemType.BENEFICIARY_CREDIT_CARD) {
            transaction.setCreditCard((CreditCardModel)object);
        }
        return transaction;
    }

    public void bindVariables(TransactionOverviewBinding binding) {
        binding.setPresenter(this);
        binding.setTransaction(initTransaction());
    }

    public List<CreditCardModel> getPaymentOptions() {
        return DataManager.getInstance().getCreditCardModels();
    }

}

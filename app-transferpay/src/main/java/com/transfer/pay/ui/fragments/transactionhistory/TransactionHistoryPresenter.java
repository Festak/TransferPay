package com.transfer.pay.ui.fragments.transactionhistory;

import android.util.Log;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.TransactionHistoryBinding;
import com.transfer.pay.models.User;
import com.transfer.pay.ormlite.ORMLiteFactcory;
import com.transfer.pay.ui.TransferPayBasePresenter;

import java.sql.SQLException;

public class TransactionHistoryPresenter extends TransferPayBasePresenter<EmptyViewModel, TransactionHistoryViewHelper> {

    private static final String TAG = "TransactionHistoryPrese";

    @Override
    protected void onPresenterReady() {
        getViewHelper().updateData(UserManager.getInstance().getUser().getTransactions());
    }

    public void bindVariables(TransactionHistoryBinding binding) {
        binding.setPresenter(this);
    }

    public void onAllTransactionDeleteClick() {
        Log.i(TAG, "onAllTransactionDeleteClick: ");
        User user = UserManager.getInstance().getUser();
        user.getTransactions().clear();
        try {
            ORMLiteFactcory.getHelper().getUserDao().update(user);
            UserManager.getInstance().updateUser();
            getViewHelper().updateData(UserManager.getInstance().getUser().getTransactions());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

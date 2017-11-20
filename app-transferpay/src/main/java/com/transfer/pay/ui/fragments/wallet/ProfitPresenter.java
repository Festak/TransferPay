package com.transfer.pay.ui.fragments.wallet;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.databinding.WalletBinding;
import com.transfer.pay.models.TransactionFeeProfit;
import com.transfer.pay.ormlite.ORMLiteFactcory;
import com.transfer.pay.ui.TransferPayBasePresenter;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ProfitPresenter extends TransferPayBasePresenter<EmptyViewModel, ProfitViewHelper> {

    @Override
    protected void onPresenterReady() {
        super.onPresenterReady();
        getViewHelper().getBinding().yourProfit.setText(String.valueOf(calculateTotalFeeCount()));
    }

    public void bindVariables(WalletBinding binding) {
        binding.setPresenter(this);
    }

    public double calculateTotalFeeCount() {
        double totalFee = 0;
        List<TransactionFeeProfit> list = new LinkedList<>();
        try {
            list = ORMLiteFactcory.getHelper().getTransactionFeeProfitsDao().getAllTransactions();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (TransactionFeeProfit transactionFeeProfit : list) {
            totalFee += transactionFeeProfit.getFeeProfit();
        }
        return totalFee;
    }

}

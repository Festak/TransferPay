package com.transfer.pay.ui.fragments.wallet;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.transfer.pay.databinding.WalletBinding;
import com.transfer.pay.models.TransactionFeeProfit;
import com.transfer.pay.ormlite.ORMLiteFactcory;
import com.transfer.pay.ui.TransferPayBasePresenter;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
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

    public LineGraphSeries<DataPoint> getListOfPoints() {
        List<TransactionFeeProfit> list = getListOfProfits();
        Calendar calendar = Calendar.getInstance();
        DataPoint[] dataPoints = new DataPoint[list.size()];

        for (int i = 0; i < list.size(); i++) {
            TransactionFeeProfit feeProfit = list.get(i);
            calendar.setTimeInMillis(feeProfit.getTimestamp());
            Date d = calendar.getTime();
            DataPoint dp = new DataPoint(d, feeProfit.getFeeProfit());
            dataPoints[i] = dp;
        }

        return new LineGraphSeries<>(dataPoints);
    }

    public double calculateTotalFeeCount() {
        double totalFee = 0;
        List<TransactionFeeProfit> list = getListOfProfits();

        for (TransactionFeeProfit transactionFeeProfit : list) {
            totalFee += transactionFeeProfit.getFeeProfit();
        }
        return totalFee;
    }

    private List<TransactionFeeProfit> getListOfProfits() {
        List<TransactionFeeProfit> list = new LinkedList<>();
        try {
            list = ORMLiteFactcory.getHelper().getTransactionFeeProfitsDao().getAllTransactions();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

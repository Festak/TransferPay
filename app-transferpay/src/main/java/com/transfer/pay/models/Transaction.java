package com.transfer.pay.models;

import android.databinding.ObservableField;
import android.util.Log;

import com.transfer.pay.constants.Formats;
import com.transfer.pay.utils.calculator.FeeCalculator;

import java.util.Locale;

/**
 * Created by e.fetskovich on 6/7/17.
 */

public class Transaction {
    public final ObservableField<Double> youSend = new ObservableField<Double>() {
        @Override
        public void set(Double value) {
            super.set(value);
            if (value != 0.0) {
                calculateAmount(value);
            }
        }
    };

    public final ObservableField<String> theyReceive = new ObservableField<>();
    // Without Fee, just (fetchAndSend money * exchange rate)
    public final ObservableField<String> exchangeAmount = new ObservableField<>();
    // total money includes Fee calculated
    public final ObservableField<String> estimatedAmountReceived = new ObservableField<>();

    public final ObservableField<String> transferFee = new ObservableField<>();
    public final ObservableField<TransactionParams> transactionParams = new ObservableField<>();

    public final ObservableField<CreditCardModel> paymentOption = new ObservableField<>();

    public final ObservableField<String> transactionDate = new ObservableField<String>();
    public final ObservableField<String> operationType = new ObservableField<>();

    public final ObservableField<CreditCardModel> creditCard = new ObservableField<>();
    public final ObservableField<BankAccountModel> bankAccount = new ObservableField<>();

    public Transaction() {
        // do nothing
    }

    public Transaction(TransactionParams transactionParams) {
        this.transactionParams.set(transactionParams);
    }


    private void calculateAmount(Double send) {
        try {
            double currencyRate = transactionParams.get().exchangeRate.get();
            double amount = send * currencyRate;
            double fee = FeeCalculator.calculateFee(
                    send,
                    currencyRate,
                    transactionParams.get().feeMin.get(),
                    transactionParams.get().feePercent.get()
            );

            transferFee.set(String.valueOf(fee));
            exchangeAmount.set(String.format(Locale.getDefault(), Formats.TWO_NUMBERS_AFTER_POINT, amount));
            theyReceive.set(String.format(Locale.getDefault(), Formats.TWO_NUMBERS_AFTER_POINT, amount + fee));
            estimatedAmountReceived.set(String.format(Locale.getDefault(), Formats.TWO_NUMBERS_AFTER_POINT, amount + fee));

        } catch (Exception e) {
            Log.v("MyTag", "Parsing exception in Transaction class");
        }
    }


}

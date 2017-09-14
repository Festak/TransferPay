package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.transfer.pay.BR;
import com.transfer.pay.constants.Formats;
import com.transfer.pay.utils.calculator.FeeCalculator;

import java.util.Locale;

/**
 * Created by e.fetskovich on 6/7/17.
 */

public class Transaction extends BaseObservable {

    private Double youSend;
    private String theyReceive;
    // Without Fee, just (fetchAndSend money * exchange rate)
    private String exchangeAmount;
    private String estimatedAmountReceived;
    private String transferFee;
    private TransactionParams transactionParams;
    private CreditCardModel paymentOption;
    private String transactionDate;
    private String operationType;
    private CreditCardModel creditCard;
    private BankAccountModel bankAccount;

    public Transaction() {
        // do nothing
    }

    public Transaction(TransactionParams transactionParams) {
        setTransactionParams(transactionParams);
    }

    @Bindable
    public Double getYouSend() {
        return youSend;
    }

    public void setYouSend(Double youSend) {
        this.youSend = youSend;
        notifyPropertyChanged(BR.youSend);
        if (youSend != null && youSend != 0.0) {
            calculateAmount(youSend);
        }
    }

    @Bindable
    public String getTheyReceive() {
        return theyReceive;
    }

    public void setTheyReceive(String theyReceive) {
        this.theyReceive = theyReceive;
        notifyPropertyChanged(BR.theyReceive);
    }

    @Bindable
    public String getExchangeAmount() {
        return exchangeAmount;
    }

    public void setExchangeAmount(String exchangeAmount) {
        this.exchangeAmount = exchangeAmount;
        notifyPropertyChanged(BR.exchangeAmount);
    }

    @Bindable
    public String getEstimatedAmountReceived() {
        return estimatedAmountReceived;
    }

    public void setEstimatedAmountReceived(String estimatedAmountReceived) {
        this.estimatedAmountReceived = estimatedAmountReceived;
        notifyPropertyChanged(BR.estimatedAmountReceived);
    }

    @Bindable
    public String getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(String transferFee) {
        this.transferFee = transferFee;
        notifyPropertyChanged(BR.transferFee);
    }

    @Bindable
    public TransactionParams getTransactionParams() {
        return transactionParams;
    }

    public void setTransactionParams(TransactionParams transactionParams) {
        this.transactionParams = transactionParams;
        notifyPropertyChanged(BR.transactionParams);
    }

    @Bindable
    public CreditCardModel getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(CreditCardModel paymentOption) {
        this.paymentOption = paymentOption;
        notifyPropertyChanged(BR.paymentOption);
    }

    @Bindable
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
        notifyPropertyChanged(BR.transactionDate);
    }

    @Bindable
    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
        notifyPropertyChanged(BR.operationType);
    }

    @Bindable
    public CreditCardModel getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardModel creditCard) {
        this.creditCard = creditCard;
        notifyPropertyChanged(BR.creditCard);
    }

    @Bindable
    public BankAccountModel getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccountModel bankAccount) {
        this.bankAccount = bankAccount;
        notifyPropertyChanged(BR.bankAccount);
    }

    private void calculateAmount(Double send) {
        try {
            double currencyRate = transactionParams.getExchangeRate();
            double amount = send * currencyRate;
            double fee = FeeCalculator.calculateFee(
                    send,
                    currencyRate,
                    transactionParams.getFeeMin(),
                    transactionParams.getFeePercent()
            );

            setTransferFee(String.valueOf(fee));
            setExchangeAmount(returnFormatedByLocaleString(amount));
            setTheyReceive(returnFormatedByLocaleString(amount + fee));
            setEstimatedAmountReceived(returnFormatedByLocaleString(amount + fee));

        } catch (Exception e) {
            Log.v("MyTag", "Parsing exception in Transaction class");
        }
    }

    private String returnFormatedByLocaleString(double value) {
        return String.format(Locale.getDefault(), Formats.TWO_NUMBERS_AFTER_POINT, value);
    }


}

package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.transfer.pay.BR;
import com.transfer.pay.constants.Formats;
import com.transfer.pay.utils.calculator.FeeCalculator;

import java.util.Locale;

/**
 * Created by e.fetskovich on 6/7/17.
 */

@DatabaseTable(tableName = "transaction")
public class Transaction extends BaseObservable {

    public static final String transactionIdField = "transaction_id";
    @DatabaseField(columnName = transactionIdField, generatedId = true)
    private int transactionId;

    public static final String youSendField = "you_send";
    @DatabaseField(columnName = youSendField, dataType = DataType.DOUBLE)
    private double youSend;

    public static final String theyReceiveField = "they_receive";
    @DatabaseField(columnName = theyReceiveField, dataType = DataType.STRING)
    private String theyReceive;

    public static final String exchangeAmountField = "exchange_amount";
    @DatabaseField(columnName = exchangeAmountField, dataType = DataType.STRING)
    private String exchangeAmount;

    public static final String estimatedAmountReceivedField = "estimated_amount_received";
    @DatabaseField(columnName = estimatedAmountReceivedField, dataType = DataType.STRING)
    private String estimatedAmountReceived;

    public static final String transferFeeField = "transfer_fee";
    @DatabaseField(columnName = transferFeeField, dataType = DataType.STRING)
    private String transferFee;

    public static final String transactionDateField = "transaction_date";
    @DatabaseField(columnName = transactionDateField, dataType = DataType.STRING)
    private String transactionDate;

    public static final String operationTypeField = "operation_type";
    @DatabaseField(columnName = operationTypeField, dataType = DataType.STRING)
    private String operationType;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private User user;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private CreditCardModel paymentOption;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private CreditCardAccountModel creditCard;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private BankAccountModel bankAccount;

    public static final String EXCHANGE_RATE_FIELD = "exchange_rate_field";
    @DatabaseField(columnName = EXCHANGE_RATE_FIELD, dataType = DataType.DOUBLE_OBJ)
    private Double exchangeRate;

    public static final String CURRENCY_FIELD = "currency";
    @DatabaseField(columnName = CURRENCY_FIELD, dataType = DataType.STRING)
    private String currency;

    private TransactionParams transactionParams;

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
        if (paymentOption != null) {
            if (paymentOption.getCreditCardDataOne() != null) {
                setExchangeRate(paymentOption.getCreditCardDataOne().getCurrency().getFormatToUsd());
                setCurrency(paymentOption.getCreditCardDataOne().getCurrency().getName());
            } else {
                setExchangeRate(1.0);
                setCurrency("Undefined");
            }
        }
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
    public CreditCardAccountModel getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardAccountModel creditCard) {
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

    @Bindable
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
        notifyPropertyChanged(BR.transactionId);
    }

    @Bindable
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }

    @Bindable
    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
        notifyPropertyChanged(BR.exchangeRate);
    }

    @Bindable
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
        notifyPropertyChanged(BR.currency);
    }

    private void calculateAmount(Double send) {
        try {
            double currencyRate = getExchangeRate();
            double amount = send / currencyRate;
            double fee = FeeCalculator.calculateFee(
                    send,
                    currencyRate,
                    transactionParams.getFeeMin(),
                    transactionParams.getFeePercent()
            );

            setTransferFee(String.valueOf(fee));
            setExchangeAmount(returnFormatedByLocaleString(amount));
            setTheyReceive(returnFormatedByLocaleString(amount - fee));
            setEstimatedAmountReceived(returnFormatedByLocaleString(amount - fee));

        } catch (Exception e) {
            Log.v("MyTag", "Parsing exception in Transaction class");
        }
    }

    private String returnFormatedByLocaleString(double value) {
        return String.format(Locale.getDefault(), Formats.TWO_NUMBERS_AFTER_POINT, value);
    }


}

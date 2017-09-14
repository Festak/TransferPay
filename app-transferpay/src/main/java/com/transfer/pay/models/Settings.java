package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.transfer.pay.BR;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class Settings extends BaseObservable{

    private String defaultCountry;
    private String defaultBankName;
    private String myCurrency;
    private String beneficiaryCurrency;
    private TransactionParams transactionParams;

    public Settings(){
        // needs for gson
    }

    @Bindable
    public String getDefaultCountry() {
        return defaultCountry;
    }

    public void setDefaultCountry(String defaultCountry) {
        this.defaultCountry = defaultCountry;
        notifyPropertyChanged(BR.defaultCountry);
    }

    @Bindable
    public String getDefaultBankName() {
        return defaultBankName;
    }

    public void setDefaultBankName(String defaultBankName) {
        this.defaultBankName = defaultBankName;
        notifyPropertyChanged(BR.defaultBankName);
    }

    @Bindable
    public String getMyCurrency() {
        return myCurrency;
    }

    public void setMyCurrency(String myCurrency) {
        this.myCurrency = myCurrency;
        notifyPropertyChanged(BR.myCurrency);
    }

    @Bindable
    public String getBeneficiaryCurrency() {
        return beneficiaryCurrency;
    }

    public void setBeneficiaryCurrency(String beneficiaryCurrency) {
        this.beneficiaryCurrency = beneficiaryCurrency;
        notifyPropertyChanged(BR.beneficiaryCurrency);
    }

    @Bindable
    public TransactionParams getTransactionParams() {
        return transactionParams;
    }

    public void setTransactionParams(TransactionParams transactionParams) {
        this.transactionParams = transactionParams;
        notifyPropertyChanged(BR.transactionParams);
    }

    public Settings(TransactionParams transactionParams) {
        this.transactionParams = transactionParams;
    }

}

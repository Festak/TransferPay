package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.transfer.pay.BR;

import java.io.Serializable;

public class BankAccountModel extends BaseObservable implements Serializable {

    private String name;
    private String country;
    private String chooseBank;
    private String accountNo;

    public BankAccountModel() {
        // do nothing
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        notifyPropertyChanged(BR.country);
    }

    @Bindable
    public String getChooseBank() {
        return chooseBank;
    }

    public void setChooseBank(String chooseBank) {
        this.chooseBank = chooseBank;
        notifyPropertyChanged(BR.chooseBank);
    }

    @Bindable
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
        notifyPropertyChanged(BR.accountNo);
    }

    public void setSettingsDataToBankAccount(Settings settings) {
        setCountry(settings.getDefaultCountry());
        setChooseBank(settings.getDefaultBankName());
    }

}

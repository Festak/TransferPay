package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.transfer.pay.BR;

import java.io.Serializable;

@DatabaseTable(tableName = "bank_account")
public class BankAccountModel extends BaseObservable implements Serializable {

    public static final String nameField = "name";
    @DatabaseField(columnName = nameField, dataType = DataType.STRING)
    private String name;

    public static final String countryField = "country";
    @DatabaseField(columnName = countryField, dataType = DataType.STRING)
    private String country;

    public static final String chooseBankField = "choose_bank";
    @DatabaseField(columnName = chooseBankField, dataType = DataType.STRING)
    private String chooseBank;

    public static final String accountNumberField = "account_number";
    @DatabaseField(columnName = accountNumberField, dataType = DataType.STRING)
    private String accountNo;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private User user;

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

    @Bindable
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }
}

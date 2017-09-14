package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.transfer.pay.BR;

/**
 * @author e.fetskovich on 9/5/17.
 */

public class NewBeneficiaryType extends BaseObservable{

    private Boolean isBankAccount;

    public NewBeneficiaryType(){
        isBankAccount = false;
    }

    @Bindable
    public Boolean getBankAccount() {
        return isBankAccount;
    }

    public void setBankAccount(Boolean bankAccount) {
        isBankAccount = bankAccount;
        notifyPropertyChanged(BR.bankAccount);
    }


}

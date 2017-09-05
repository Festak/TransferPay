package com.transfer.pay.models;

import android.databinding.ObservableField;

import java.io.Serializable;

/**
 * Created by i.statkevich on 6/2/17.
 */

public class BankAccountModel implements Serializable {
    public final ObservableField<String> name = new ObservableField<String>();

    public final ObservableField<String> country = new ObservableField<>();
    public final ObservableField<String> chooseBank = new ObservableField<>();

    // accountNo is a bank account number
    public final ObservableField<String> accountNo = new ObservableField<>();

    public BankAccountModel() {
        // do nothing
    }

    public void setSettingsDataToBankAccount(Settings settings) {
        country.set(settings.defaultCountry.get());
        chooseBank.set(settings.defaultBankName.get());
    }

}

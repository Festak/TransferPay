package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class Settings extends BaseObservable{

    public final ObservableField<String> defaultCountry = new ObservableField<>();
    public final ObservableField<String> defaultBankName = new ObservableField<>();

    public final ObservableField<String> myCurrency = new ObservableField<>();
    public final ObservableField<String> beneficiaryCurrency = new ObservableField<>();

    public final ObservableField<TransactionParams> transactionParams = new ObservableField<>();

    public Settings(){
        // needs for gson
    }



    public Settings(TransactionParams transactionParams) {
        this.transactionParams.set(transactionParams);
    }

}

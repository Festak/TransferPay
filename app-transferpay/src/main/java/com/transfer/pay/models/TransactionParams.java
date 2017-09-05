package com.transfer.pay.models;

import android.databinding.ObservableField;

/**
 * Created by e.fetskovich on 6/20/17.
 */

public class TransactionParams {
    public final ObservableField<Double> exchangeRate = new ObservableField<>();
    public final ObservableField<Double> feeMin = new ObservableField<>();
    public final ObservableField<Double> feePercent = new ObservableField<>();

    public TransactionParams(){
        // Default values
        exchangeRate.set(0.5);
        feeMin.set(2.0);
        feePercent.set(1.5);
    }

}

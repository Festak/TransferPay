package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.transfer.pay.BR;

/**
 * Created by e.fetskovich on 6/20/17.
 */

public class TransactionParams extends BaseObservable {

    private Double exchangeRate;
    private Double feeMin;
    private Double feePercent;

    public TransactionParams(){
        setExchangeRate(0.5);
        setFeeMin(2.0);
        setFeePercent(1.5);
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
    public Double getFeeMin() {
        return feeMin;
    }

    public void setFeeMin(Double feeMin) {
        this.feeMin = feeMin;
        notifyPropertyChanged(BR.feeMin);
    }

    @Bindable
    public Double getFeePercent() {
        return feePercent;
    }

    public void setFeePercent(Double feePercent) {
        this.feePercent = feePercent;
        notifyPropertyChanged(BR.feePercent);
    }
}

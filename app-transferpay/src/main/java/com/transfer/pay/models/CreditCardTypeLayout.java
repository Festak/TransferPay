package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.transfer.pay.BR;

/**
 * @author e.fetskovich on 11/10/17.
 */

public class CreditCardTypeLayout extends BaseObservable {

    private boolean master;
    private boolean visa;
    private boolean amex;
    private boolean defaultType;

    @Bindable
    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
        notifyPropertyChanged(BR.master);
    }

    @Bindable
    public boolean isVisa() {
        return visa;
    }

    public void setVisa(boolean visa) {
        this.visa = visa;
        notifyPropertyChanged(BR.visa);
    }

    @Bindable
    public boolean isAmex() {
        return amex;
    }

    public void setAmex(boolean amex) {
        this.amex = amex;
        notifyPropertyChanged(BR.amex);
    }

    @Bindable
    public boolean isDefaultType() {
        return defaultType;
    }

    public void setDefaultType(boolean defaultType) {
        this.defaultType = defaultType;
        notifyPropertyChanged(BR.defaultType);
    }
}

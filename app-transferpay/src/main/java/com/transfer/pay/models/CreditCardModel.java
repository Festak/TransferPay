package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.transfer.pay.BR;

import java.io.Serializable;

/**
 * Created by i.statkevich on 6/2/17.
 */

public class CreditCardModel extends BaseObservable implements Serializable {

    private String cardHolderName;
    private String creditCardNumber;
    private String validDate;
    private String CVV;
    private String cardType;

    public CreditCardModel() {
        // do nothing
    }

    @Bindable
    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        notifyPropertyChanged(BR.cardHolderName);
    }

    @Bindable
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        notifyPropertyChanged(BR.creditCardNumber);
    }

    @Bindable
    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
        notifyPropertyChanged(BR.validDate);
    }

    @Bindable
    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
        notifyPropertyChanged(BR.cVV);
    }

    @Bindable
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
        notifyPropertyChanged(BR.cardType);
    }

    @Override
    public String toString() {
        return cardType+" "+creditCardNumber;
    }
}

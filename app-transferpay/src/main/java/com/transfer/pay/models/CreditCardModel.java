package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.transfer.pay.BR;

import java.io.Serializable;


public class CreditCardModel extends BaseObservable implements Serializable {

    public static final String cardHolderNameField = "card_holder_name";

    private String cardHolderName;

    public static final String creditCardNumberField = "credit_card_number";

    private String creditCardNumber;

    public static final String validDateField = "valid_date";

    private String validDate;

    public static final String CVVField = "cvv";

    private String CVV;

    public static final String cardTypeField = "card_type";

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

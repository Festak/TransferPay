package com.transfer.pay.models;

import android.databinding.ObservableField;

import java.io.Serializable;

/**
 * Created by i.statkevich on 6/2/17.
 */

public class CreditCardModel implements Serializable {
    public final ObservableField<String> cardHolderName = new ObservableField<>();
    public final ObservableField<String> creditCardNumber = new ObservableField<>();
    public final ObservableField<String> validDate = new ObservableField<>();
    public final ObservableField<String> CVV = new ObservableField<>();
    public final ObservableField<String> cardType = new ObservableField<>();

    public CreditCardModel() {
        // do nothing
    }

    @Override
    public String toString() {
        return cardType.get()+" "+creditCardNumber.get();
    }
}

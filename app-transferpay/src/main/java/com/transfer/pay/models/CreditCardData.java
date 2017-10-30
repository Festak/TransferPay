package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.transfer.pay.BR;

/**
 * @author e.fetskovich on 10/24/17.
 */
@DatabaseTable(tableName = "credit_card_data")
public class CreditCardData extends BaseObservable{

    public static final String CARD_DATA_FIELD = "card_data_id";
    @DatabaseField(generatedId = true, columnName = CARD_DATA_FIELD)
    private int cardDataId;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Currency currency;

    public int getCardDataId() {
        return cardDataId;
    }

    public void setCardDataId(int cardDataId) {
        this.cardDataId = cardDataId;
    }

    @Bindable
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
        notifyPropertyChanged(BR.currency);
    }
}

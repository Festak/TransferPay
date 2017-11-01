package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.j256.ormlite.field.DataType;
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

    public static final String CURRENCY_ID = "currency_id";
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = CURRENCY_ID)
    private Currency currency;

    public static final String MONEY = "money";
    @DatabaseField(columnName = MONEY, dataType = DataType.DOUBLE)
    private double money;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private CreditCardModel creditCardModel;

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

    public CreditCardModel getCreditCardModel() {
        return creditCardModel;
    }

    public void setCreditCardModel(CreditCardModel creditCardModel) {
        this.creditCardModel = creditCardModel;
    }

    @Bindable
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
        notifyPropertyChanged(BR.money);
    }
}

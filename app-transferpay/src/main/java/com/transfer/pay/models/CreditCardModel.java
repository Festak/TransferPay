package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.transfer.pay.BR;

import java.io.Serializable;

@DatabaseTable(tableName = "credit_card")
public class CreditCardModel extends BaseObservable implements Serializable {

    public static final String creditCardIdField = "credit_card_id";
    @DatabaseField(columnName = creditCardIdField, generatedId = true)
    private int creditCardId;

    public static final String cardHolderNameField = "card_holder_name";
    @DatabaseField(columnName = cardHolderNameField, dataType = DataType.STRING)
    private String cardHolderName;

    public static final String creditCardNumberField = "credit_card_number";
    @DatabaseField(columnName = creditCardNumberField, dataType = DataType.STRING)
    private String creditCardNumber;

    public static final String validDateField = "valid_date";
    @DatabaseField(columnName = validDateField, dataType = DataType.STRING)
    private String validDate;

    public static final String CVVField = "cvv";
    @DatabaseField(columnName = CVVField, dataType = DataType.STRING)
    private String CVV;

    public static final String cardTypeField = "card_type";
    @DatabaseField(columnName = cardTypeField, dataType = DataType.STRING)
    private String cardType;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private User user;

    // It's 1:1 dependency (without collection it's doesn't want to works great)
    @ForeignCollectionField(eager = true)
    private ForeignCollection<CreditCardData> creditCardData;

    public CreditCardModel() {
        // do nothing
    }

    @Bindable
    public int getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(int creditCardId) {
        this.creditCardId = creditCardId;
        notifyPropertyChanged(BR.creditCardId);
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

    @Bindable
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyPropertyChanged(BR.user);
    }


    public CreditCardData getCreditCardDataOne() {
        if (creditCardData != null && creditCardData.size() == 1) {
            return (CreditCardData) creditCardData.toArray()[0];
        } else {
            return null;
        }
    }

    public ForeignCollection<CreditCardData> getCreditCardData() {
        return creditCardData;
    }

    public void setCreditCardData(ForeignCollection<CreditCardData> creditCardData) {
        this.creditCardData = creditCardData;
    }

    @Override
    public String toString() {
        return cardType + " " + creditCardNumber;
    }
}

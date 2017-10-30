package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author e.fetskovich on 10/27/17.
 */
@DatabaseTable(tableName = "currency")
public class Currency extends BaseObservable{

    public static final String currencyIdField = "currency_field";
    @DatabaseField(generatedId = true, columnName = currencyIdField)
    private int currencyId;

    public static final String nameField = "name";
    @DatabaseField(columnName = nameField, dataType = DataType.STRING)
    private String name;

    public static final String formatToUsdField = "formatToUsd";
    @DatabaseField(columnName = formatToUsdField, dataType = DataType.DOUBLE_OBJ)
    private Double formatToUsd;

    public Currency(){
        // do nothing
    }

    @Bindable
    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFormatToUsd() {
        return formatToUsd;
    }

    public void setFormatToUsd(Double formatToUsd) {
        this.formatToUsd = formatToUsd;
    }
}

package com.transfer.pay.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author e.fetskovich on 11/20/17.
 */

@DatabaseTable(tableName = "transaction_fee_profit")
public class TransactionFeeProfit {

    public static final String TRANSACTION_FEE_PROFIT_ID = "transaction_fee_profit_id";
    @DatabaseField(columnName = TRANSACTION_FEE_PROFIT_ID, generatedId = true)
    private int id;

    public static final String FEE_PROFIT = "fee_profit";
    @DatabaseField(columnName = FEE_PROFIT, dataType = DataType.DOUBLE)
    private double feeProfit;

    public static final String FEE_DATE = "fee_date";
    @DatabaseField(columnName = FEE_DATE, dataType = DataType.LONG)
    private long timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFeeProfit() {
        return feeProfit;
    }

    public void setFeeProfit(double feeProfit) {
        this.feeProfit = feeProfit;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

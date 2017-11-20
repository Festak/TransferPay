package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.TransactionFeeProfit;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 11/20/17.
 */

public class TransactionProfitDao extends BaseDaoImpl<TransactionFeeProfit, String> {
    public TransactionProfitDao(ConnectionSource connectionSource,
                          Class<TransactionFeeProfit> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<TransactionFeeProfit> getAllTransactions() throws SQLException {
        return this.queryForAll();
    }
}

package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 10/24/17.
 */

public class TransactionDao extends BaseDaoImpl<Transaction, String> {
    public TransactionDao(ConnectionSource connectionSource,
                               Class<Transaction> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Transaction> getAllCreditCards() throws SQLException {
        return this.queryForAll();
    }
}
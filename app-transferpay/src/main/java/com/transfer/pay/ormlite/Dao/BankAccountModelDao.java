package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.BankAccountModel;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 10/24/17.
 */

public class BankAccountModelDao extends BaseDaoImpl<BankAccountModel, String> {
    public BankAccountModelDao(ConnectionSource connectionSource,
                         Class<BankAccountModel> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<BankAccountModel> getAllCreditCards() throws SQLException {
        return this.queryForAll();
    }
}

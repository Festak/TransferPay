package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.CreditCardAccountModel;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 10/24/17.
 */

public class CreditCardAccountDao extends BaseDaoImpl<CreditCardAccountModel, String> {
    public CreditCardAccountDao(ConnectionSource connectionSource,
                         Class<CreditCardAccountModel> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<CreditCardAccountModel> getAllCreditCards() throws SQLException {
        return this.queryForAll();
    }
}

package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.CreditCardModel;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 10/24/17.
 */

public class CreditCardDao extends BaseDaoImpl<CreditCardModel, String> {
    public CreditCardDao(ConnectionSource connectionSource,
                   Class<CreditCardModel> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<CreditCardModel> getAllCreditCards() throws SQLException {
        return this.queryForAll();
    }

}

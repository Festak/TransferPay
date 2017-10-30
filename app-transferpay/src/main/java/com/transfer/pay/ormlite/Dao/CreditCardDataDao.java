package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.CreditCardData;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 10/30/17.
 */

public class CreditCardDataDao extends BaseDaoImpl<CreditCardData, String> {
    public CreditCardDataDao(ConnectionSource connectionSource,
                         Class<CreditCardData> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<CreditCardData> getAllCreditCards() throws SQLException {
        return this.queryForAll();
    }

}


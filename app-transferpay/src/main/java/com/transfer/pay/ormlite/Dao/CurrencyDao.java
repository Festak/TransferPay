package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.Currency;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 10/30/17.
 */

public class CurrencyDao extends BaseDaoImpl<Currency, String> {
    public CurrencyDao(ConnectionSource connectionSource,
                         Class<Currency> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Currency> getCurrencies() throws SQLException {
        return this.queryForAll();
    }

}

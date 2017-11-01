package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
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

    public CreditCardModel getCreditCardModel(String number) throws SQLException {
        QueryBuilder<CreditCardModel, String> queryBuilder = queryBuilder();
        queryBuilder.where().eq(CreditCardModel.creditCardNumberField, number);
        PreparedQuery<CreditCardModel> preparedQuery = queryBuilder.prepare();
        List<CreditCardModel> cards = query(preparedQuery);
        if (cards != null && cards.size() != 0) {
            return cards.get(0);
        } else {
            return null;
        }
    }

}

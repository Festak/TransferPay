package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.UserRole;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 10/30/17.
 */

public class UserRoleDao extends BaseDaoImpl<UserRole, String> {
    public UserRoleDao(ConnectionSource connectionSource,
                    Class<UserRole> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<UserRole> getAllCreditCards() throws SQLException {
        return this.queryForAll();
    }
}

package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 10/23/17.
 */

public class UserDao extends BaseDaoImpl<User, String> {
    public UserDao(ConnectionSource connectionSource,
                     Class<User> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<User> getAllRoles() throws SQLException {
        return this.queryForAll();
    }
}

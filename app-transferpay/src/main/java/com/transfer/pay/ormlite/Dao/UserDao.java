package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
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

    public List<User> getAllUsers() throws SQLException {
        return this.queryForAll();
    }

    public User getUser(String login) throws SQLException {
        QueryBuilder<User, String> queryBuilder = queryBuilder();
        queryBuilder.where().eq(User.loginField, login);
        PreparedQuery<User> preparedQuery = queryBuilder.prepare();
        List<User> users = query(preparedQuery);
        if (users != null && users.size() != 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

}

package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.Role;

import java.sql.SQLException;
import java.util.List;

/**
 * @author e.fetskovich on 10/30/17.
 */

public class RolesDao extends BaseDaoImpl<Role, String> {
    public RolesDao(ConnectionSource connectionSource,
                    Class<Role> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Role> getAllCreditCards() throws SQLException {
        return this.queryForAll();
    }

    public Role getRole(String login) throws SQLException {
        QueryBuilder<Role, String> queryBuilder = queryBuilder();
        queryBuilder.where().eq(Role.nameField, login);
        PreparedQuery<Role> preparedQuery = queryBuilder.prepare();
        List<Role> roles = query(preparedQuery);
        if (roles != null && roles.size() != 0) {
            return roles.get(0);
        } else {
            return null;
        }
    }

}

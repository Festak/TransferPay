package com.transfer.pay.ormlite.Dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.support.ConnectionSource;
import com.transfer.pay.models.Role;
import com.transfer.pay.models.User;
import com.transfer.pay.models.UserRole;
import com.transfer.pay.ormlite.ORMLiteFactcory;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author e.fetskovich on 10/30/17.
 */

public class UserRoleDao extends BaseDaoImpl<UserRole, String> {
    public UserRoleDao(ConnectionSource connectionSource,
                       Class<UserRole> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<UserRole> getAllUserRoles() throws SQLException {
        return this.queryForAll();
    }

    private PreparedQuery<Role> rolesForUserQuery = null;

    public List<Role> lookupRolesForUser(User user) {
        List<Role> roles = new LinkedList<>();
        try {
            if (rolesForUserQuery == null) {
                rolesForUserQuery = makeRolesForUserQuery();
            }
            RolesDao rolesDao = ORMLiteFactcory.getHelper().getRolesDao();
            rolesForUserQuery.setArgumentHolderValue(0, user);
            roles = rolesDao.query(rolesForUserQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    /**
     * Build our query for Post objects that match a User.
     */
    private PreparedQuery<Role> makeRolesForUserQuery() throws SQLException {
        QueryBuilder<UserRole, String> userRoleQb = this.queryBuilder();
        userRoleQb.selectColumns(UserRole.ROLE_ID_FIELD);
        SelectArg userSelectArg = new SelectArg();
        userRoleQb.where().eq(UserRole.USER_ID_FIELD, userSelectArg);

        RolesDao rolesDao = ORMLiteFactcory.getHelper().getRolesDao();
        QueryBuilder<Role, String> postQb = rolesDao.queryBuilder();
        postQb.where().in(Role.roleIdField, userRoleQb);
        return postQb.prepare();
    }


}

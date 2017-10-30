package com.transfer.pay.models;

import com.j256.ormlite.field.DatabaseField;

/**
 * @author e.fetskovich on 10/30/17.
 */

public class UserRole {

    public static final String USER_ROLE_FIELD = "user_role_id";
    @DatabaseField(generatedId = true, columnName = USER_ROLE_FIELD)
    private int userRoleId;

    public static final String USER_ID_FIELD = "user_id";
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = USER_ID_FIELD)
    private User user;

    public static final String ROLE_ID_FIELD = "role_id";
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = ROLE_ID_FIELD)
    private Role role;

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

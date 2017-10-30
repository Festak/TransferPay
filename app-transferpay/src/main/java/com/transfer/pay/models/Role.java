package com.transfer.pay.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author e.fetskovich on 10/27/17.
 */

@DatabaseTable(tableName = "roles")
public class Role {

    public static final String roleIdField = "role_id";
    @DatabaseField(generatedId = true, columnName = roleIdField)
    private int roleId;

    public static final String nameField = "name";
    @DatabaseField(columnName = nameField, dataType = DataType.STRING)
    private String name;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private User user;

    public Role(){
        // do nothing
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

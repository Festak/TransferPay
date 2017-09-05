package com.transfer.pay.utils;

import com.transfer.pay.models.User;

/**
 * Created by e.fetskovich on 6/15/17.
 */

public class UserNameCombiner {

    public static String combine(User user) {
        String name = "";
        if (user.firstName.get() != null) {
            name += user.firstName.get();
        }
        if (user.lastName.get() != null) {
            name += " " + user.lastName.get();
        }
        if (user.firstName.get() == null && user.lastName.get() == null) {
            name = "No name";
        }
        return name;
    }

}

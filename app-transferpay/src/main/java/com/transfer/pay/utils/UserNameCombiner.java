package com.transfer.pay.utils;

import com.transfer.pay.models.User;

/**
 * Created by e.fetskovich on 6/15/17.
 */

public class UserNameCombiner {

    public static String combine(User user) {
        String name = "";
        if (user.getFirstName() != null) {
            name += user.getFirstName();
        }
        if (user.getLastName() != null) {
            name += " " + user.getLastName();
        }
        if (user.getFirstName() == null && user.getLastName() == null) {
            name = "No name";
        }
        return name;
    }

}

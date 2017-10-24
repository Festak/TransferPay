package com.transfer.pay.utils.validation.rules;

import com.transfer.pay.models.User;
import com.transfer.pay.ormlite.ORMLiteFactcory;

import java.sql.SQLException;

/**
 * @author e.fetskovich on 10/24/17.
 */

public class LoginNotExistsValidationRule implements Rule {
    @Override
    public boolean validate(CharSequence charSequence) {
        User user = null;
        try {
            user = ORMLiteFactcory.getHelper().getUserDao().getUser(charSequence.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user == null;
    }
}

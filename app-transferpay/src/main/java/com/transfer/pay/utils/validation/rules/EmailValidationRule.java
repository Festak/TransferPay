package com.transfer.pay.utils.validation.rules;

import android.text.TextUtils;
import android.util.Patterns;

public class EmailValidationRule implements Rule {
    @Override
    public boolean validate(CharSequence text) {
        return Patterns.EMAIL_ADDRESS.matcher(text).matches() || !TextUtils.isEmpty(text);
    }
}

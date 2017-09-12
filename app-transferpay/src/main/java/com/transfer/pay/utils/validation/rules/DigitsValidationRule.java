package com.transfer.pay.utils.validation.rules;

import android.text.TextUtils;

public class DigitsValidationRule implements Rule {
    @Override
    public boolean validate(CharSequence text) {
        return TextUtils.isDigitsOnly(text);
    }
}

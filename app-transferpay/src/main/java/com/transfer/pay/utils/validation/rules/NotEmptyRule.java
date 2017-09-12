package com.transfer.pay.utils.validation.rules;

import android.text.TextUtils;

public class NotEmptyRule implements Rule {
    @Override
    public boolean validate(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence);
    }
}

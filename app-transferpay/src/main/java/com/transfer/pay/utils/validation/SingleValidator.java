package com.transfer.pay.utils.validation;

import com.transfer.pay.utils.validation.rules.Rule;


public class SingleValidator implements Validator {
    private Rule rule;

    public SingleValidator(Rule rule) {
        this.rule = rule;
    }

    @Override
    public boolean validate(CharSequence charSequence) {
        return rule.validate(charSequence);
    }

    public Rule getRule() {
        return rule;
    }
}

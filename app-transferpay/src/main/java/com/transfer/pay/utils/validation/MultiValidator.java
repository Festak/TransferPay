package com.transfer.pay.utils.validation;

import android.util.Log;

import com.transfer.pay.utils.validation.rules.Rule;

import java.util.LinkedList;
import java.util.List;

/**
 * @author e.fetskovich on 10/24/17.
 */

public class MultiValidator implements Validator {
    private static final String TAG = "MultiValidator";
    private List<Rule> rules;
    private List<Boolean> values;

    public MultiValidator(List<Rule> rules) {
        this.rules = rules;
        values = new LinkedList<>();
    }

    @Override
    public boolean validate(CharSequence charSequence) {
        values = new LinkedList<>();
        for (Rule rule : rules) {
            values.add(rule.validate(charSequence));
        }

        Log.i(TAG, "validate: " + !values.contains(false));

        return !values.contains(false);

    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}

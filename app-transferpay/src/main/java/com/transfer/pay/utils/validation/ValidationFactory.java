package com.transfer.pay.utils.validation;

import com.transfer.pay.utils.validation.rules.DigitsValidationRule;
import com.transfer.pay.utils.validation.rules.EmailValidationRule;
import com.transfer.pay.utils.validation.rules.LoginNotExistsValidationRule;
import com.transfer.pay.utils.validation.rules.NotEmptyRule;
import com.transfer.pay.utils.validation.rules.Rule;

import java.util.LinkedList;
import java.util.List;

/**
 * @author e.fetskovich on 9/12/17.
 */

public class ValidationFactory {

    private ValidationFactory(){
        // do nothing
    }

    public static Validator getDigitsValidation(){
        return new SingleValidator(new DigitsValidationRule());
    }

    public static Validator getEmailValidation(){
        return new SingleValidator(new EmailValidationRule());
    }

    public static Validator getEmptyRuleValidation(){
        return new SingleValidator(new NotEmptyRule());
    }

    public static Validator getSameLoginValidator(){
        List<Rule> rules = new LinkedList<>();
        rules.add(new NotEmptyRule());
        rules.add(new LoginNotExistsValidationRule());
        return new MultiValidator(rules);
    }

}

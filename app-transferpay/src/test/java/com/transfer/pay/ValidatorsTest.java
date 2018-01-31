package com.transfer.pay;

import com.transfer.pay.utils.validation.ValidationFactory;
import com.transfer.pay.utils.validation.Validator;
import com.transfer.pay.utils.validation.rules.DigitsValidationRule;
import com.transfer.pay.utils.validation.rules.NotEmptyRule;
import com.transfer.pay.utils.validation.rules.Rule;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author e.fetskovich on 1/31/18.
 */

public class ValidatorsTest {

    @Test
    public void testOnNotEmptyText() {
        Rule emptyText = new NotEmptyRule();
        assertEquals(emptyText.validate("not empty text"), true);
    }

    @Test
    public void testOnEmptyText() {
        Rule emptyText = new NotEmptyRule();
        assertEquals(emptyText.validate(""), true);
    }

    @Test
    public void checkOnDigitsValidation() {
        String stringWithoutDigets = "jeka";
        Rule digitsRule = new DigitsValidationRule();
        assertEquals(digitsRule.validate(stringWithoutDigets), false);
    }

    @Test
    public void checkOnGettingValidatorsFactory(){
        Validator validator = ValidationFactory.getSameLoginValidator();
        assertNotNull(validator);
    }


}

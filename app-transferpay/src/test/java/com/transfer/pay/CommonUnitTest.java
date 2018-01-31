package com.transfer.pay;

import com.transfer.pay.models.Currency;
import com.transfer.pay.models.User;
import com.transfer.pay.utils.Converter;
import com.transfer.pay.utils.CurrencyHelper;
import com.transfer.pay.utils.FileNameGenerator;
import com.transfer.pay.utils.UserNameCombiner;
import com.transfer.pay.utils.calculator.FeeCalculator;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author e.fetskovich on 1/31/18.
 */

public class CommonUnitTest {

    @Test
    public void testFeeCalculation() {
        double minFee = 2.0;
        double feeCalculated = FeeCalculator.calculateFee(30, 2, minFee, 1.5);
        assertEquals(feeCalculated, minFee, 0.0);
    }

    @Test
    public void testUsernameCombiner() {
        String firstName = "Jeka";
        String lastName = "Fetskovich";
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        String combinedName = UserNameCombiner.combine(user);

        assertEquals(firstName.concat(" ").concat(lastName), combinedName);
    }

    @Test
    public void testFileNameGenerator() {
        long date = new Date().getTime();
        String prefix = "pr";

        String totalName = prefix.concat(String.valueOf(date)).concat(".png");

        String totalDate = FileNameGenerator.generateImageFileName(prefix);

        assertNotNull(totalDate, totalName);
    }

    @Test
    public void checkCurrencyFormatter() {
        String currencyName = "BLR";
        double formatToUsd = 2.0;

        Currency currency = new Currency();
        currency.setName(currencyName);
        currency.setFormatToUsd(formatToUsd);

        String expectedFormat = currency.getName() + " (" + currency.getFormatToUsd() + ") : USD (1)";

        assertEquals(expectedFormat, CurrencyHelper.configureCurrencyString(currency));
    }

    @Test
    public void checkDoubleValueConverter() {
        String valueToConvert = "2";
        double value = Converter.convertStringToDouble(valueToConvert);

        assertEquals(value, Double.parseDouble(valueToConvert), 0);
    }


}

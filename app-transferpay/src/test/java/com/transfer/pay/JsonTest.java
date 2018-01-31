package com.transfer.pay;

import com.transfer.pay.models.Currency;
import com.transfer.pay.utils.json.JsonUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author e.fetskovich on 1/31/18.
 */

public class JsonTest {

    @Test
    public void toJsonFormatting(){
        Currency currency = new Currency();
        currency.setName("USD");
        try {
            String jsonCurrency = JsonUtils.toJson(currency);
            assertNotNull(jsonCurrency);
        } catch (Exception e) {
            e.printStackTrace();
            assertNotNull(null);
        }
    }

    @Test
    public void fromJson(){
        Currency currency = new Currency();
        currency.setName("USD");
        String jsonCurrency = "";
        try {
            jsonCurrency = JsonUtils.toJson(currency);
            assertNotNull(jsonCurrency);
        } catch (Exception e) {
            e.printStackTrace();
            assertNotNull(null);
        }

        Currency currency1 = JsonUtils.fromJson(jsonCurrency, Currency.class);
        assertEquals(currency1.getName(), "USD");
    }

}

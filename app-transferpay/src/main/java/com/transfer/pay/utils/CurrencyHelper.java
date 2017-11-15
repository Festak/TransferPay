package com.transfer.pay.utils;

import com.transfer.pay.models.Currency;

/**
 * @author e.fetskovich on 11/15/17.
 */

public class CurrencyHelper {

    private CurrencyHelper() {
        // do nothing
    }

    public static String configureCurrencyString(Currency currency) {
        if(currency != null){
            return currency.getName() + " (" + currency.getFormatToUsd() + ") : USD (1)";
        } else{
            return "No currency chosed";
        }
    }

}

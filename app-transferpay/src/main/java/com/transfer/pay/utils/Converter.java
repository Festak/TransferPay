package com.transfer.pay.utils;

/**
 * @author e.fetskovich on 11/1/17.
 */

public class Converter {

    private Converter() {
        // do nothing
    }

    public static double convertStringToDouble(String valueToParse) {
        double value;
        try {
            value = Double.parseDouble(valueToParse);
        } catch (Exception e) {
            value = 0.0;
        }
        return value;
    }

}

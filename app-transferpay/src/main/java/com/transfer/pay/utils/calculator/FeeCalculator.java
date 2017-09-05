package com.transfer.pay.utils.calculator;

/**
 * Created by e.fetskovich on 6/20/17.
 */

public class FeeCalculator {

    public static double calculateFee(double send, double currencyRate, double minFee, double feePercent){
        double fee;
        double amount = send * currencyRate;

        fee = amount * feePercent / 100;

        if (fee > minFee) {
            return fee;
        } else {
            return minFee;
        }
    }

}

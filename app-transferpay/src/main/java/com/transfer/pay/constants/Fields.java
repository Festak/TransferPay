package com.transfer.pay.constants;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class Fields {

    public static final String FRAGMENT_ID = "fragmentId";
    public static final String FRAGMENT_ARGUMENTS = "fragmentArguments";

    public static class Preferences {

        public static final String BENEFICIARIES = "beneficiary";
        public static final String CHOOSED_BENEFICIARY = "choosedBeneficiary";
        public static final String USER = "user";
        public static final String PAYMENT_OPTIONS = "paymentOptions";
        public static final String SETTINGS = "settings";

        private Preferences() {
            // do nothing
        }
    }

    private Fields() {
        // do nothing
    }

}

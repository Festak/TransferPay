package com.transfer.pay.constants;

public class ContainerId {
    public static class Activity {
        public static final String LOGIN = "LoginActivity";
        public static final String HOME = "HomeActivity";
        public static final String FRAGMENT_ACTIVITY = "SpaFragmentActivity";
        public static final String REGISTRATION = "RegistrationActivity";
        public static final String TWO_FACTOR_AUTH = "TwoFactorAuthActivity";
        public static final String PAYMENT_OPTION_TAB_ACTIVITY = "PaymentOptionTabActivity";

        private Activity() {
            // do nothing
        }
    }

    public static class Fragment {
        private Fragment() {
            // do nothing
        }

        public static final String BENEFICIARIES = "BeneficiariesFragment";
        public static final String SETTINGS = "SpaSettingsFragment";
        public static final String MY_PROFILE = "MyProfileFragment";
        public static final String TRANSACTION_HISTORY = "TransactionHistoryFragment";
        public static final String NEW_BENEFICIARY = "NewBeneficiaryFragment";
        public static final String PAYMENT_OPTIONS = "PaymentOptionsFragment";
        public static final String ADD_CARD = "AddCardFragment";
        public static final String TRANSACTION_OVERVIEW = "TransactionOverviewFragment";
        public static final String SETTINGS_TAB = "SettingsTabFragment";
        public static final String LOGO = "LogoFragment";
        public static final String CHANGE_PASSWORD = "ChangePasswordFragment";
        public static final String CARD_DATA = "CardDataFragment";
        public static final String PAYMENT_RESULT = "PaymentResultFragment";
        public static final String PROFIT_FEE = "ProfitFragment";

        public static class Registration {
            private Registration() {
                // do nothing
            }

            public static final String STEP_ONE = "RegistrationStepOneFragment";
            public static final String STEP_TWO = "RegistrationStepTwoFragment";
            public static final String STEP_THREE = "RegistrationStepThreeFragment";
            public static final String STEP_FOUR = "RegistrationStepFourFragment";
            public static final String STEP_FIVE = "RegistrationStepFiveFragment";
            public static final String STEP_SIX = "RegistrationStepSixFragment";
            public static final String STEP_SEVEN = "RegistrationStepSevenFragment";
            public static final String TWO_FACTOR = "TwoFactorAuthFragment";

        }


    }
}

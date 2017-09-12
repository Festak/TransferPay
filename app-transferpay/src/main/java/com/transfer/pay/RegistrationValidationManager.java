package com.transfer.pay;

import com.transfer.pay.utils.RegistrationValidationModel;

/**
 * @author e.fetskovich on 9/12/17.
 */

public class RegistrationValidationManager {

    private static RegistrationValidationModel validationModel;

    private RegistrationValidationManager() {
        // do nothing
    }

    public static RegistrationValidationModel getValidationModel() {
        if (validationModel == null) {
            setValidationModel(new RegistrationValidationModel());
        }
        return validationModel;
    }

    public static void setValidationModel(RegistrationValidationModel validationModel) {
        RegistrationValidationManager.validationModel = validationModel;
    }

}

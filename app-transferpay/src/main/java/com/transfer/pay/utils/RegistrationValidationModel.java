package com.transfer.pay.utils;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;

/**
 * @author e.fetskovich on 9/12/17.
 */

public class RegistrationValidationModel {
    public ObservableArrayList<ObservableArrayMap<String, String>> registrationValidationSteps = new ObservableArrayList<>();
    public ObservableField<Integer> currentStep = new ObservableField<>();

    public RegistrationValidationModel() {
        for (int i = 0; i < 4; i++) {
            registrationValidationSteps.add(new ObservableArrayMap<String, String>());
        }
    }

    public ObservableArrayMap<String, String> getCurrentValidationStep(){
        return registrationValidationSteps.get(currentStep.get());
    }


}

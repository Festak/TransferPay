package com.transfer.pay.ui.fragments.registration.stepone;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.databinding.RegistrationAmlStep1Binding;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.fragments.registration.RegistrationUserManager;
import com.transfer.pay.utils.validation.registration.RegistrationValidationManager;
import com.transfer.pay.utils.validation.registration.RegistrationValidationModel;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepOnePresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepOneViewHelper> {

    public void bindVariables(RegistrationAmlStep1Binding binding) {
        binding.setUser(RegistrationUserManager.getRegistrationUserManager().getUser());
        bindValidationModel(binding);
    }

    private void bindValidationModel(RegistrationAmlStep1Binding binding){
        RegistrationValidationManager.getValidationModel().currentStep.set(0);
        RegistrationValidationModel model = RegistrationValidationManager.getValidationModel();
        binding.setValidationModel(model);
    }

}

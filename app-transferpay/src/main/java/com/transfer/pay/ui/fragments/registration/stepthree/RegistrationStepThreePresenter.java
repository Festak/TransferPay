package com.transfer.pay.ui.fragments.registration.stepthree;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.databinding.RegistrationAmlStep3Binding;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.fragments.registration.RegistrationUserManager;
import com.transfer.pay.utils.validation.registration.RegistrationValidationManager;
import com.transfer.pay.utils.validation.registration.RegistrationValidationModel;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepThreePresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepThreeViewHelper> {

    public void bindVariables(RegistrationAmlStep3Binding binding){
        binding.setUser(RegistrationUserManager.getRegistrationUserManager().getUser());
        bindValidationModel(binding);
    }

    private void bindValidationModel(RegistrationAmlStep3Binding binding){
        RegistrationValidationManager.getValidationModel().currentStep.set(2);
        RegistrationValidationModel model = RegistrationValidationManager.getValidationModel();
        binding.setValidationModel(model);
    }

}

package com.transfer.pay.ui.fragments.registration.steptwo;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.databinding.RegistrationAmlStep2Binding;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.fragments.registration.RegistrationUserManager;
import com.transfer.pay.utils.validation.registration.RegistrationValidationManager;
import com.transfer.pay.utils.validation.registration.RegistrationValidationModel;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepTwoPresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepTwoViewHelper> {

    public void bindVariables(RegistrationAmlStep2Binding binding){
        binding.setUser(RegistrationUserManager.getRegistrationUserManager().getUser());
        bindValidationModel(binding);
    }

    private void bindValidationModel(RegistrationAmlStep2Binding binding){
        RegistrationValidationManager.getValidationModel().currentStep.set(1);
        RegistrationValidationModel model = RegistrationValidationManager.getValidationModel();
        binding.setValidationModel(model);
    }

}

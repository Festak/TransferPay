package com.transfer.pay.ui.fragments.registration.stepone;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.RegistrationAmlStep1Binding;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepOnePresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepOneViewHelper> {

    public void bindVariables(RegistrationAmlStep1Binding binding){
        binding.setUser(UserManager.getInstance().getUser());
    }

}

package com.transfer.pay.ui.fragments.registration.stepthree;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.RegistrationAmlStep3Binding;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepThreePresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepThreeViewHelper> {

    public void bindVariables(RegistrationAmlStep3Binding binding){
        binding.setUser(UserManager.getInstance().getUser());
    }

}

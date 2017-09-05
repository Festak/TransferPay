package com.transfer.pay.ui.fragments.registration.steptwo;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.RegistrationAmlStep2Binding;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepTwoPresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepTwoViewHelper> {

    public void bindVariables(RegistrationAmlStep2Binding binding){
        binding.setUser(UserManager.getInstance().getUser());
    }

}

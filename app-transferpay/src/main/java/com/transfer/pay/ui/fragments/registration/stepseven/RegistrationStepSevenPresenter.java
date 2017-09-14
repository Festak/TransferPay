package com.transfer.pay.ui.fragments.registration.stepseven;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.RegistrationAmlStep7Binding;
import com.transfer.pay.models.User;
import com.transfer.pay.ui.TransferPayBasePresenter;

import java.util.Date;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepSevenPresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepSevenViewHelper> {

    public void bindVariables(RegistrationAmlStep7Binding binding){
        User user = UserManager.getInstance().getUser();
        user.setApplicationPin(String.valueOf(new Date().getTime()));
        binding.setUser(user);
        UserManager.getInstance().saveUser();
    }

}

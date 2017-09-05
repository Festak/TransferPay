package com.transfer.pay.ui.fragments.registration.stepthree;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.RegistrationAmlStep3Binding;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepThreeViewHelper extends ViewHelper<RegistrationStepThreePresenter, RegistrationAmlStep3Binding> {

    @Override
    protected void onBindVariables(RegistrationAmlStep3Binding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.registration_aml_step3;
    }
}

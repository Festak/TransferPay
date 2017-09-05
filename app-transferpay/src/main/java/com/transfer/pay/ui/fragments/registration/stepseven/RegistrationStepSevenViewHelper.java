package com.transfer.pay.ui.fragments.registration.stepseven;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.RegistrationAmlStep7Binding;
import com.transfer.pay.ui.activities.registration.RegistrationPresenter;
import com.transfer.pay.ui.activities.registration.RegistrationViewHelper;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepSevenViewHelper extends ViewHelper<RegistrationStepSevenPresenter, RegistrationAmlStep7Binding> {

    @Override
    protected void onInitView() {
        RegistrationPresenter presenter = (RegistrationPresenter) getActivityContainer().getPresenter(ContainerId.Activity.REGISTRATION, null);
        RegistrationViewHelper helper = presenter.getViewHelper();

        prepareLayout(helper);
    }

    @Override
    protected void onBindVariables(RegistrationAmlStep7Binding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.registration_aml_step7;
    }

    private void prepareLayout(RegistrationViewHelper helper) {
        helper.hideActionAndStatusBar();
        helper.changeSecondButtonText(R.string.ok);
    }

}

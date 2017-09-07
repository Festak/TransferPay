package com.transfer.pay.ui.fragments.registration.stepsix;

import android.widget.EditText;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.RegistrationAmlStep6Binding;
import com.transfer.pay.ui.activities.registration.RegistrationPresenter;
import com.transfer.pay.ui.activities.registration.RegistrationViewHelper;
import com.transfer.pay.ui.customviews.AdaptiveButtonLayout;

/**
 * @author e.fetskovich on 6/5/17.
 */

public class RegistrationStepSixViewHelper extends ViewHelper<RegistrationStepSixPresenter, RegistrationAmlStep6Binding> {

    @Override
    protected void onInitView() {
        super.onInitView();
        changeStateOfUIComponents();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.registration_aml_step6;
    }

    @Override
    protected void onBindVariables(RegistrationAmlStep6Binding binding) {
        binding.setPresenter(getPresenter());
    }

    public RegistrationPresenter getRegistrationPresenter() {
        return (RegistrationPresenter) getActivityContainer().getPresenter(ContainerId.Activity.REGISTRATION, RegistrationPresenter.class);
    }

    public String getEnteredCodeFromText(){
        EditText editText = (EditText)findViewById(R.id.enteredCode);
        return editText.getText().toString();
    }

    private void changeStateOfUIComponents() {
        RegistrationPresenter presenter = (RegistrationPresenter) getActivityContainer().getPresenter(ContainerId.Activity.REGISTRATION, null);
        RegistrationViewHelper viewHelper = presenter.getViewHelper();
        prepareLayout(viewHelper);
        presenter.getViewData().putAdaptiveButtonType(AdaptiveButtonLayout.NOTHING);
    }

    private void prepareLayout(RegistrationViewHelper viewHelper) {
        viewHelper.setActionBarText(R.string.registration_aml_message_confirm_registration);
        viewHelper.changeSecondButtonText(R.string.registration_aml_button_confirm);
    }

}

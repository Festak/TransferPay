package com.transfer.pay.ui.fragments.registration.stepsix;

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

    private void changeStateOfUIComponents() {
        RegistrationPresenter presenter = (RegistrationPresenter) getActivityContainer().getPresenter(ContainerId.Activity.REGISTRATION, null);
        RegistrationViewHelper viewHelper = presenter.getViewHelper();
        prepareLayout(viewHelper);
        presenter.getViewData().putAdaptiveButtonType(AdaptiveButtonLayout.ONE_BUTTON);
    }

    private void prepareLayout(RegistrationViewHelper viewHelper) {
        viewHelper.setActionBarText(R.string.registration_aml_message_confirm_registration);
        viewHelper.changeSecondButtonText(R.string.registration_aml_button_confirm);

    }

}

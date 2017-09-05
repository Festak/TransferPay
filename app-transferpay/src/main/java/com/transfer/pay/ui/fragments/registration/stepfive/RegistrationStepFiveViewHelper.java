package com.transfer.pay.ui.fragments.registration.stepfive;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.RegistrationAmlStep5Binding;
import com.transfer.pay.ui.activities.registration.RegistrationPresenter;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepFiveViewHelper extends ViewHelper<RegistrationStepFivePresenter, RegistrationAmlStep5Binding> {

    @Override
    protected void onInitView() {
        changeActionBarText(R.string.terms_screen_title);
        getBinding().webView.loadUrl("file:///android_asset/agreements.html");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.registration_aml_step5;
    }

    private void changeActionBarText(int stringId) {
        RegistrationPresenter presenter = (RegistrationPresenter) getActivityContainer().getPresenter(ContainerId.Activity.REGISTRATION, RegistrationPresenter.class);
        presenter.getViewHelper().setActionBarText(stringId);
    }

}

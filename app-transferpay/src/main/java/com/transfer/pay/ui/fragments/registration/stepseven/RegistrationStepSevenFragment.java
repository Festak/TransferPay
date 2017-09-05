package com.transfer.pay.ui.fragments.registration.stepseven;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepSevenFragment extends TransferPayBaseFragment<EmptyViewModel, RegistrationStepSevenViewHelper, RegistrationStepSevenPresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected RegistrationStepSevenPresenter createPresenter() {
        return new RegistrationStepSevenPresenter();
    }

    @Override
    protected RegistrationStepSevenViewHelper createViewHelper() {
        return new RegistrationStepSevenViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.Registration.STEP_SEVEN;
    }
}

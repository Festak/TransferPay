package com.transfer.pay.ui.fragments.registration.stepone;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepOneFragment extends TransferPayBaseFragment<EmptyViewModel, RegistrationStepOneViewHelper, RegistrationStepOnePresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected RegistrationStepOnePresenter createPresenter() {
        return new RegistrationStepOnePresenter();
    }

    @Override
    protected RegistrationStepOneViewHelper createViewHelper() {
        return new RegistrationStepOneViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.Registration.STEP_ONE;
    }
}

package com.transfer.pay.ui.fragments.registration.stepfive;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepFiveFragment extends TransferPayBaseFragment<EmptyViewModel, RegistrationStepFiveViewHelper, RegistrationStepFivePresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected RegistrationStepFivePresenter createPresenter() {
        return new RegistrationStepFivePresenter();
    }

    @Override
    protected RegistrationStepFiveViewHelper createViewHelper() {
        return new RegistrationStepFiveViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.Registration.STEP_FIVE;
    }
}

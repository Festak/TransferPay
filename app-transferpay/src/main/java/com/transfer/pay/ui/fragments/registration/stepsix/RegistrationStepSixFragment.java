package com.transfer.pay.ui.fragments.registration.stepsix;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;
import com.transfer.pay.utils.connection.NetworkConnectionChecker;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepSixFragment extends TransferPayBaseFragment<EmptyViewModel, RegistrationStepSixViewHelper, RegistrationStepSixPresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected RegistrationStepSixPresenter createPresenter() {
        return new RegistrationStepSixPresenter(new NetworkConnectionChecker(getContext()));
    }

    @Override
    protected RegistrationStepSixViewHelper createViewHelper() {
        return new RegistrationStepSixViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.Registration.STEP_SIX;
    }
}

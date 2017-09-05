package com.transfer.pay.ui.fragments.registration.stepthree;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepThreeFragment extends TransferPayBaseFragment<EmptyViewModel, RegistrationStepThreeViewHelper, RegistrationStepThreePresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected RegistrationStepThreePresenter createPresenter() {
        return new RegistrationStepThreePresenter();
    }

    @Override
    protected RegistrationStepThreeViewHelper createViewHelper() {
        return new RegistrationStepThreeViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.Registration.STEP_THREE;
    }
}

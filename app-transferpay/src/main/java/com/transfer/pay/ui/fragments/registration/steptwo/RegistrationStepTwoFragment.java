package com.transfer.pay.ui.fragments.registration.steptwo;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepTwoFragment extends TransferPayBaseFragment<EmptyViewModel, RegistrationStepTwoViewHelper, RegistrationStepTwoPresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected RegistrationStepTwoPresenter createPresenter() {
        return new RegistrationStepTwoPresenter();
    }

    @Override
    protected RegistrationStepTwoViewHelper createViewHelper() {
        return new RegistrationStepTwoViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.Registration.STEP_TWO;
    }
}

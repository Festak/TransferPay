package com.transfer.pay.ui.activities.registration;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentSwitcher;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseActivity;
import com.transfer.pay.ui.fragments.RegistrationFragmentFactory;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationActivity extends TransferPayBaseActivity<RegistrationViewModel, RegistrationViewHelper, RegistrationPresenter> {

    @Override
    protected RegistrationViewModel createViewData() {
        return new RegistrationViewModel();
    }

    @Override
    protected RegistrationPresenter createPresenter() {
        FragmentSwitcher fragmentSwitcher = new FragmentSwitcher(
                getSupportFragmentManager(),
                new RegistrationFragmentFactory(),
                R.id.fragment_container,
                getViewModel()
        );

        return new RegistrationPresenter(fragmentSwitcher);
    }

    @Override
    protected RegistrationViewHelper createViewHelper() {
        return new RegistrationViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Activity.REGISTRATION;
    }
}

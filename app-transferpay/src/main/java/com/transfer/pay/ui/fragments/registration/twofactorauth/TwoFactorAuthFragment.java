package com.transfer.pay.ui.fragments.registration.twofactorauth;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by e.fetskovich on 6/21/17.
 */

public class TwoFactorAuthFragment extends TransferPayBaseFragment<EmptyViewModel, TwoFactorAuthViewHelper, TwoFactorAuthPresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected TwoFactorAuthPresenter createPresenter() {
        return new TwoFactorAuthPresenter();
    }

    @Override
    protected TwoFactorAuthViewHelper createViewHelper() {
        return new TwoFactorAuthViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.Registration.TWO_FACTOR;
    }
}

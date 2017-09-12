package com.transfer.pay.ui.activities.twofactorauth;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseActivity;
import com.transfer.pay.utils.connection.NetworkConnectionChecker;

/**
 * Created by e.fetskovich on 6/7/17.
 */

public class TwoFactorAuthActivity extends TransferPayBaseActivity<EmptyViewModel, TwoFactorAuthViewHelper, TwoFactorAuthPresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected TwoFactorAuthPresenter createPresenter() {
        return new TwoFactorAuthPresenter(new NetworkConnectionChecker(this));
    }

    @Override
    protected TwoFactorAuthViewHelper createViewHelper() {
        return new TwoFactorAuthViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Activity.TWO_FACTOR_AUTH;
    }
}

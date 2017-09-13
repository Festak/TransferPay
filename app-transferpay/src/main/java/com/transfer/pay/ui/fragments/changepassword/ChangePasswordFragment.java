package com.transfer.pay.ui.fragments.changepassword;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * @author e.fetskovich on 9/13/17.
 */

public class ChangePasswordFragment extends TransferPayBaseFragment<EmptyViewModel, ChangePasswordViewHelper, ChangePasswordPresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected ChangePasswordPresenter createPresenter() {
        return new ChangePasswordPresenter();
    }

    @Override
    protected ChangePasswordViewHelper createViewHelper() {
        return new ChangePasswordViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.CHANGE_PASSWORD;
    }
}

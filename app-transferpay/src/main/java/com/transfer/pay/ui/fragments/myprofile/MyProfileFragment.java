package com.transfer.pay.ui.fragments.myprofile;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

public class MyProfileFragment extends TransferPayBaseFragment<EmptyViewModel, MyProfileViewHelper, MyProfilePresenter> {

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected MyProfilePresenter createPresenter() {
        return new MyProfilePresenter();
    }

    @Override
    protected MyProfileViewHelper createViewHelper() {
        return new MyProfileViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.MY_PROFILE;
    }
}

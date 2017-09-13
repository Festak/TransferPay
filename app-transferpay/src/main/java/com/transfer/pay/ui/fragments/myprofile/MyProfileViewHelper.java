package com.transfer.pay.ui.fragments.myprofile;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.MyProfileBinding;
import com.transfer.pay.ui.activities.home.HomePresenter;

/**
 * Created by i.statkevich on 5/25/17.
 */


public class MyProfileViewHelper extends ViewHelper<MyProfilePresenter, MyProfileBinding> {

    @Override
    protected void onBindVariables(MyProfileBinding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.my_profile;
    }

    public void changeFragment(int fragmentId) {
        HomePresenter homePresenter = (HomePresenter) getActivityContainer().getPresenter(ContainerId.Activity.HOME, HomePresenter.class);
        homePresenter.changeContainerFragment(fragmentId);
    }

}

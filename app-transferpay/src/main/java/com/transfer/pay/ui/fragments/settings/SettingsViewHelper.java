package com.transfer.pay.ui.fragments.settings;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.SettingsBinding;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.activities.home.HomePresenter;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class SettingsViewHelper extends ViewHelper<SettingsPresenter, SettingsBinding> {

    @Override
    protected void onInitView() {
        configureSpinners();
    }

    @Override
    protected void onBindVariables(SettingsBinding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.settings;
    }

    public void openFragmentId(int fragmentId) {
        HomePresenter homePresenter = (HomePresenter) getActivityContainer().getPresenter(ContainerId.Activity.HOME, HomePresenter.class);
        homePresenter.changeContainerFragment(fragmentId);
    }

    private void configureSpinners() {
        UiConfigurator.initSpinnerAdapterWithResourceData(getBinding().spinnerDefaultCountry, R.array.countries);
    }

}

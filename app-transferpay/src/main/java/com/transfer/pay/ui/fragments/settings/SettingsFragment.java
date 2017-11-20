package com.transfer.pay.ui.fragments.settings;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;


public class SettingsFragment extends TransferPayBaseFragment<EmptyViewModel, SettingsViewHelper, SettingsPresenter> {

    @Override
    public void onPause() {
        super.onPause();
        DataManager.getInstance().saveSettings();
    }

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected SettingsPresenter createPresenter() {
        return new SettingsPresenter();
    }

    @Override
    protected SettingsViewHelper createViewHelper() {
        return new SettingsViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.SETTINGS;
    }
}

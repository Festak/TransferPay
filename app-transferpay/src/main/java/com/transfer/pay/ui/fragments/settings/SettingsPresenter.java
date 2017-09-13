package com.transfer.pay.ui.fragments.settings;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.databinding.SettingsBinding;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class SettingsPresenter extends TransferPayBasePresenter<EmptyViewModel, SettingsViewHelper> {

    public void bindVariables(SettingsBinding binding) {
        binding.setPresenter(this);
        binding.setSettings(DataManager.getInstance().getSettings());
    }

    public void onLoadLogoClick(){
        getViewHelper().openFragmentId(TransferPayFragmentFactory.ID_LOGO);
    }
}

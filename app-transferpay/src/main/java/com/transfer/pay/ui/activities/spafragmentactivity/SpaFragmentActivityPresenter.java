package com.transfer.pay.ui.activities.spafragmentactivity;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentSwitcher;
import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.utils.fragment.params.SpaFragmentBundleMapper;
import com.transfer.pay.utils.fragment.params.SpaFragmentParams;

public class SpaFragmentActivityPresenter extends TransferPayBasePresenter<EmptyViewModel, SpaFragmentActivityViewHelper> {
    private FragmentSwitcher fragmentSwitcher;

    public SpaFragmentActivityPresenter(FragmentSwitcher fragmentSwitcher) {
        this.fragmentSwitcher = fragmentSwitcher;
    }

    @Override
    protected void onPresenterReady() {
        initFragment();
    }

    public void onHomeButtonClick() {
        getScreen().closeScreen();
    }

    private void initFragment() {
        SpaFragmentParams fragmentParams = SpaFragmentBundleMapper.map(getContainer().getParams());
        fragmentSwitcher.switchTo(fragmentParams);
        getViewHelper().setActionBarTitle(fragmentParams.getTitle());
    }
}

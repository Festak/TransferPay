package com.transfer.pay.ui.fragments.wallet;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;


public class ProfitFragment extends TransferPayBaseFragment<EmptyViewModel, ProfitViewHelper, ProfitPresenter> {

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected ProfitPresenter createPresenter() {
        return new ProfitPresenter();
    }

    @Override
    protected ProfitViewHelper createViewHelper() {
        return new ProfitViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.PROFIT_FEE;
    }
}

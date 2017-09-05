package com.transfer.pay.ui.fragments.wallet;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class WalletFragment extends TransferPayBaseFragment<EmptyViewModel, WalletViewHelper, WalletPresenter> {

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected WalletPresenter createPresenter() {
        return new WalletPresenter();
    }

    @Override
    protected WalletViewHelper createViewHelper() {
        return new WalletViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.BENEFICIARIES;
    }
}

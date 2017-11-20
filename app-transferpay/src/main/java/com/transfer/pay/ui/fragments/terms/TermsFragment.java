package com.transfer.pay.ui.fragments.terms;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

public class TermsFragment extends TransferPayBaseFragment<EmptyViewModel, TermsViewHelper, TermsPresenter> {

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected TermsPresenter createPresenter() {
        return new TermsPresenter();
    }

    @Override
    protected TermsViewHelper createViewHelper() {
        return new TermsViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.BENEFICIARIES;
    }
}

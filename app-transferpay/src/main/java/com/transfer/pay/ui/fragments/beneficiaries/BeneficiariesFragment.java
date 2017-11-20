package com.transfer.pay.ui.fragments.beneficiaries;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

public class BeneficiariesFragment extends TransferPayBaseFragment<EmptyViewModel, BeneficiariesViewHelper, BeneficiariesPresenter> {

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected BeneficiariesPresenter createPresenter() {
        return new BeneficiariesPresenter();
    }

    @Override
    protected BeneficiariesViewHelper createViewHelper() {
        return new BeneficiariesViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.BENEFICIARIES;
    }
}

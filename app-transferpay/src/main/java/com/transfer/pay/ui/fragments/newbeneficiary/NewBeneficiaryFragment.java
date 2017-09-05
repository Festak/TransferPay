package com.transfer.pay.ui.fragments.newbeneficiary;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class NewBeneficiaryFragment extends TransferPayBaseFragment<EmptyViewModel, NewBeneficiaryViewHelper, NewBeneficiaryPresenter> {
    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected NewBeneficiaryPresenter createPresenter() {
        return new NewBeneficiaryPresenter();
    }

    @Override
    protected NewBeneficiaryViewHelper createViewHelper() {
        return new NewBeneficiaryViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.NEW_BENEFICIARY;
    }
}

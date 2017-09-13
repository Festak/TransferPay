package com.transfer.pay.ui.fragments.beneficiaries;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.ui.TransferPayBasePresenter;

import static com.transfer.pay.ui.fragments.TransferPayFragmentFactory.ID_NEW_BENEFICIARY;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class BeneficiariesPresenter extends TransferPayBasePresenter<EmptyViewModel, BeneficiariesViewHelper> {

    public void onNewBeneficiaryClick() {
        getViewHelper().changeFragment(ID_NEW_BENEFICIARY);
    }

    @Override
    protected void onPresenterReady() {
        getViewHelper().updateData(DataManager.getInstance().getBeneficiaries());
    }

    @Override
    public void onActivityResume() {
        getViewHelper().notifyDataInRecyclerChanged();
    }
}

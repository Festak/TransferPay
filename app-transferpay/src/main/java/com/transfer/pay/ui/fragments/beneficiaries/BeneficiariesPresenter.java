package com.transfer.pay.ui.fragments.beneficiaries;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.models.User;
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
        updateAllData();
    }

    @Override
    public void onActivityResume() {
        updateAllData();
    }

    private void updateAllData(){

        User user = UserManager.getInstance().getUser();
        getViewHelper().updateAccountsData(user.getBankAccountModels());
        getViewHelper().updateCardsData(user.getCreditCardsAccount());
    }

}

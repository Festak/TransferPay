package com.transfer.pay.ui.fragments.newbeneficiary;

import android.view.View;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.databinding.NewBeneficiaryBinding;
import com.transfer.pay.models.BankAccountModel;
import com.transfer.pay.models.CreditCardAccountModel;
import com.transfer.pay.models.NewBeneficiaryType;
import com.transfer.pay.models.Settings;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class NewBeneficiaryPresenter extends TransferPayBasePresenter<EmptyViewModel, NewBeneficiaryViewHelper> {

    public void onButtonSaveClick() {
        performFakeAsyncOperation(new Runnable() {
            @Override
            public void run() {
                insertDataToUser();
                UserManager.getInstance().updateUser();
                getScreen().closeScreen();
            }
        });
    }

    public void onShowTooltipClick(View v) {
        getViewHelper().showTooltip(v);
    }

    public void bindVariables(NewBeneficiaryBinding binding) {
        binding.setPresenter(this);
        binding.setBankAccountModel(initBankAccountModel());
        binding.setCard(new CreditCardAccountModel());
        binding.setBeneficiaryType(new NewBeneficiaryType());
    }

    private void insertDataToUser() {
        if (getViewHelper().getBinding().getBeneficiaryType().getBankAccount()) {
            UserManager.getInstance().insertBankAccount(getViewHelper().getBinding().getBankAccountModel());
        } else {
            UserManager.getInstance().insertCreditCardAccount(getViewHelper().getBinding().getCard());
        }
    }

    private BankAccountModel initBankAccountModel() {
        Settings settings = DataManager.getInstance().getSettings();
        BankAccountModel bankAccountModel = new BankAccountModel();
        bankAccountModel.setSettingsDataToBankAccount(settings);
        return bankAccountModel;
    }

}

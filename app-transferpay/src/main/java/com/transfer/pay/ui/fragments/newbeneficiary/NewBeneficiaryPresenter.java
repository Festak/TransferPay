package com.transfer.pay.ui.fragments.newbeneficiary;

import android.view.View;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.databinding.NewBeneficiaryBinding;
import com.transfer.pay.models.BankAccountModel;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.models.NewBeneficiaryType;
import com.transfer.pay.models.Settings;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.list.ListItemData;
import com.transfer.pay.ui.list.ListItemType;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class NewBeneficiaryPresenter extends TransferPayBasePresenter<EmptyViewModel, NewBeneficiaryViewHelper> {

    public void onButtonSaveClick() {
        performFakeAsyncOperation(new Runnable() {
            @Override
            public void run() {
                ListItemData itemData = initListItemData();

                DataManager.getInstance().insertBeneficiary(itemData);
                getScreen().closeScreen();
            }
        });
    }

    public void onShowTooltipClick(View v){
        getViewHelper().showTooltip(v);
    }

    public void bindVariables(NewBeneficiaryBinding binding) {
        binding.setPresenter(this);
        binding.setBankAccountModel(initBankAccountModel());
        binding.setCard(new CreditCardModel());
        binding.setBeneficiaryType(new NewBeneficiaryType());
    }

    private ListItemData initListItemData() {
        ListItemData itemData = new ListItemData();
        Object object = null;

        if (getViewHelper().getBinding().getBeneficiaryType().isBankAccount.get()) {
            itemData.setType(ListItemType.BENEFICIARY_BANK_ACCOUNT);
            object = getViewHelper().getBinding().getBankAccountModel();
        } else {
            itemData.setType(ListItemType.BENEFICIARY_CREDIT_CARD);
            object = getViewHelper().getBinding().getCard();
        }

        itemData.setData(object);
        return itemData;
    }

    private BankAccountModel initBankAccountModel() {
        Settings settings = DataManager.getInstance().getSettings();
        BankAccountModel bankAccountModel = new BankAccountModel();
        bankAccountModel.setSettingsDataToBankAccount(settings);
        return bankAccountModel;
    }

}

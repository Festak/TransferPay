package com.transfer.pay.ui.fragments.newbeneficiary;

import android.view.View;
import android.widget.Toast;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.databinding.NewBeneficiaryBinding;
import com.transfer.pay.iban.CountryCode;
import com.transfer.pay.iban.Iban;
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
        if (validateData()) {
            if (validateBankAccountNumber()) {
                performFakeAsyncOperation(new Runnable() {
                    @Override
                    public void run() {
                        insertDataToUser();
                        UserManager.getInstance().updateUser();
                        getScreen().closeScreen();
                    }
                });
            } else {
                getViewHelper().showToast(R.string.beneficiary_new_account_number, Toast.LENGTH_SHORT);
            }
        } else {
            getViewHelper().showToast(R.string.beneficiary_new_input_fields, Toast.LENGTH_SHORT);
        }
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

    private boolean validateBankAccountNumber() {
        String number = getViewHelper().getBinding().getBankAccountModel().getAccountNo();
        return number.length() == 11;
    }

    private boolean validateData() {
        NewBeneficiaryBinding binding = getViewHelper().getBinding();
        if (binding.getBeneficiaryType().getBankAccount()) {
            BankAccountModel bankAccountModel = binding.getBankAccountModel();
            return (notEmptyOrNull(bankAccountModel.getAccountNo()) &&
                    notEmptyOrNull(bankAccountModel.getChooseBank()) &&
                    notEmptyOrNull(bankAccountModel.getName()) &&
                    notEmptyOrNull(bankAccountModel.getCountry())
            );
        } else {
            CreditCardAccountModel creditCardModel = binding.getCard();
            return (notEmptyOrNull(creditCardModel.getCardHolderName()) &&
                    notEmptyOrNull(creditCardModel.getCardType()) &&
                    notEmptyOrNull(creditCardModel.getCreditCardNumber()) &&
                    notEmptyOrNull(creditCardModel.getCVV()) &&
                    notEmptyOrNull(creditCardModel.getValidDate())
            );
        }
    }

    private boolean notEmptyOrNull(String value) {
        if (value != null) {
            if (!value.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void insertDataToUser() {
        if (getViewHelper().getBinding().getBeneficiaryType().getBankAccount()) {
            Iban iban = null;
            BankAccountModel bankAccountModel = getViewHelper().getBinding().getBankAccountModel();
            try {
                CountryCode code = CountryCode.getCountryCodeByFullCountry(bankAccountModel.getCountry());
                iban = new Iban.Builder()
                        .accountNumber(bankAccountModel.getAccountNo())
                        .countryCode(code)
                        .bankCode(bankAccountModel.getChooseBank())
                        .buildRandom();

                bankAccountModel.setAccountNo(iban.toFormattedString());
            } catch (Exception e) {
                // do nothing
            }
            UserManager.getInstance().insertBankAccount(bankAccountModel);
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

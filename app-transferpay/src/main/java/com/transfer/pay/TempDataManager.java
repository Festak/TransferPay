package com.transfer.pay;

import com.transfer.pay.models.BankAccountModel;
import com.transfer.pay.models.CreditCardAccountModel;
import com.transfer.pay.models.CreditCardModel;

/**
 * @author e.fetskovich on 10/24/17.
 */

public class TempDataManager {

    public static TempDataManager dataManager;

    private BankAccountModel bankAccountModel;
    private CreditCardAccountModel creditCardAccountModel;

    private CreditCardModel creditCardModel;

    private TempDataManager() {
        // do nothing
    }

    public static TempDataManager getDataManager() {
        if (dataManager == null) {
            dataManager = new TempDataManager();
        }
        return dataManager;
    }


    public BankAccountModel getBankAccountModel() {
        return bankAccountModel;
    }

    public void setBankAccountModel(BankAccountModel bankAccountModel) {
        this.bankAccountModel = bankAccountModel;
    }

    public CreditCardAccountModel getCreditCardAccountModel() {
        return creditCardAccountModel;
    }

    public void setCreditCardAccountModel(CreditCardAccountModel creditCardAccountModel) {
        this.creditCardAccountModel = creditCardAccountModel;
    }

    public CreditCardModel getCreditCardModel() {
        return creditCardModel;
    }

    public void setCreditCardModel(CreditCardModel creditCardModel) {
        this.creditCardModel = creditCardModel;
    }

    public void deleteAllData() {
        bankAccountModel = null;
        creditCardAccountModel = null;
        creditCardModel = null;
    }

}

package com.transfer.pay.ui.activities.paymentoptiontab;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * @author e.fetskovich on 11/1/17.
 */

public class PaymentOptionTabPresenter extends TransferPayBasePresenter<EmptyViewModel, PaymentOptionTabViewHelper> {
    public void onHomeButtonClick(){
        getScreen().closeScreen();
    }
}

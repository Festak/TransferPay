package com.transfer.pay.ui.fragments.paymentresult;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.TempDataManager;
import com.transfer.pay.databinding.PaymentResultFragmentBinding;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * @author e.fetskovich on 11/9/17.
 */

public class PaymentResultPresenter extends TransferPayBasePresenter<EmptyViewModel, PaymentResultViewHelper> {

    public void onBindVariables(PaymentResultFragmentBinding binding) {
        binding.setTransaction(TempDataManager.getDataManager().getTransaction());
    }
    
}

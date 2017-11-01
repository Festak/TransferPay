package com.transfer.pay.ui.fragments.addcard;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.AddCardBinding;
import com.transfer.pay.ui.watchers.CreditCardWatcher;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class AddCardViewHelper extends ViewHelper<AddCardPresenter, AddCardBinding> {

    @Override
    protected void onInitView() {
        initEditText();
    }

    @Override
    protected void onBindVariables(AddCardBinding binding) {
        getPresenter().bindVariables(binding);
    }

    private void initEditText() {
        AddCardBinding binding = getBinding();
        binding.creditCardLayout.fieldCvvInput.setTransformationMethod(null);
        binding.creditCardLayout.fieldCardNumber.addTextChangedListener(new CreditCardWatcher());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.add_card;
    }


}

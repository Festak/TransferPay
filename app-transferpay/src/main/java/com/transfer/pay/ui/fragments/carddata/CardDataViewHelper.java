package com.transfer.pay.ui.fragments.carddata;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.CardDataBinding;

/**
 * @author e.fetskovich on 11/1/17.
 */

public class CardDataViewHelper extends ViewHelper<CardDataPresenter, CardDataBinding> {

    @Override
    protected void onInitView() {
        super.onInitView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.card_data;
    }
}

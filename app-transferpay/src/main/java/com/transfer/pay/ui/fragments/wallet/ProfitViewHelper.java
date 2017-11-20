package com.transfer.pay.ui.fragments.wallet;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.WalletBinding;

public class ProfitViewHelper extends ViewHelper<ProfitPresenter, WalletBinding> {

    @Override
    protected void onBindVariables(WalletBinding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected void onInitView() {
        super.onInitView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.wallet;
    }
}

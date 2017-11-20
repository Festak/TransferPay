package com.transfer.pay.ui.fragments.wallet;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.WalletBinding;

public class WalletViewHelper extends ViewHelper<WalletPresenter, WalletBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.wallet;
    }
}

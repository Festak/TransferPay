package com.transfer.pay.ui.activities.twofactorauth;

import android.support.v7.widget.Toolbar;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.TwoFactorAuthBinding;

/**
 * Created by e.fetskovich on 6/7/17.
 */

public class TwoFactorAuthViewHelper extends ViewHelper<TwoFactorAuthPresenter, TwoFactorAuthBinding> {

    public void setActionBarTitle(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar == null || title == null) {
            return;
        }

        toolbar.setTitle(title);
    }

    @Override
    protected void onInitView() {
        super.onInitView();
        String title = getActivityContainer().getString(R.string.two_factor_auth_title);
        setActionBarTitle(title);
    }

    @Override
    protected void onBindVariables(TwoFactorAuthBinding binding) {
        binding.setPresenter(getPresenter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.two_factor_auth;
    }
}

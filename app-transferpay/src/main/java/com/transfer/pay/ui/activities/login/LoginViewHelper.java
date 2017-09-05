package com.transfer.pay.ui.activities.login;

import android.support.v7.widget.Toolbar;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.LoginBinding;

/**
 * @author Created by i.statkevich on 5/24/17.
 */

public class LoginViewHelper extends ViewHelper<LoginPresenter, LoginBinding> {

    public void setActionBarTitle(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar == null || title == null) {
            return;
        }

        toolbar.setTitle(title);
    }

    @Override
    protected void onBindVariables(LoginBinding binding) {
        binding.setPresenter(getPresenter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.login;
    }

    @Override
    protected void onInitView() {
        String title = getActivityContainer().getString(R.string.login_screen_title);
        setActionBarTitle(title);
    }
}

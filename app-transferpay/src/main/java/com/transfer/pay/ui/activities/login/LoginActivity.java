package com.transfer.pay.ui.activities.login;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseActivity;

/**
 * @author Created by i.statkevich on 5/24/17.
 */

public class LoginActivity extends TransferPayBaseActivity<LoginViewModel, LoginViewHelper, LoginPresenter> {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_login_acivity, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return getScreenPresenter().onOptionsItemSelected(item);
    }

    @Override
    protected LoginViewModel createViewData() {
        return new LoginViewModel();
    }

    @Override
    protected LoginPresenter createPresenter() {
        LoginPresenter loginPresenter = new LoginPresenter();
        addToBackStack(loginPresenter);

        return loginPresenter;
    }

    @Override
    protected LoginViewHelper createViewHelper() {
        return new LoginViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Activity.LOGIN;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

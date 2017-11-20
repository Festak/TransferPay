package com.transfer.pay.ui.activities.login;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseActivity;

public class LoginActivity extends TransferPayBaseActivity<LoginViewModel, LoginViewHelper, LoginPresenter> {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_login_acivity, menu);

        MenuItem item = menu.getItem(0);
        SpannableString s = new SpannableString(item.getTitle());
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, s.length(), 0);
        item.setTitle(s);

        MenuItem item1 = menu.getItem(1);
        SpannableString s1 = new SpannableString(item1.getTitle());
        s1.setSpan(new ForegroundColorSpan(Color.BLACK), 0, s1.length(), 0);
        item1.setTitle(s1);

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

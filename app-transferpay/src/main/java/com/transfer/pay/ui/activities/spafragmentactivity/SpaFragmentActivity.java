package com.transfer.pay.ui.activities.spafragmentactivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentFactory;
import com.istatkevich.cmvp.core.fragmentswitcher.FragmentSwitcher;
import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.ui.TransferPayBaseActivity;

/**
 * @author Created by i.statkevich on 16.01.2017.
 */

public abstract class SpaFragmentActivity extends TransferPayBaseActivity<EmptyViewModel, SpaFragmentActivityViewHelper,
        SpaFragmentActivityPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected SpaFragmentActivityPresenter createPresenter() {
        return new SpaFragmentActivityPresenter(
                createFragmentSwitcher()
        );
    }

    @Override
    protected SpaFragmentActivityViewHelper createViewHelper() {
        return new SpaFragmentActivityViewHelper();
    }

    protected FragmentSwitcher createFragmentSwitcher() {
        return new FragmentSwitcher(
                getSupportFragmentManager(),
                createFragmentFactory(),
                R.id.spa_fragment_container,
                getViewModel()
        );
    }

    @Override
    public boolean onSupportNavigateUp() {
        getScreen().closeScreen();
        return super.onSupportNavigateUp();
    }

    protected abstract FragmentFactory createFragmentFactory();
}

package com.transfer.pay.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.istatkevich.cmvp.core.container.ActivityContainer;
import com.istatkevich.cmvp.core.presenter.Presenter;
import com.istatkevich.cmvp.core.router.Router;
import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.istatkevich.cmvp.core.viewmodel.ViewModel;
import com.transfer.pay.R;
import com.transfer.pay.TransferPayRouter;


public abstract class TransferPayBaseActivity<VD extends ViewModel, VH extends ViewHelper<P, ?>, P extends Presenter>
        extends ActivityContainer<VD, VH, P> {

    public TransferPayRouter getRemittanceRouter() {
        return getRouter(TransferPayRouter.class);
    }

    @Override
    protected Router createRouter() {
        return new TransferPayRouter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureActionBar();
    }

    private void configureActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar == null) {
            return;
        }

        setSupportActionBar(toolbar);
    }
}

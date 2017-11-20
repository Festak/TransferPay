package com.transfer.pay.ui.activities.fragmentactivity;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentFactory;
import com.istatkevich.cmvp.core.router.Router;
import com.transfer.pay.TransferPayRouter;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.activities.spafragmentactivity.SpaFragmentActivity;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;

public class TransferPayFragmentActivity extends SpaFragmentActivity {

    @Override
    protected FragmentFactory createFragmentFactory() {
        return new TransferPayFragmentFactory();
    }

    @Override
    protected Router createRouter() {
        return new TransferPayRouter(this);
    }

    @Override
    public String getContainerId() {
        return ContainerId.Activity.FRAGMENT_ACTIVITY;
    }
}

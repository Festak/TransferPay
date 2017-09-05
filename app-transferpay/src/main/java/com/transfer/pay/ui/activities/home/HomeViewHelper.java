package com.transfer.pay.ui.activities.home;

import android.widget.TextView;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.HomeBinding;

/**
 * Created by i.statkevich on 6/1/17.
 */

public class HomeViewHelper extends ViewHelper<HomePresenter, HomeBinding> {

    @Override
    protected void onInitView() {
        super.onInitView();
        TextView textView = (TextView) getBinding().navView.getHeaderView(0).findViewById(R.id.userNameMenu);
        getPresenter().setUserFullNameToText(textView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home;
    }
}

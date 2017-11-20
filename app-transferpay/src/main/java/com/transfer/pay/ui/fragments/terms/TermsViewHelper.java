package com.transfer.pay.ui.fragments.terms;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.TermsBinding;


public class TermsViewHelper extends ViewHelper<TermsPresenter, TermsBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.terms;
    }

    @Override
    protected void onInitView() {
        // Init WebView
        getBinding().webView.loadUrl("file:///android_asset/agreements.html");
    }
}

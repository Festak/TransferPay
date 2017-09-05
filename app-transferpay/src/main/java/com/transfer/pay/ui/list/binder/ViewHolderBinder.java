package com.transfer.pay.ui.list.binder;


import android.databinding.ViewDataBinding;

public interface ViewHolderBinder<B extends ViewDataBinding, I> {

    int getLayoutId();

    void bindHolder(B binding, I item, int position);
}

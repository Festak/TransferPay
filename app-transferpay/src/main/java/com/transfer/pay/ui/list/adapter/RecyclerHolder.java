package com.transfer.pay.ui.list.adapter;


import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class RecyclerHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T binding;

    public RecyclerHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public T getBinding() {
        return binding;
    }

    public void setBinding(T binding) {
        this.binding = binding;
    }
}
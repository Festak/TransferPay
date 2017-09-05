package com.transfer.pay.ui.list.adapter;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.transfer.pay.ui.list.binder.ViewHolderBinder;

import java.util.List;

public class RecyclerAdapter<B extends ViewDataBinding, I>
        extends RecyclerView.Adapter<RecyclerHolder<B>> {

    private List<I> list;
    private ViewHolderBinder<B, I> binder;

    public RecyclerAdapter(List<I> list, ViewHolderBinder<B, I> binder) {
        this.list = list;
        this.binder = binder;
    }

    @Override
    public RecyclerHolder<B> onCreateViewHolder(ViewGroup parent, int viewType) {
        B binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                binder.getLayoutId(),
                parent,
                false
        );

        return new RecyclerHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder<B> holder, int position) {
        I item = list.get(position);
        binder.bindHolder(
                holder.getBinding(),
                item,
                position
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public I getItemByPosition(int position) {
        return list.get(position);
    }

    public void updateData(List<I> items) {
        this.list = items;
        notifyDataSetChanged();
    }

    public void deleteItemByPosition(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

}

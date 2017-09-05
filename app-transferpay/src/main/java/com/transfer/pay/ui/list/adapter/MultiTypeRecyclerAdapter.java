package com.transfer.pay.ui.list.adapter;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.transfer.pay.ui.list.ListItemData;
import com.transfer.pay.ui.list.ListItemType;
import com.transfer.pay.ui.list.binder.BinderFactory;
import com.transfer.pay.ui.list.binder.ViewHolderBinder;

import java.util.List;

public class MultiTypeRecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {

    private List<ListItemData> list;
    private BinderFactory binderFactory;

    public MultiTypeRecyclerAdapter(List<ListItemData> list, BinderFactory binderFactory) {
        this.list = list;
        this.binderFactory = binderFactory;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemType listItemType = ListItemType.createByCode(viewType);

        if (listItemType == ListItemType.UNDEFINED) {
            return null;
        }

        ViewHolderBinder binder = binderFactory.create(listItemType);

        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                binder.getLayoutId(),
                parent,
                false
        );

        return new RecyclerHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        ListItemData item = list.get(position);
        ListItemType listItemType = item.getType();

        if (listItemType == ListItemType.UNDEFINED) {
            return;
        }

        ViewHolderBinder binder = binderFactory.create(item.getType());

        binder.bindHolder(
                holder.getBinding(),
                item.getData(),
                position
        );
    }

    public ListItemData getItemByPosition(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        ListItemData listItemData = list.get(position);
        return listItemData.getType().getCode();
    }

    public void deleteItemFromListByPosition(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

    public void updateData(List<ListItemData> items) {
        this.list = items;
        notifyDataSetChanged();
    }
}

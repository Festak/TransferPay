package com.transfer.pay.ui.fragments.transactionhistory;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.TransactionHistoryBinding;
import com.transfer.pay.databinding.TransactionHistoryItemBinding;
import com.transfer.pay.factories.LayoutManagerFactory;
import com.transfer.pay.models.Transaction;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.list.adapter.RecyclerAdapter;
import com.transfer.pay.ui.list.binder.HistoryItemBinder;
import com.transfer.pay.ui.list.binder.ViewHolderBinder;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by i.statkevich on 5/25/17.
 */


public class TransactionHistoryViewHelper extends ViewHelper<TransactionHistoryPresenter, TransactionHistoryBinding> {

    private RecyclerAdapter<TransactionHistoryItemBinding, Transaction> adapter;

    @Override
    protected void onInitView() {
        super.onInitView();
        initRecyclerView();
    }

    public void updateData(Collection<Transaction> list) {
        adapter.updateData(list);
    }

    @Override
    protected void onBindVariables(TransactionHistoryBinding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.transaction_history;
    }

    private void initRecyclerView() {
        ViewHolderBinder<TransactionHistoryItemBinding, Transaction> binder = new HistoryItemBinder();

        adapter = UiConfigurator.initRecyclerAndGetAdapter(
                new LinkedList<Transaction>(),
                binder,
                getRoot(),
                LayoutManagerFactory.createLinearLayoutManager(getRoot().getContext()),
                R.id.transactionHistorylist
        );
    }

}

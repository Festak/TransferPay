package com.transfer.pay.ui.fragments.carddata;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.CardDataBinding;
import com.transfer.pay.databinding.CurrencyItemBinding;
import com.transfer.pay.factories.LayoutManagerFactory;
import com.transfer.pay.models.Currency;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.list.adapter.RecyclerAdapter;
import com.transfer.pay.ui.list.binder.CurrencyBinder;
import com.transfer.pay.ui.list.binder.ViewHolderBinder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author e.fetskovich on 11/1/17.
 */

public class CardDataViewHelper extends ViewHelper<CardDataPresenter, CardDataBinding> {

    private RecyclerAdapter<CurrencyItemBinding, Currency> adapter;

    @Override
    protected void onBindVariables(CardDataBinding binding) {
        super.onBindVariables(binding);
        binding.setPresenter(getPresenter());
        getPresenter().initCardDataFields(binding);
    }

    @Override
    protected void onInitView() {
        super.onInitView();
        initRecyclerView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.card_data;
    }

    public void updateData(Collection<Currency> currencies) {
        adapter.updateData(currencies);
    }

    public void initSpinnerList(List<Currency> list) {
        UiConfigurator.initSpinnerAdapterWithObjects(getBinding().currenciesToChose, list);
    }


    private void initRecyclerView() {
        ViewHolderBinder<CurrencyItemBinding, Currency> binder = new CurrencyBinder();

        adapter = UiConfigurator.initRecyclerAndGetAdapter(
                new LinkedList<Currency>(),
                binder,
                getRoot(),
                LayoutManagerFactory.createLinearLayoutManager(getRoot().getContext()),
                R.id.currenciesList
        );
    }


}

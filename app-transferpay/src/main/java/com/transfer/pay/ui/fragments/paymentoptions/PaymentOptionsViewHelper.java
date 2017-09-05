package com.transfer.pay.ui.fragments.paymentoptions;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.CreditCardItemBinding;
import com.transfer.pay.databinding.PaymentOptionsBinding;
import com.transfer.pay.factories.LayoutManagerFactory;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.activities.home.HomePresenter;
import com.transfer.pay.ui.list.adapter.RecyclerAdapter;
import com.transfer.pay.ui.list.binder.CreditCardBinder;
import com.transfer.pay.ui.list.binder.ViewHolderBinder;
import com.transfer.pay.ui.list.listener.OnClickedItemListener;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class PaymentOptionsViewHelper extends ViewHelper<PaymentOptionsPresenter, PaymentOptionsBinding> {

    private RecyclerAdapter<CreditCardItemBinding, CreditCardModel> adapter;

    @Override
    protected void onBindVariables(PaymentOptionsBinding binding) {
        binding.setPresenter(getPresenter());
    }

    public void updateData(List<CreditCardModel> list) {
        adapter.updateData(list);
    }

    public void notifyDataInRecyclerChanged() {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onInitView() {
        initRecyclerView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.payment_options;
    }

    public void openFragmentId(int fragmentId) {
        HomePresenter homePresenter = (HomePresenter) getActivityContainer().getPresenter(ContainerId.Activity.HOME, HomePresenter.class);
        homePresenter.changeContainerFragment(fragmentId);
    }

    private void initRecyclerView() {
        ViewHolderBinder<CreditCardItemBinding, CreditCardModel> binder = new CreditCardBinder(new OnClickedItemListener() {
            @Override
            public void onClickedItem(int position) {
                adapter.deleteItemByPosition(position);
                DataManager.getInstance().saveCreditCards();
            }
        });

        adapter = UiConfigurator.initRecyclerAndGetAdapter(
                new LinkedList<CreditCardModel>(),
                binder,
                getRoot(),
                LayoutManagerFactory.createLinearLayoutManager(getRoot().getContext()),
                R.id.creditCardList
        );
    }

}

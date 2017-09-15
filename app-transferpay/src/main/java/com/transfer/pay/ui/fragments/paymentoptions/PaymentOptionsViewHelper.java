package com.transfer.pay.ui.fragments.paymentoptions;

import android.content.Intent;
import android.widget.LinearLayout;

import com.cooltechworks.creditcarddesign.CardEditActivity;
import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.data.DataManager;
import com.transfer.pay.databinding.CreditCardItemBinding;
import com.transfer.pay.databinding.PaymentOptionsBinding;
import com.transfer.pay.factories.LayoutManagerFactory;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.activities.home.HomePresenter;
import com.transfer.pay.ui.fragments.settingstab.SettingsTabFragment;
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

    public static final int CREATE_NEW_CARD = 0;

    private LinearLayout cardContainer;
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
        cardContainer = (LinearLayout)findViewById(R.id.card_container);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.payment_options;
    }

    public void openFragmentId(int fragmentId) {
        HomePresenter homePresenter = (HomePresenter) getActivityContainer().getPresenter(ContainerId.Activity.HOME, HomePresenter.class);
        homePresenter.changeContainerFragment(fragmentId);
    }

    public void addCreditCardIntent(){
        SettingsTabFragment fragment = (SettingsTabFragment) getActivityContainer().
                getSupportFragmentManager().
                findFragmentByTag(ContainerId.Fragment.SETTINGS_TAB);
        PaymentOptionsFragment fragment1 = fragment.getPaymentOptionsFragment();
        Intent intent = new Intent(fragment1.getContext() ,CardEditActivity.class);
        fragment1.startActivityForResult(intent, CREATE_NEW_CARD);
    }

    private void initRecyclerView() {
        ViewHolderBinder<CreditCardItemBinding, CreditCardModel> binder = new CreditCardBinder(new OnClickedItemListener() {
            @Override
            public void onClickedItem(int position) {
                adapter.deleteItemByPosition(position);
                DataManager.getInstance().saveCreditCards();
            }
        },
                new OnClickedItemListener() {
                    @Override
                    public void onClickedItem(int position) {
                        // TODO: FINISH EDIT LOGIC
                    }
                }
        );

        adapter = UiConfigurator.initRecyclerAndGetAdapter(
                new LinkedList<CreditCardModel>(),
                binder,
                getRoot(),
                LayoutManagerFactory.createLinearLayoutManager(getRoot().getContext()),
                R.id.creditCardList
        );
    }

}

package com.transfer.pay.ui.fragments.transactionoverview;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.efetskovich.snakeapplication.MainActivity;
import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.TransactionOverviewBinding;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.activities.home.HomePresenter;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class TransactionOverviewViewHelper extends ViewHelper<TransactionOverviewPresenter, TransactionOverviewBinding> {

    public static final int SNAKE_INTENT = 1;

    @Override
    protected void onInitView() {
        initSpinnerAdapter();
        initCheckedRadioButtonListener();
    }

    @Override
    protected void onBindVariables(TransactionOverviewBinding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.transaction_overview;
    }

    public void changeFragment(int fragmentId) {
        HomePresenter homePresenter = (HomePresenter) getActivityContainer().getPresenter(ContainerId.Activity.HOME, HomePresenter.class);
        homePresenter.changeContainerFragment(fragmentId);
    }

    public void startSnakeIntent() {
        Intent intent = new Intent(getRoot().getContext(), MainActivity.class);
        startIntent(intent, SNAKE_INTENT);
    }

    public void startIntent(Intent intent, int requestCode) {
        TransactionOverviewFragment fragment = (TransactionOverviewFragment) getActivityContainer().
                getSupportFragmentManager().
                findFragmentByTag(ContainerId.Fragment.TRANSACTION_OVERVIEW);
        fragment.startActivityForResult(intent, requestCode);
    }

    public void showNotEnoughMoneyMessage() {
        showToast(R.string.validation_not_enough_money, Toast.LENGTH_SHORT);
    }

    public void showMinimumSendMessage() {
        showToast(R.string.validation_minimum_transaction, Toast.LENGTH_SHORT);
    }

    private void initSpinnerAdapter() {
        UiConfigurator.initSpinnerAdapterWithObjects(getBinding().spinnerPaymentOptions, getPresenter().getPaymentOptions());
    }

    private void initCheckedRadioButtonListener() {
        getBinding().operationType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
                if (checkedRadioButton.isChecked()) {
                    getBinding().getTransaction().setOperationType(checkedRadioButton.getText().toString());
                }
            }
        });
    }

}

package com.transfer.pay.ui.activities.registration;

import android.os.Bundle;
import android.view.View;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentSwitcher;
import com.transfer.pay.UserManager;
import com.transfer.pay.constants.Fields;
import com.transfer.pay.databinding.RegistrationBaseBinding;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.registration.navigation.backnavigation.BackNavigation;
import com.transfer.pay.ui.registration.navigation.backnavigation.BackNavigationFragment;
import com.transfer.pay.ui.registration.navigation.confirmstrategy.ConfirmNavigation;
import com.transfer.pay.ui.registration.navigation.confirmstrategy.ConfirmNavigationFragment;
import com.transfer.pay.ui.registration.navigation.panelswitchers.ButtonPanelSwitcherImplementation;

/**
 * @author e.fetskovich on 6/5/17.
 */

public class RegistrationPresenter extends TransferPayBasePresenter<RegistrationViewModel, RegistrationViewHelper> {
    private FragmentSwitcher fragmentSwitcher;

    private ConfirmNavigation confirmNavigator;
    private BackNavigation backNavigator;

    public RegistrationPresenter(FragmentSwitcher fragmentSwitcher) {
        this.fragmentSwitcher = fragmentSwitcher;
    }

    public void onClickButtonCancelRegistration() {
        UserManager.getInstance().reInitUser();
        getScreen().closeScreen();
    }

    public void bindVariables(RegistrationBaseBinding binding) {
        binding.setPresenter(this);
        binding.adaptiveButton.setOnBackButtonClickListener(getOnBackClickListener());
        binding.adaptiveButton.setOnNextButtonClickListener(getOnNextClickListener());
    }

    public void onConfirmButtonClick() {
        getViewHelper().getBinding().adaptiveButton.performSecondButtonClick();
    }

    @Override
    protected void onPresenterReady() {
        initNavigator();
        getViewData().setAdaptiveButtonLayout(getViewHelper().getBinding().adaptiveButton);

        Bundle arguments = getContainer().getParams();
        int fragmentId = arguments.getInt(Fields.FRAGMENT_ID);
        Bundle fragmentArguments = arguments.getBundle(Fields.FRAGMENT_ARGUMENTS);

        fragmentSwitcher.switchTo(fragmentId, fragmentArguments);
    }

    private View.OnClickListener getOnBackClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backNavigator.navigateBack(getCurrentFragmentId());
            }
        };
    }

    private View.OnClickListener getOnNextClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmNavigator.navigateConfirm(getCurrentFragmentId());
            }
        };
    }

    private int getCurrentFragmentId() {
        return fragmentSwitcher.getFragmentParams().getId();
    }

    private void initNavigator() {
        confirmNavigator = new ConfirmNavigationFragment(
                fragmentSwitcher,
                getRemittanceRouter(),
                new ButtonPanelSwitcherImplementation(getViewData())
        );
        backNavigator = new BackNavigationFragment(fragmentSwitcher,
                getRemittanceRouter(),
                new ButtonPanelSwitcherImplementation(getViewData()));
    }
}

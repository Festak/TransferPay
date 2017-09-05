package com.transfer.pay.ui.registration.navigation.panelswitchers;


import com.transfer.pay.ui.activities.registration.RegistrationViewModel;
import com.transfer.pay.ui.customviews.AdaptiveButtonLayout;

public class ButtonPanelSwitcherImplementation implements ButtonPanelSwitcher {

    private RegistrationViewModel viewModel;

    public ButtonPanelSwitcherImplementation(RegistrationViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void showConfirmPanel() {
        viewModel.putAdaptiveButtonType(AdaptiveButtonLayout.BACK_NEXT_BUTTONS);
    }

    @Override
    public void showTwoButtonsPanel() {
        viewModel.putAdaptiveButtonType(AdaptiveButtonLayout.AGREEMENT_BUTTONS);
    }

    @Override
    public void hideButtonsLayout() {
        viewModel.putAdaptiveButtonType(AdaptiveButtonLayout.NOTHING);
    }
}

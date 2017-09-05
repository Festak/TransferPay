package com.transfer.pay.ui.registration.navigation.confirmstrategy;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentSwitcher;
import com.transfer.pay.TransferPayRouter;
import com.transfer.pay.ui.registration.navigation.RegistrationNavigator;
import com.transfer.pay.ui.registration.navigation.panelswitchers.ButtonPanelSwitcher;
import com.transfer.pay.ui.registration.navigation.Navigator;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class ConfirmNavigationFragment implements ConfirmNavigation {

    private Navigator confirmNavigator;

    public ConfirmNavigationFragment(FragmentSwitcher fragmentSwitcher, TransferPayRouter router, ButtonPanelSwitcher switcher) {
        confirmNavigator = new RegistrationNavigator(new ConfirmNavigationStrategy(), switcher, router, fragmentSwitcher);
    }

    @Override
    public void navigateConfirm(int form) {
        confirmNavigator.navigate(form);
    }

}

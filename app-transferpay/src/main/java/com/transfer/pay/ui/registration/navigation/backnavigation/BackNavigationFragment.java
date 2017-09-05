package com.transfer.pay.ui.registration.navigation.backnavigation;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentSwitcher;
import com.transfer.pay.TransferPayRouter;
import com.transfer.pay.ui.registration.navigation.Navigator;
import com.transfer.pay.ui.registration.navigation.RegistrationNavigator;
import com.transfer.pay.ui.registration.navigation.panelswitchers.ButtonPanelSwitcher;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class BackNavigationFragment implements BackNavigation {
    private Navigator backNavigation;

    public BackNavigationFragment(FragmentSwitcher fragmentSwitcher, TransferPayRouter router, ButtonPanelSwitcher switcher) {
        backNavigation = new RegistrationNavigator(new BackNavigationStrategy(), switcher, router, fragmentSwitcher);
    }

    @Override
    public void navigateBack(int from) {
        backNavigation.navigate(from);
    }
}

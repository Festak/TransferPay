package com.transfer.pay.ui.registration.navigation.backnavigation;

import com.transfer.pay.ui.fragments.RegistrationFragmentFactory;
import com.transfer.pay.ui.menu.navigator.DestinationParams;
import com.transfer.pay.ui.registration.navigation.NavigatorStrategy;
import com.transfer.pay.ui.registration.navigation.RegistrationNavigationTemplate;
import com.transfer.pay.ui.registration.navigation.panelswitchers.ButtonPanelSwitcher;

import java.util.Map;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class BackNavigationStrategy implements NavigatorStrategy {

    private Map<Integer, DestinationParams> navigationTemplate;

    public BackNavigationStrategy() {
        navigationTemplate = RegistrationNavigationTemplate.getBackNavigation();
    }

    @Override
    public void switchButtons(int from, ButtonPanelSwitcher buttonPanelSwitcher) {
        if (from == RegistrationFragmentFactory.REGISTRATION_STEP_FIVE) {
            buttonPanelSwitcher.showConfirmPanel();
        }
    }

    @Override
    public DestinationParams getNextDestination(int from) {
        return navigationTemplate.get(from);
    }

}

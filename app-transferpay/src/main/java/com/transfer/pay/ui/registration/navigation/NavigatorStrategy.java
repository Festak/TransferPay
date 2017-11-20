package com.transfer.pay.ui.registration.navigation;

import com.transfer.pay.ui.menu.navigator.DestinationParams;
import com.transfer.pay.ui.registration.navigation.panelswitchers.ButtonPanelSwitcher;

public interface NavigatorStrategy {
    void switchButtons(int from, ButtonPanelSwitcher buttonPanelSwitcher);
    DestinationParams getNextDestination(int from);
}

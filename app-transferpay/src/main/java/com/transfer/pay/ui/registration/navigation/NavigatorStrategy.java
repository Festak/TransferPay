package com.transfer.pay.ui.registration.navigation;

import com.transfer.pay.ui.menu.navigator.DestinationParams;
import com.transfer.pay.ui.registration.navigation.panelswitchers.ButtonPanelSwitcher;

/**
 * @author Created by i.statkevich on 5/19/17.
 */

public interface NavigatorStrategy {
    void switchButtons(int from, ButtonPanelSwitcher buttonPanelSwitcher);
    DestinationParams getNextDestination(int from);
}

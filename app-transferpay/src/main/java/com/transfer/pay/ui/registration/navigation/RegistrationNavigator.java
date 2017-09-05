package com.transfer.pay.ui.registration.navigation;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentParams;
import com.istatkevich.cmvp.core.fragmentswitcher.FragmentSwitcher;
import com.istatkevich.cmvp.core.router.ActivityDestinationParams;
import com.transfer.pay.TransferPayRouter;
import com.transfer.pay.ui.menu.navigator.DestinationParams;
import com.transfer.pay.ui.registration.navigation.panelswitchers.ButtonPanelSwitcher;
import com.transfer.pay.utils.fragment.params.SpaFragmentParams;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationNavigator implements Navigator {

    private NavigatorStrategy navigatorStrategy;
    private ButtonPanelSwitcher panelSwitcher;
    private TransferPayRouter router;
    private FragmentSwitcher fragmentSwitcher;

    public RegistrationNavigator(NavigatorStrategy navigatorStrategy, ButtonPanelSwitcher panelSwitcher, TransferPayRouter router, FragmentSwitcher fragmentSwitcher) {
        this.navigatorStrategy = navigatorStrategy;
        this.panelSwitcher = panelSwitcher;
        this.router = router;
        this.fragmentSwitcher = fragmentSwitcher;
    }

    @Override
    public void navigate(int from) {
        navigatorStrategy.switchButtons(from, panelSwitcher);

        DestinationParams destinationParams = navigatorStrategy.getNextDestination(from);

        switch (destinationParams.getType()){
            case ACTIVITY:
                ActivityDestinationParams activityDestinationParams = (ActivityDestinationParams) destinationParams.getParams();
                openActivity(activityDestinationParams);
                break;
            case FRAGMENT:
                SpaFragmentParams fragmentParams = (SpaFragmentParams) destinationParams.getParams();
                openFragment(fragmentParams);
                break;
            default:
                // do nothing
        }

    }

    private void openFragment(FragmentParams fragmentParams) {
        fragmentSwitcher.switchTo(fragmentParams);
    }

    private void openActivity(ActivityDestinationParams destinationParams) {
        router.openActivity(destinationParams);
    }

}

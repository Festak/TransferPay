package com.transfer.pay.ui.menu.navigator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentParams;
import com.istatkevich.cmvp.core.fragmentswitcher.FragmentSwitcher;
import com.istatkevich.cmvp.core.router.ActivityDestinationParams;
import com.transfer.pay.R;
import com.transfer.pay.TransferPayRouter;
import com.transfer.pay.UserManager;
import com.transfer.pay.utils.fragment.params.SpaFragmentParams;

import java.util.Map;

/**
 * Created by i.statkevich on 5/30/17.
 */

public class MainMenuNavigator implements Navigator {
    private AppCompatActivity activity;
    private FragmentSwitcher fragmentSwitcher;
    private TransferPayRouter transferPayRouter;
    private Map<Integer, DestinationParams> navigationMap;

    public MainMenuNavigator(AppCompatActivity activity, FragmentSwitcher fragmentSwitcher, TransferPayRouter transferPayRouter, Map<Integer, DestinationParams> navigationMap) {
        this.activity = activity;
        this.navigationMap = navigationMap;
        this.fragmentSwitcher = fragmentSwitcher;
        this.transferPayRouter = transferPayRouter;
    }

    @Override
    public void navigate(Bundle bundle, int menuItemId) {
        if (menuItemId == R.id.nav_logout) {
            performLogout();
            return;
        }

        DestinationParams destinationParams = navigationMap.get(menuItemId);

        switch (destinationParams.getType()) {
            case FRAGMENT:
                SpaFragmentParams fragmentParams = (SpaFragmentParams) destinationParams.getParams();
                fragmentParams.setArguments(bundle);
                activity.setTitle(fragmentParams.getTitle());
                openFragment(fragmentParams);
                break;
            case ACTIVITY:
                ActivityDestinationParams activityDestinationParams = (ActivityDestinationParams) destinationParams.getParams();
                openActivity(activityDestinationParams);
                break;
            default:
                // do nothing
        }
    }

    private void openFragment(FragmentParams fragmentParams) {
        fragmentSwitcher.switchTo(fragmentParams);
    }

    private void openActivity(ActivityDestinationParams destinationParams) {
        transferPayRouter.openActivity(destinationParams);
    }

    private void performLogout() {
        UserManager.getInstance().performLogout();
        activity.finish();
    }
}

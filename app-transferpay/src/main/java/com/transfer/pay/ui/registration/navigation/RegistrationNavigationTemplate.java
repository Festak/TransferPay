package com.transfer.pay.ui.registration.navigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.istatkevich.cmvp.core.router.ActivityDestinationParams;
import com.transfer.pay.ui.activities.login.LoginActivity;
import com.transfer.pay.ui.fragments.RegistrationFragmentFactory;
import com.transfer.pay.ui.menu.navigator.DestinationParams;
import com.transfer.pay.ui.menu.navigator.DestinationType;
import com.transfer.pay.utils.fragment.params.SpaFragmentParams;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class RegistrationNavigationTemplate {

    private static Map<Integer, DestinationParams> confirmNavigation;
    private static Map<Integer, DestinationParams> backNavigation;

    private RegistrationNavigationTemplate() {
        // do nothing
    }

    public static Map<Integer, DestinationParams> getConfirmNavigation() {
        if (confirmNavigation == null) {
            createConfirmNavigation();
        }
        return confirmNavigation;
    }


    public static Map<Integer, DestinationParams> getBackNavigation() {
        if (backNavigation == null) {
            createBackNavigation();
        }
        return backNavigation;
    }


    private static void createConfirmNavigation() {
        confirmNavigation = new HashMap<>();

        confirmNavigation.put(
                RegistrationFragmentFactory.REGISTRATION_STEP_ONE,
                createDestinationFragment(
                        RegistrationFragmentFactory.REGISTRATION_STEP_TWO,
                        null)
        );
        confirmNavigation.put(
                RegistrationFragmentFactory.REGISTRATION_STEP_TWO,
                createDestinationFragment(
                        RegistrationFragmentFactory.REGISTRATION_STEP_THREE,
                        null
                )
        );
        confirmNavigation.put(
                RegistrationFragmentFactory.REGISTRATION_STEP_THREE,
                createDestinationFragment(
                        RegistrationFragmentFactory.REGISTRATION_STEP_FOUR,
                        null
                )
        );

        confirmNavigation.put(
                RegistrationFragmentFactory.REGISTRATION_STEP_FOUR,
                createDestinationFragment(
                        RegistrationFragmentFactory.REGISTRATION_STEP_FIVE,
                        null
                )
        );

        confirmNavigation.put(
                RegistrationFragmentFactory.REGISTRATION_STEP_SIX,
                createDestinationFragment(
                        RegistrationFragmentFactory.TWO_FACTOR_AUTH,
                        null
                )
        );

        confirmNavigation.put(
                RegistrationFragmentFactory.REGISTRATION_STEP_SEVEN,
                createDestinationActivity(
                        LoginActivity.class,
                        null
                )
        );

        confirmNavigation.put(
                RegistrationFragmentFactory.TWO_FACTOR_AUTH,
                createDestinationFragment(
                        RegistrationFragmentFactory.REGISTRATION_STEP_SEVEN,
                        null
                )
        );

        confirmNavigation.put(RegistrationFragmentFactory.REGISTRATION_STEP_FIVE,
                createDestinationFragment(
                        RegistrationFragmentFactory.REGISTRATION_STEP_SIX,
                        null
                )
        );

    }

    private static void createBackNavigation() {
        backNavigation = new HashMap<>();

        backNavigation.put(RegistrationFragmentFactory.REGISTRATION_STEP_ONE,
                createDestinationActivity(LoginActivity.class, null));

        backNavigation.put(RegistrationFragmentFactory.REGISTRATION_STEP_TWO,
                createDestinationFragment(
                        RegistrationFragmentFactory.REGISTRATION_STEP_ONE,
                        null
                )
        );

        backNavigation.put(RegistrationFragmentFactory.REGISTRATION_STEP_THREE,
                createDestinationFragment(
                        RegistrationFragmentFactory.REGISTRATION_STEP_TWO,
                        null
                )
        );
        backNavigation.put(RegistrationFragmentFactory.REGISTRATION_STEP_FOUR,
                createDestinationFragment(
                        RegistrationFragmentFactory.REGISTRATION_STEP_THREE,
                        null
                )
        );

        backNavigation.put(RegistrationFragmentFactory.REGISTRATION_STEP_FIVE,
                createDestinationActivity(
                        LoginActivity.class,
                        null
                )
        );

    }

    private static DestinationParams createDestinationActivity(Class<? extends AppCompatActivity> clazz, Bundle arguments) {
        return new DestinationParams(
                DestinationType.ACTIVITY,
                new ActivityDestinationParams(clazz, arguments)
        );
    }

    private static DestinationParams createDestinationFragment(int fragmentId, Bundle arguments) {

        return new DestinationParams(
                DestinationType.FRAGMENT,
                new SpaFragmentParams(fragmentId, arguments, "test")
        );
    }
}

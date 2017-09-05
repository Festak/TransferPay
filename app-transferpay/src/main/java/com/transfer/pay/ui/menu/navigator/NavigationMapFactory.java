package com.transfer.pay.ui.menu.navigator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.istatkevich.cmvp.core.router.ActivityDestinationParams;
import com.transfer.pay.R;
import com.transfer.pay.ui.activities.fragmentactivity.TransferPayFragmentActivity;
import com.transfer.pay.ui.fragments.RemittanceFragmentFactory;
import com.transfer.pay.utils.fragment.params.SpaFragmentBundleFactory;
import com.transfer.pay.utils.fragment.params.SpaFragmentParams;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by i.statkevich on 6/1/17.
 */

public class NavigationMapFactory {
    private Context context;

    public NavigationMapFactory(Context context) {
        this.context = context;
    }


    public Map<Integer, DestinationParams> createContainerMapNavigation() {
        Map<Integer, DestinationParams> map = new HashMap<>();

        map.put(
                RemittanceFragmentFactory.ID_NEW_BENEFICIARY,
                createDestinationFragmentActivity(RemittanceFragmentFactory.ID_NEW_BENEFICIARY,
                        null,
                        R.string.beneficiary_new_title
                )
        );
        map.put(
                RemittanceFragmentFactory.ID_ADD_CARD,
                createDestinationFragmentActivity(RemittanceFragmentFactory.ID_ADD_CARD,
                        null,
                        R.string.add_card_screen_title

                )
        );
        map.put(
                RemittanceFragmentFactory.ID_TRANSACTION_OVERVIEW,
                createDestinationFragment(RemittanceFragmentFactory.ID_TRANSACTION_OVERVIEW,
                        null,
                        R.string.transaction_overview_title
                )
        );
        map.put(RemittanceFragmentFactory.ID_PAYMENT_OPTIONS,
                createDestinationFragment(RemittanceFragmentFactory.ID_PAYMENT_OPTIONS,
                        null,
                        R.string.settings_button_payment_option
                )
        );
        map.put(RemittanceFragmentFactory.ID_BENEFICIARIES,
                createDestinationFragment(RemittanceFragmentFactory.ID_BENEFICIARIES,
                        null,
                        R.string.beneficiaries_screen_title
                )
        );
        map.put(RemittanceFragmentFactory.ID_SETTINGS_TAB,
                createDestinationFragment(RemittanceFragmentFactory.ID_SETTINGS_TAB,
                        null,
                        R.string.settings_screen_title
                )
        );

        map.put(RemittanceFragmentFactory.ID_TRANSACTION_HISTORY,
                createDestinationFragment(RemittanceFragmentFactory.ID_TRANSACTION_HISTORY,
                        null,
                        R.string.transaction_history_title
                )
        );

        map.put(RemittanceFragmentFactory.ID_LOGO,
                createDestinationFragmentActivity(RemittanceFragmentFactory.ID_LOGO,
                        null,
                        R.string.logo_title
                )
        );

        return map;
    }

    public Map<Integer, DestinationParams> createMainMenu() {
        Map<Integer, DestinationParams> map = new HashMap<>();
        map.put(
                R.id.nav_beneficiaries,
                createDestinationFragment(
                        RemittanceFragmentFactory.ID_BENEFICIARIES,
                        null,
                        R.string.beneficiaries_screen_title
                )
        );
        map.put(
                R.id.nav_transaction_history,
                createDestinationFragment(
                        RemittanceFragmentFactory.ID_TRANSACTION_HISTORY,
                        null,
                        R.string.transaction_history_title
                )
        );
        map.put(
                R.id.nav_wallet,
                createDestinationFragment(
                        RemittanceFragmentFactory.ID_WALLET,
                        null,
                        R.string.wallet_title
                )
        );
        map.put(R.id.nav_my_profile,
                createDestinationFragment(
                        RemittanceFragmentFactory.ID_MY_PROFILE,
                        null,
                        R.string.my_profile_title
                )
        );
        map.put(
                R.id.nav_terms,
                createDestinationFragment(
                        RemittanceFragmentFactory.ID_TERMS,
                        null,
                        R.string.terms_screen_title
                )
        );
        map.put(
                R.id.nav_settings,
                createDestinationFragment(
                        RemittanceFragmentFactory.ID_SETTINGS_TAB,
                        null,
                        R.string.settings_screen_title
                )
        );

        return map;
    }

    private DestinationParams createDestinationActivity(Class<? extends AppCompatActivity> clazz, Bundle arguments) {
        return new DestinationParams(
                DestinationType.ACTIVITY,
                new ActivityDestinationParams(clazz, arguments)
        );
    }

    private DestinationParams createDestinationFragmentActivity(int fragmentId, Bundle fragmentArguments, int titleId) {
        String title = context.getString(titleId);

        return new DestinationParams(
                DestinationType.ACTIVITY,
                new ActivityDestinationParams(
                        TransferPayFragmentActivity.class,
                        SpaFragmentBundleFactory.createBundle(fragmentId, fragmentArguments, title)
                )
        );
    }

    private DestinationParams createDestinationFragment(int fragmentId, Bundle arguments, int titleId) {
        String title = context.getString(titleId);

        return new DestinationParams(
                DestinationType.FRAGMENT,
                new SpaFragmentParams(fragmentId, arguments, title)
        );
    }
}

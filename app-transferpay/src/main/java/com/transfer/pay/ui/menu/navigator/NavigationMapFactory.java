package com.transfer.pay.ui.menu.navigator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.istatkevich.cmvp.core.router.ActivityDestinationParams;
import com.transfer.pay.R;
import com.transfer.pay.ui.activities.fragmentactivity.TransferPayFragmentActivity;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;
import com.transfer.pay.utils.fragment.params.SpaFragmentBundleFactory;
import com.transfer.pay.utils.fragment.params.SpaFragmentParams;

import java.util.HashMap;
import java.util.Map;

public class NavigationMapFactory {
    private Context context;

    public NavigationMapFactory(Context context) {
        this.context = context;
    }


    public Map<Integer, DestinationParams> createContainerMapNavigation() {
        Map<Integer, DestinationParams> map = new HashMap<>();

        map.put(
                TransferPayFragmentFactory.ID_NEW_BENEFICIARY,
                createDestinationFragmentActivity(TransferPayFragmentFactory.ID_NEW_BENEFICIARY,
                        null,
                        R.string.beneficiary_new_title
                )
        );
        map.put(
                TransferPayFragmentFactory.ID_ADD_CARD,
                createDestinationFragmentActivity(TransferPayFragmentFactory.ID_ADD_CARD,
                        null,
                        R.string.add_card_screen_title

                )
        );
        map.put(
                TransferPayFragmentFactory.ID_TRANSACTION_OVERVIEW,
                createDestinationFragment(TransferPayFragmentFactory.ID_TRANSACTION_OVERVIEW,
                        null,
                        R.string.transaction_overview_title
                )
        );
        map.put(TransferPayFragmentFactory.ID_PAYMENT_OPTIONS,
                createDestinationFragment(TransferPayFragmentFactory.ID_PAYMENT_OPTIONS,
                        null,
                        R.string.settings_button_payment_option
                )
        );
        map.put(TransferPayFragmentFactory.ID_BENEFICIARIES,
                createDestinationFragment(TransferPayFragmentFactory.ID_BENEFICIARIES,
                        null,
                        R.string.beneficiaries_screen_title
                )
        );
        map.put(TransferPayFragmentFactory.ID_SETTINGS_TAB,
                createDestinationFragment(TransferPayFragmentFactory.ID_SETTINGS_TAB,
                        null,
                        R.string.settings_screen_title
                )
        );

        map.put(TransferPayFragmentFactory.ID_TRANSACTION_HISTORY,
                createDestinationFragment(TransferPayFragmentFactory.ID_TRANSACTION_HISTORY,
                        null,
                        R.string.transaction_history_title
                )
        );

        map.put(TransferPayFragmentFactory.ID_LOGO,
                createDestinationFragmentActivity(TransferPayFragmentFactory.ID_LOGO,
                        null,
                        R.string.logo_title
                )
        );
        map.put(TransferPayFragmentFactory.ID_CHANGEPASS,
                createDestinationFragmentActivity(TransferPayFragmentFactory.ID_CHANGEPASS,
                        null,
                        R.string.change_password_title
                )
        );

        map.put(TransferPayFragmentFactory.ID_PAYMENT_RESULT,
                createDestinationFragment(TransferPayFragmentFactory.ID_PAYMENT_RESULT,
                        null,
                        R.string.payment_result_title
                )
        );

        return map;
    }

    public Map<Integer, DestinationParams> createMainMenu() {
        Map<Integer, DestinationParams> map = new HashMap<>();
        map.put(
                R.id.nav_beneficiaries,
                createDestinationFragment(
                        TransferPayFragmentFactory.ID_BENEFICIARIES,
                        null,
                        R.string.beneficiaries_screen_title
                )
        );
        map.put(
                R.id.nav_transaction_history,
                createDestinationFragment(
                        TransferPayFragmentFactory.ID_TRANSACTION_HISTORY,
                        null,
                        R.string.transaction_history_title
                )
        );
        map.put(
                R.id.transfer_fee_profit,
                createDestinationFragment(
                        TransferPayFragmentFactory.ID_TRANSFER_FEE_PROFIT,
                        null,
                        R.string.profit_title
                )
        );
        map.put(R.id.nav_my_profile,
                createDestinationFragment(
                        TransferPayFragmentFactory.ID_MY_PROFILE,
                        null,
                        R.string.my_profile_title
                )
        );
        map.put(
                R.id.nav_terms,
                createDestinationFragment(
                        TransferPayFragmentFactory.ID_TERMS,
                        null,
                        R.string.terms_screen_title
                )
        );
        map.put(
                R.id.nav_settings,
                createDestinationFragment(
                        TransferPayFragmentFactory.ID_SETTINGS_TAB,
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

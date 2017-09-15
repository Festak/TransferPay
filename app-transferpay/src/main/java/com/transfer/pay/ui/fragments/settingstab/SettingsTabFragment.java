package com.transfer.pay.ui.fragments.settingstab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.transfer.pay.data.DataManager;
import com.transfer.pay.R;
import com.transfer.pay.ui.fragments.paymentoptions.PaymentOptionsFragment;
import com.transfer.pay.ui.fragments.settings.SettingsFragment;
import com.transfer.pay.ui.viewpager.ViewPagerAdapter;

/**
 * Created by e.fetskovich on 6/14/17.
 */

public class SettingsTabFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment, container, false);
        initViewPager(view);
        return view;
    }

    public PaymentOptionsFragment getPaymentOptionsFragment(){
        return (PaymentOptionsFragment)viewPagerAdapter.getItem(1);
    }

    private void initViewPager(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(createTabSelectedListener());
    }

    private void setupViewPager(ViewPager viewPager) {
        this.viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        viewPagerAdapter.addFragment(new SettingsFragment(), getContext().getString(R.string.settings_default_title));
        viewPagerAdapter.addFragment(new PaymentOptionsFragment(), getContext().getString(R.string.settings_button_payment_option));

        viewPager.setAdapter(viewPagerAdapter);
    }

    private TabLayout.OnTabSelectedListener createTabSelectedListener() {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // do nothing
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    DataManager.getInstance().saveSettings();
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // do nothing
            }
        };
    }

}

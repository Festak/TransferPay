package com.transfer.pay.ui.activities.paymentoptiontab;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.PaymentOptionTabBinding;
import com.transfer.pay.ui.fragments.addcard.AddCardFragment;
import com.transfer.pay.ui.fragments.carddata.CardDataFragment;
import com.transfer.pay.ui.viewpager.ViewPagerAdapter;

/**
 * @author e.fetskovich on 11/1/17.
 */

public class PaymentOptionTabViewHelper extends ViewHelper<PaymentOptionTabPresenter, PaymentOptionTabBinding> {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;

    private Toolbar toolbar;

    public void setActionBarTitle(String title) {
        if (toolbar == null || title == null) {
            return;
        }

        toolbar.setTitle(title);
    }


    @Override
    protected void onInitView() {
        super.onInitView();
        initActionBar();
        initViewPager();
    }


    private void initViewPager() {
        viewPager = getBinding().viewPager;
        tabLayout = getBinding().tabLayout;
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(createTabSelectedListener());
    }

    private void setupViewPager(ViewPager viewPager) {
        this.viewPagerAdapter = new ViewPagerAdapter(getActivityContainer().getSupportFragmentManager());

        viewPagerAdapter.addFragment(new AddCardFragment(), getActivityContainer().getString(R.string.card_edit));
        viewPagerAdapter.addFragment(new CardDataFragment(), getActivityContainer().getString(R.string.card_data_screen_title));

        viewPager.setAdapter(viewPagerAdapter);
    }

    private void initActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar == null) {
            return;
        }
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onHomeButtonClick();
            }
        });
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
                    // do nothing
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // do nothing
            }
        };
    }

    @Override
    protected int getLayoutId() {
        return R.layout.payment_option_tab;
    }
}

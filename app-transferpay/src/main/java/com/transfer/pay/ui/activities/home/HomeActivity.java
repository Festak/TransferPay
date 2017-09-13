package com.transfer.pay.ui.activities.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentFactory;
import com.istatkevich.cmvp.core.fragmentswitcher.FragmentSwitcher;
import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseActivity;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;
import com.transfer.pay.ui.menu.menudelegate.MainMenuDelegate;
import com.transfer.pay.ui.menu.menudelegate.MenuDelegate;
import com.transfer.pay.ui.menu.navigator.MainMenuNavigator;
import com.transfer.pay.ui.menu.navigator.NavigationMapFactory;
import com.transfer.pay.ui.menu.navigator.Navigator;

public class HomeActivity extends TransferPayBaseActivity<EmptyViewModel, HomeViewHelper, HomePresenter> {

    private MenuDelegate mainMenuDelegate;

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected HomePresenter createPresenter() {
        FragmentFactory fragmentFactory = new TransferPayFragmentFactory();

        FragmentSwitcher fragmentSwitcher = new FragmentSwitcher(getSupportFragmentManager(), fragmentFactory, R.id.fragment_container, getViewModel());

        Navigator navigator = new MainMenuNavigator(
                this,
                fragmentSwitcher,
                getRemittanceRouter(),
                new NavigationMapFactory(this).createMainMenu()
        );

        Navigator containerNavigator = new MainMenuNavigator(
                this,
                fragmentSwitcher,
                getRemittanceRouter(),
                new NavigationMapFactory(this).createContainerMapNavigation()
        );

        return new HomePresenter(navigator, containerNavigator, R.id.nav_beneficiaries);
    }

    @Override
    protected HomeViewHelper createViewHelper() {
        return new HomeViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Activity.HOME;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMainMenu();
    }

    @Override
    public void onBackPressed() {
        if (!mainMenuDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    private void initMainMenu() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        mainMenuDelegate = new MainMenuDelegate();
        mainMenuDelegate.onInit(this, toolbar, drawer, navigationView, getScreenPresenter());
    }
}

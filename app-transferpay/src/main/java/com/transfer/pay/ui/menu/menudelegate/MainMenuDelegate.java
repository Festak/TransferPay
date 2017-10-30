package com.transfer.pay.ui.menu.menudelegate;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.transfer.pay.R;
import com.transfer.pay.ui.menu.navigator.Navigator;

public class MainMenuDelegate implements MenuDelegate {
    private DrawerLayout drawer;
    private Navigator navigator;

    @Override
    public void onInit(Activity activity, Toolbar toolbar, DrawerLayout drawer, NavigationView navigationView, Navigator navigator) {
        this.drawer = drawer;
        this.navigator = navigator;

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activity,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        navigator.navigate(null, menuItem.getItemId());
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

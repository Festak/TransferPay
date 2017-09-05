package com.transfer.pay.ui.menu.menudelegate;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.transfer.pay.ui.menu.navigator.Navigator;

/**
 * Created by i.statkevich on 5/30/17.
 */

public interface MenuDelegate extends NavigationView.OnNavigationItemSelectedListener {
    void onInit(Activity activity, Toolbar toolbar, DrawerLayout drawer, NavigationView navigationView, Navigator navigator);

    boolean onBackPressed();
}

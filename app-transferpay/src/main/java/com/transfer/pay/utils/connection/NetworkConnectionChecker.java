package com.transfer.pay.utils.connection;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * @author Created by e.fetskovich on 5/20/17.
 */

public class NetworkConnectionChecker implements ConnectionChecker {

    private Context context;

    public NetworkConnectionChecker(Context context) {
        this.context = context;
    }

    @Override
    public boolean check() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }

}

package com.transfer.pay;

import android.app.Application;

import com.transfer.pay.data.DataStorage;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class TransferPayApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initDependencies();
    }

    private void initDependencies() {
        DataStorage.init(this);
    }
}

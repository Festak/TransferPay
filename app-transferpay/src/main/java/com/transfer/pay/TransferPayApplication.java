package com.transfer.pay;

import android.app.Application;

import com.transfer.pay.data.DataStorage;
import com.transfer.pay.ormlite.ORMLiteFactcory;

public class TransferPayApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ORMLiteFactcory.setHelper(getApplicationContext());
        initDependencies();
    }

    @Override
    public void onTerminate() {
        ORMLiteFactcory.releaseHelper();
        super.onTerminate();
    }

    private void initDependencies() {
        DataStorage.init(this);
    }
}

package com.transfer.pay.utils.thread;

import android.os.Handler;
import android.os.HandlerThread;

/**
 * Created by e.fetskovich on 4/21/17.
 */

public class HandlerThreadExecutor extends HandlerThread {
    private Handler workerHandler;

    public HandlerThreadExecutor(String name) {
        super(name);
    }

    public void postTask(Runnable task) {
        workerHandler.post(task);
    }

    public void prepareHandler() {
        workerHandler = new Handler(getLooper());
    }

}

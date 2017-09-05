package com.transfer.pay.ui;

import android.os.Handler;

import com.istatkevich.cmvp.core.presenter.Presenter;
import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.istatkevich.cmvp.core.viewmodel.ViewModel;
import com.transfer.pay.TransferPayRouter;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class TransferPayBasePresenter<VD extends ViewModel, VH extends ViewHelper<? extends Presenter, ?>>
        extends Presenter<VD, VH> {
    public static final long POST_DELAY_MS = 2000;

    private boolean isFakeAsyncOperationRunning;

    public TransferPayRouter getRemittanceRouter() {
        return getRouter(TransferPayRouter.class);
    }

    public void performFakeAsyncOperation(final Runnable runnable) {
        performFakeAsyncOperation(runnable, POST_DELAY_MS);
    }

    public void performFakeAsyncOperation(final Runnable runnable, long delay) {
        getViewHelper().showProgress();
        isFakeAsyncOperationRunning = true;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runnable.run();
                getViewHelper().hideProgress();
                isFakeAsyncOperationRunning = false;
            }
        }, delay);
    }

    public boolean isFakeAsyncOperationRunning() {
        return isFakeAsyncOperationRunning;
    }
}

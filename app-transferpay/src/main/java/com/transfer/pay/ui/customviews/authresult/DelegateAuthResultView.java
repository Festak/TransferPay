package com.transfer.pay.ui.customviews.authresult;

import android.view.View;
import android.view.ViewGroup;

import com.istatkevich.cmvp.core.HideKeyboard;
import com.istatkevich.cmvp.core.progressoverlay.Progress;
/**
 * @author Created by i.statkevich on 5/16/17.
 */

public class DelegateAuthResultView implements AuthResultView {
    private AuthResultLayout authResultLayoutLayout;
    private ViewGroup rootView;
    private Progress progress;
    private HideKeyboard hideKeyboard;

    public DelegateAuthResultView(ViewGroup rootView, Progress progress, HideKeyboard hideKeyboard) {
        this.rootView = rootView;
        this.progress = progress;
        this.hideKeyboard = hideKeyboard;
    }

    @Override
    public void showAuthResult() {
        if (showAuthResultLayout()) {
            authResultLayoutLayout.switchToWaitingState();
        }
    }

    @Override
    public void switchState(AuthStatus authStatus) {
        if (showAuthResultLayout()) {
            authResultLayoutLayout.switchState(authStatus);
        }
    }

    private boolean showAuthResultLayout() {
        if (authResultLayoutLayout == null) {
            addAuthResultLayout();
        }

        hideKeyboard.hideKeyboard();
        progress.hideProgress();

        if (authResultLayoutLayout == null) {
            return false;
        }

        authResultLayoutLayout.bringToFront();
        authResultLayoutLayout.setVisibility(View.VISIBLE);

        return true;
    }

    private void addAuthResultLayout() {
        if (rootView != null) {
            authResultLayoutLayout = new AuthResultLayout(rootView.getContext());
            authResultLayoutLayout.setVisibility(View.GONE);

            rootView.addView(authResultLayoutLayout);
        }
    }
}

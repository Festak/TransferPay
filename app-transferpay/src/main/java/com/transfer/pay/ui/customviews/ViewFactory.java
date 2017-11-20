package com.transfer.pay.ui.customviews;

import android.view.ViewGroup;

import com.istatkevich.cmvp.core.container.ActivityContainer;
import com.transfer.pay.ui.customviews.authresult.AuthResultView;
import com.transfer.pay.ui.customviews.authresult.DelegateAuthResultView;

public class ViewFactory {
    private ViewFactory() {
        // do nothing
    }

    public static AuthResultView createAuthResultView(ActivityContainer activityContainer) {
        ViewGroup rootView = (ViewGroup) activityContainer.findViewById(android.R.id.content);
        return new DelegateAuthResultView(
                rootView,
                activityContainer,
                activityContainer
        );
    }
}

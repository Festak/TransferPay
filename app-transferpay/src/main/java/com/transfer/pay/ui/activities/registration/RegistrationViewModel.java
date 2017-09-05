package com.transfer.pay.ui.activities.registration;

import com.istatkevich.cmvp.core.viewmodel.ViewModel;
import com.transfer.pay.ui.customviews.AdaptiveButtonLayout;

/**
 * @author e.fetskovich on 6/30/17.
 */

public class RegistrationViewModel extends ViewModel {

    private static final String BUNDLE_ADAPTIVE_BUTTON = "bundle_adaptive_button";

    private AdaptiveButtonLayout adaptiveButtonLayout;

    public void setAdaptiveButtonLayout(AdaptiveButtonLayout adaptiveButtonLayout) {
        this.adaptiveButtonLayout = adaptiveButtonLayout;
    }

    public void putAdaptiveButtonType(int type) {
        putExtraInteger(BUNDLE_ADAPTIVE_BUTTON, type);
        adaptiveButtonLayout.setType(type);
    }

    public int getAdaptiveButtonType() {
        return getExtraInteger(BUNDLE_ADAPTIVE_BUTTON);
    }

}

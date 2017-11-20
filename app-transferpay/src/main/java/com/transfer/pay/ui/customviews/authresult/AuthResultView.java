package com.transfer.pay.ui.customviews.authresult;

/**
 * @author Created by i.statkevich on 5/16/17.
 */

public interface AuthResultView {
    void showAuthResult();

    void switchState(AuthStatus authStatus);
}

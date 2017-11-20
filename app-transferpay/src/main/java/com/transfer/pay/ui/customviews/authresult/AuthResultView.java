package com.transfer.pay.ui.customviews.authresult;


public interface AuthResultView {
    void showAuthResult();

    void switchState(AuthStatus authStatus);
}

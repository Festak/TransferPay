package com.transfer.pay;

import android.content.Context;

import com.istatkevich.cmvp.core.router.Router;
import com.transfer.pay.ui.activities.home.HomeActivity;
import com.transfer.pay.ui.activities.login.LoginActivity;
import com.transfer.pay.ui.activities.registration.RegistrationActivity;
import com.transfer.pay.ui.activities.twofactorauth.TwoFactorAuthActivity;
import com.transfer.pay.ui.fragments.RegistrationFragmentFactory;
import com.transfer.pay.utils.fragment.params.SpaFragmentBundleFactory;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class TransferPayRouter extends Router {
    public TransferPayRouter(Context context) {
        super(context);
    }

    public void openHomeActivity() {
        openActivity(HomeActivity.class, null, -1, true, true, -1);
    }

    public void openLoginActivity() {
        openActivity(LoginActivity.class, null, -1, true, true, -1);
    }

    public void openRegistrationActivity() {
        openActivity(RegistrationActivity.class,
                SpaFragmentBundleFactory.createBundle(RegistrationFragmentFactory.REGISTRATION_STEP_ONE, null)
        );
    }

    public void openTwoFactorAuthActivity() {
        openActivity(TwoFactorAuthActivity.class, null, -1, true, true, -1);
    }

}

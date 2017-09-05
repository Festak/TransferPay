package com.transfer.pay.ui.activities.registration;

import android.view.View;
import android.view.WindowManager;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.RegistrationBaseBinding;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationViewHelper extends ViewHelper<RegistrationPresenter, RegistrationBaseBinding> {

    @Override
    protected void onInitView() {
        setActionBarText(R.string.registration_aml_new_user);
    }

    @Override
    protected void onBindVariables(RegistrationBaseBinding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.registration_base;
    }

    public void setActionBarText(int stringId) {
        getActivityContainer().setTitle(
                getActivityContainer().getString(stringId)
        );
    }

    public void hideActionAndStatusBar() {
        getActivityContainer().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        findViewById(R.id.toolbar_layout).setVisibility(View.GONE);
    }

    public void changeSecondButtonText(int stringId) {
        getBinding().adaptiveButton.setSecondButtonText(stringId);
    }

}

package com.transfer.pay.ui.fragments.registration.twofactorauth;

import android.widget.EditText;
import android.widget.Toast;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.RegistrationAmlTwoFactorBinding;
import com.transfer.pay.ui.activities.registration.RegistrationPresenter;
import com.transfer.pay.ui.activities.registration.RegistrationViewHelper;

/**
 * Created by e.fetskovich on 6/21/17.
 */

public class TwoFactorAuthViewHelper extends ViewHelper<TwoFactorAuthPresenter, RegistrationAmlTwoFactorBinding> {


    @Override
    protected void onInitView() {
        super.onInitView();
        RegistrationPresenter presenter = getRegistrationPresenter();
        RegistrationViewHelper helper = presenter.getViewHelper();
        helper.setActionBarText(R.string.registration_aml_two_factor_auth);
    }

    @Override
    protected void onBindVariables(RegistrationAmlTwoFactorBinding binding) {
        binding.setPresenter(getPresenter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.registration_aml_two_factor;
    }

    public RegistrationPresenter getRegistrationPresenter() {
        return (RegistrationPresenter) getActivityContainer().getPresenter(ContainerId.Activity.REGISTRATION, RegistrationPresenter.class);
    }

    public RegistrationViewHelper getRegistrationViewHelper(){
        return getRegistrationPresenter().getViewHelper();
    }

    public void showToast(int stringId){
        showToast(stringId, Toast.LENGTH_SHORT);
    }

    public String getTwoFactorEnteredNumber(){
        EditText editText = (EditText)findViewById(R.id.two_factor_auth_sms_text);
        return editText.getText().toString();
    }

}

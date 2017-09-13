package com.transfer.pay.ui.fragments.changepassword;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.ChangePasswordBinding;
import com.transfer.pay.utils.validation.ValidationFactory;

/**
 * @author e.fetskovich on 9/13/17.
 */

public class ChangePasswordViewHelper extends ViewHelper<ChangePasswordPresenter, ChangePasswordBinding> {

    @Override
    protected void onBindVariables(ChangePasswordBinding binding) {
        getPresenter().onBindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.change_password;
    }

    public boolean comparePasswords() {
        ChangePasswordBinding binding = getBinding();
        return binding.password.getText().toString().equals(binding.passwordConfirm.getText().toString());
    }

    public boolean validateUserLogin() {
        return ValidationFactory.getEmptyRuleValidation().validate(getUserPassword());
    }

    public String getUserPassword() {
        return getBinding().password.getText().toString();
    }

}

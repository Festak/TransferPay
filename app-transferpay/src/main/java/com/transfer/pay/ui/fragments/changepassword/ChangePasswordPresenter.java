package com.transfer.pay.ui.fragments.changepassword;

import android.widget.Toast;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.R;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.ChangePasswordBinding;
import com.transfer.pay.ui.TransferPayBasePresenter;

/**
 * @author e.fetskovich on 9/13/17.
 */

public class ChangePasswordPresenter extends TransferPayBasePresenter<EmptyViewModel, ChangePasswordViewHelper> {

    public void onBindVariables(ChangePasswordBinding binding) {
        binding.setPresenter(this);
    }

    public void onChangePasswordClick() {
        ChangePasswordViewHelper viewHelper = getViewHelper();
        if (viewHelper.validateUserLogin()) {
            changeUserPassword(viewHelper);
        } else {
            viewHelper.showToast(R.string.change_password_empty, Toast.LENGTH_SHORT);
        }

    }

    private void changeUserPassword(ChangePasswordViewHelper viewHelper) {
        if (viewHelper.comparePasswords()) {
            viewHelper.showToast(R.string.change_password_successfuly, Toast.LENGTH_SHORT);
            UserManager.getInstance().changeUserPassword(viewHelper.getUserPassword());
            getScreen().closeScreen();
        } else {
            viewHelper.showToast(R.string.change_password_wrong, Toast.LENGTH_SHORT);
        }
    }

}

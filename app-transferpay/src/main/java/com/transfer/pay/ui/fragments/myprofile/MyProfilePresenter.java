package com.transfer.pay.ui.fragments.myprofile;

import android.graphics.Bitmap;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.MyProfileBinding;
import com.transfer.pay.models.User;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;
import com.transfer.pay.utils.FileUtils;


public class MyProfilePresenter extends TransferPayBasePresenter<EmptyViewModel, MyProfileViewHelper> {

    public void bindVariables(MyProfileBinding binding) {
        binding.setPresenter(this);
        User user = UserManager.getInstance().getUser();
        binding.setUser(user);
        bindIdOfScan(binding, user);
    }

    private void bindIdOfScan(MyProfileBinding binding, User user) {
        if (user.getIdOfScan() != null) {

            Bitmap bitmap = FileUtils.loadBitmapFromFile(FileUtils.SCAN_PATH, user.getIdOfScan(), 700);
            if (bitmap != null) {
                binding.myIdOfScan.setImageBitmap(bitmap);
            }

        }
    }

    public void onChangePasswordClick() {
        getViewHelper().changeFragment(TransferPayFragmentFactory.ID_CHANGEPASS);
    }

}

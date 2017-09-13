package com.transfer.pay.ui.fragments.myprofile;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.MyProfileBinding;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.ui.fragments.TransferPayFragmentFactory;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class MyProfilePresenter extends TransferPayBasePresenter<EmptyViewModel, MyProfileViewHelper> {

    public void bindVariables(MyProfileBinding binding) {
        binding.setPresenter(this);
        binding.setUser(UserManager.getInstance().getUser());
    }

    public void onChangePasswordClick(){
        getViewHelper().changeFragment(TransferPayFragmentFactory.ID_CHANGEPASS);
    }

}

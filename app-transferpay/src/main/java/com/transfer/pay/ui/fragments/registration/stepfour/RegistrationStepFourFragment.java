package com.transfer.pay.ui.fragments.registration.stepfour;

import android.content.Intent;
import android.graphics.Bitmap;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.Constants;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;
import com.transfer.pay.utils.ImagePicker;


/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepFourFragment extends TransferPayBaseFragment<EmptyViewModel, RegistrationStepFourViewHelper, RegistrationStepFourPresenter> {

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == Constants.PICK_IMAGE_ID) {
                Bitmap bitmap = ImagePicker.getImageFromResult(getContext(), resultCode, data);
                if (bitmap != null) {
                    getPresenter().onImagePickedResult(bitmap);
                }
            }
        }
    }

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected RegistrationStepFourPresenter createPresenter() {
        return new RegistrationStepFourPresenter();
    }

    @Override
    protected RegistrationStepFourViewHelper createViewHelper() {
        return new RegistrationStepFourViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.Registration.STEP_FOUR;
    }


}

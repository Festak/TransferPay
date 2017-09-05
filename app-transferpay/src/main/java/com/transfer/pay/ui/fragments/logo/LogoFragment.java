package com.transfer.pay.ui.fragments.logo;

import android.content.Intent;
import android.graphics.Bitmap;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.constants.Constants;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.ui.TransferPayBaseFragment;
import com.transfer.pay.utils.ImagePicker;
/**
 * Created by e.fetskovich on 6/16/17.
 */

public class LogoFragment extends TransferPayBaseFragment<EmptyViewModel, LogoViewHelper, LogoPresenter> {

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == Constants.PICK_IMAGE_ID) {
                Bitmap bitmap = ImagePicker.getImageFromResult(getContext(), resultCode, data);
                if (bitmap != null) {
                    getPresenter().saveBitmapToFileAndUpdateLogos(bitmap);
                }
            }
        }
    }

    @Override
    protected EmptyViewModel createViewData() {
        return new EmptyViewModel();
    }

    @Override
    protected LogoPresenter createPresenter() {
        return new LogoPresenter();
    }

    @Override
    protected LogoViewHelper createViewHelper() {
        return new LogoViewHelper();
    }

    @Override
    public String getContainerId() {
        return ContainerId.Fragment.LOGO;
    }


}

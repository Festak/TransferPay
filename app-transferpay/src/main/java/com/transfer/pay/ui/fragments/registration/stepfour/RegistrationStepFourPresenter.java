package com.transfer.pay.ui.fragments.registration.stepfour;

import android.Manifest;
import android.graphics.Bitmap;

import com.istatkevich.cmvp.core.viewmodel.EmptyViewModel;
import com.transfer.pay.UserManager;
import com.transfer.pay.databinding.RegistrationAmlStep3Binding;
import com.transfer.pay.databinding.RegistrationAmlStep4Binding;
import com.transfer.pay.ui.TransferPayBasePresenter;
import com.transfer.pay.utils.FileNameGenerator;
import com.transfer.pay.utils.FileUtils;
import com.transfer.pay.utils.validation.registration.RegistrationValidationManager;
import com.transfer.pay.utils.validation.registration.RegistrationValidationModel;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepFourPresenter extends TransferPayBasePresenter<EmptyViewModel, RegistrationStepFourViewHelper> {

    public void bindVariables(RegistrationAmlStep4Binding binding) {
        binding.setUser(UserManager.getInstance().getUser());
        binding.setPresenter(this);
        bindValidationModel(binding);
    }

    private void bindValidationModel(RegistrationAmlStep4Binding binding){
        RegistrationValidationManager.getValidationModel().currentStep.set(3);
        RegistrationValidationModel model = RegistrationValidationManager.getValidationModel();
        binding.setValidationModel(model);
    }

    @Override
    public String[] getRequiredPermissions() {
        return new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE
        };
    }

    @Override
    public void onPermissionDenied(String[] permissionsAllowed, String[] permissionsDenied, String[] permissionsDontAskAgain) {
        super.onPermissionDenied(permissionsAllowed, permissionsDenied, permissionsDontAskAgain);
        getScreen().closeScreen();
    }

    public void onIdScanClick() {
        getViewHelper().pickImage();
    }

    public void onImagePickedResult(Bitmap photo){
        String fileName = generateFileName();
        FileUtils.writeBitmapToFile(FileUtils.SCAN_PATH, fileName, photo);
        setIdOfScanForUser(fileName);
    }

    private String generateFileName() {
        return FileNameGenerator.generateImageFileName("scan_");
    }

    private void setIdOfScanForUser(String fileName) {
        getViewHelper().getBinding().getUser().idOfScan.set(fileName);
    }
}

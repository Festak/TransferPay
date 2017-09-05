package com.transfer.pay.ui.fragments.registration.stepfour;

import android.content.Intent;
import android.view.View;
import android.widget.Spinner;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.constants.Constants;
import com.transfer.pay.constants.ContainerId;
import com.transfer.pay.databinding.RegistrationAmlStep4Binding;
import com.transfer.pay.listeners.calendar.CalendarListener;
import com.transfer.pay.listeners.calendar.DateListener;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.activities.registration.RegistrationPresenter;
import com.transfer.pay.utils.ImagePicker;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepFourViewHelper extends ViewHelper<RegistrationStepFourPresenter, RegistrationAmlStep4Binding> {

    @Override
    protected void onInitView() {
        initExpiryDateListener();
        initSpinnerAdapter();
        changeActionBarText(R.string.registration_aml_new_user);
    }

    @Override
    protected void onBindVariables(RegistrationAmlStep4Binding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.registration_aml_step4;
    }


    public void startIntent(Intent intent, int requestCode) {
        RegistrationStepFourFragment fragment = (RegistrationStepFourFragment) getActivityContainer()
                .getSupportFragmentManager()
                .findFragmentByTag(ContainerId.Fragment.Registration.STEP_FOUR);
        fragment.startActivityForResult(intent, requestCode);
    }

    public void pickImage(){
        Intent chooseImageIntent = ImagePicker.getPickImageIntent(getRoot().getContext());
        startIntent(chooseImageIntent, Constants.PICK_IMAGE_ID);
    }

    private void initExpiryDateListener() {
        View view = getBinding().expiryDate;
        view.setOnFocusChangeListener(new DateListener(new CalendarListener(view)));
    }

    private void initSpinnerAdapter() {
        Spinner spinner = getBinding().spinnerIdentificationType;
        UiConfigurator.initSpinnerAdapterWithResourceData(spinner, R.array.identification_types);
    }

    private void changeActionBarText(int stringId) {
        RegistrationPresenter presenter = (RegistrationPresenter) getActivityContainer().getPresenter(ContainerId.Activity.REGISTRATION, RegistrationPresenter.class);
        presenter.getViewHelper().setActionBarText(stringId);
    }

}

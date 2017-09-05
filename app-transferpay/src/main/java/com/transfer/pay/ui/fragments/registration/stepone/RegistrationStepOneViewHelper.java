package com.transfer.pay.ui.fragments.registration.stepone;

import android.widget.Spinner;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.RegistrationAmlStep1Binding;
import com.transfer.pay.ui.UiConfigurator;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepOneViewHelper extends ViewHelper<RegistrationStepOnePresenter, RegistrationAmlStep1Binding> {

    @Override
    protected void onInitView() {
        initSpinnerAdapter();
    }

    @Override
    protected void onBindVariables(RegistrationAmlStep1Binding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.registration_aml_step1;
    }

    private void initSpinnerAdapter() {
        Spinner spinner = getBinding().spinnerCountry;
        UiConfigurator.initSpinnerAdapterWithResourceData(spinner, R.array.countries);
    }


}

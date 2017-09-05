package com.transfer.pay.ui.fragments.registration.steptwo;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.RegistrationAmlStep2Binding;
import com.transfer.pay.listeners.calendar.CalendarBirthDayListener;
import com.transfer.pay.listeners.calendar.DateListener;
import com.transfer.pay.ui.UiConfigurator;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationStepTwoViewHelper extends ViewHelper<RegistrationStepTwoPresenter, RegistrationAmlStep2Binding> {

    @Override
    protected void onInitView() {
        initDateOfBirthListener();
        initSpinnerAdapter();
        initCheckedRadioButtonListener();
    }

    @Override
    protected void onBindVariables(RegistrationAmlStep2Binding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.registration_aml_step2;
    }

    private void initDateOfBirthListener() {
        View view = getBinding().userDateOfBirth;
        view.setOnFocusChangeListener(new DateListener(new CalendarBirthDayListener(view)));
    }

    private void initSpinnerAdapter() {
        Spinner spinner = getBinding().spinnerNationality;
        UiConfigurator.initSpinnerAdapterWithResourceData(spinner, R.array.nationalities);
    }

    private void initCheckedRadioButtonListener() {
        getBinding().sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton button = (RadioButton) radioGroup.findViewById(i);
                if (button.isChecked()) {
                    getBinding().getUser().sex.set(button.getText().toString());
                }
            }
        });
    }

}

package com.transfer.pay.utils.validation.adapters;

import android.databinding.BindingAdapter;
import android.widget.EditText;

import com.transfer.pay.utils.validation.Validator;
import com.transfer.pay.utils.validation.registration.RegistrationValidationModel;
import com.transfer.pay.utils.validation.watchers.ErrorRepresenterTextWatcher;

/**
 * @author e.fetskovich on 9/12/17.
 */

public class TextBindingAdapter {

    private TextBindingAdapter(){
        // do nothing
    }

    @BindingAdapter({"app:validator", "app:validationModel"})
    public static void editTextValidation(final EditText editText, final Validator validator, final RegistrationValidationModel validationModel) {
        editText.addTextChangedListener(new ErrorRepresenterTextWatcher(editText, validationModel, validator));
    }

}

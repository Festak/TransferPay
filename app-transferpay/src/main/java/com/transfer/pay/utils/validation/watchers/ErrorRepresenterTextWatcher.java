package com.transfer.pay.utils.validation.watchers;

import android.databinding.ObservableArrayMap;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.transfer.pay.utils.validation.Validator;
import com.transfer.pay.utils.validation.registration.RegistrationValidationModel;

/**
 * Created by e.fetskovich on 5/30/17.
 */

public class ErrorRepresenterTextWatcher implements TextWatcher {

    private String viewId;
    private EditText editText;
    private final ObservableArrayMap<String, String> map;
    private Validator validator;

    public ErrorRepresenterTextWatcher(EditText editText, RegistrationValidationModel validationModel, Validator validator) {
        this.editText = editText;
        this.map = validationModel.getCurrentValidationMap();
        this.validator = validator;
        this.viewId = String.valueOf(editText.getId());
        afterTextChanged(editText.getText());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // do nothing
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // do nothing
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (validator.validate(s)) {
            map.remove(viewId);
        } else {
            map.put(viewId, viewId);
        }
    }
}

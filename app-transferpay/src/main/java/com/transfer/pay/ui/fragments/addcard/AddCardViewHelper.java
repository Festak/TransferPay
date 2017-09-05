package com.transfer.pay.ui.fragments.addcard;

import android.view.View;
import android.widget.Spinner;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.AddCardBinding;
import com.transfer.pay.listeners.calendar.CalendarListener;
import com.transfer.pay.listeners.calendar.DateListener;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.watchers.CreditCardWatcher;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class AddCardViewHelper extends ViewHelper<AddCardPresenter, AddCardBinding> {

    @Override
    protected void onInitView() {
        initEditText();
        initDatePickerForEditText();
        initSpinnerAdapter();
    }

    @Override
    protected void onBindVariables(AddCardBinding binding) {
        getPresenter().bindVariables(binding);
    }

    private void initEditText() {
        AddCardBinding binding = getBinding();
        binding.creditCardLayout.fieldCvvInput.setTransformationMethod(null);
        binding.creditCardLayout.fieldCardNumber.addTextChangedListener(new CreditCardWatcher());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.add_card;
    }

    private void initDatePickerForEditText() {
        View view = getBinding().creditCardLayout.fieldValidThru;
        view.setOnFocusChangeListener(new DateListener(new CalendarListener(view)));
    }

    private void initSpinnerAdapter() {
        Spinner spinner = getBinding().creditCardLayout.spinnerCardType;
        UiConfigurator.initSpinnerAdapterWithResourceData(spinner, R.array.card_types);
    }

}

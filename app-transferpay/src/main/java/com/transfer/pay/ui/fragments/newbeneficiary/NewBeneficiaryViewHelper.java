package com.transfer.pay.ui.fragments.newbeneficiary;

import android.view.View;
import android.widget.Spinner;

import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.NewBeneficiaryBinding;
import com.transfer.pay.factories.TooltipFactory;
import com.transfer.pay.listeners.calendar.CalendarListener;
import com.transfer.pay.listeners.calendar.DateListener;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.customviews.Tooltip;
import com.transfer.pay.ui.watchers.CreditCardWatcher;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class NewBeneficiaryViewHelper extends ViewHelper<NewBeneficiaryPresenter, NewBeneficiaryBinding> {

    private Tooltip tooltip;

    @Override
    protected void onInitView() {
        initEditText();
        initDatePickerForEditText();
        initSpinnerAdapter();
        initTooltip();
    }

    @Override
    protected void onBindVariables(NewBeneficiaryBinding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.new_beneficiary;
    }

    public void showTooltip(View view){
        tooltip.show(view);
    }

    private void initEditText() {
        NewBeneficiaryBinding binding = getBinding();
        binding.creditCardIncludeLayout.fieldCvvInput.setTransformationMethod(null);
        binding.creditCardIncludeLayout.fieldCardNumber.addTextChangedListener(new CreditCardWatcher());
    }

    private void initDatePickerForEditText() {
        View view = getBinding().creditCardIncludeLayout.fieldValidThru;
        view.setOnFocusChangeListener(new DateListener(new CalendarListener(view)));
    }

    private void initSpinnerAdapter() {
        Spinner spinner = getBinding().creditCardIncludeLayout.spinnerCardType;
        UiConfigurator.initSpinnerAdapterWithResourceData(spinner, R.array.card_types);
    }

    private void initTooltip(){
        View showTooltip = getBinding().showTooltip;
        tooltip = TooltipFactory.create(showTooltip, R.string.beneficiary_or_card);
    }


}

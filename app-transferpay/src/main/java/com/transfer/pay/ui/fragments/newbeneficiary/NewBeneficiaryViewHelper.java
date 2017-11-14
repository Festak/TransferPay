package com.transfer.pay.ui.fragments.newbeneficiary;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.cooltechworks.creditcarddesign.CreditCardUtils;
import com.istatkevich.cmvp.core.viewhelper.ViewHelper;
import com.transfer.pay.R;
import com.transfer.pay.databinding.NewBeneficiaryBinding;
import com.transfer.pay.factories.TooltipFactory;
import com.transfer.pay.ui.UiConfigurator;
import com.transfer.pay.ui.customviews.Tooltip;
import com.transfer.pay.ui.watchers.CreditCardWatcher;

import java.util.Calendar;

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
        configureSpinners();
    }

    @Override
    protected void onBindVariables(NewBeneficiaryBinding binding) {
        getPresenter().bindVariables(binding);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.new_beneficiary;
    }

    public void showTooltip(View view) {
        tooltip.show(view);
    }

    private void initEditText() {
        NewBeneficiaryBinding binding = getBinding();
        binding.creditCardIncludeLayout.fieldCvvInput.setTransformationMethod(null);
        binding.creditCardIncludeLayout.fieldCardNumber.addTextChangedListener(new CreditCardWatcher());
    }

    private void initDatePickerForEditText() {
        final EditText view = getBinding().creditCardIncludeLayout.fieldValidThru;
        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString().replace(CreditCardUtils.SLASH_SEPERATOR, "");

                String month, year="";
                if(text.length() >= 2) {
                    month = text.substring(0, 2);

                    if(text.length() > 2) {
                        year = text.substring(2);
                    }

                        int mm = Integer.parseInt(month);

                        if (mm <= 0 || mm >= 13) {
                            view.setError(getRoot().getContext().getString(com.cooltechworks.creditcarddesign.R.string.error_invalid_month));
                            return;
                        }

                        if (text.length() >= 4) {

                            int yy = Integer.parseInt(year);

                            final Calendar calendar = Calendar.getInstance();
                            int currentYear = calendar.get(Calendar.YEAR);
                            int currentMonth = calendar.get(Calendar.MONTH) + 1;

                            int millenium = (currentYear / 1000) * 1000;


                            if (yy + millenium < currentYear) {
                                view.setError(getRoot().getContext().getString(com.cooltechworks.creditcarddesign.R.string.error_card_expired));
                                return;
                            } else if (yy + millenium == currentYear && mm < currentMonth) {
                                view.setError(getRoot().getContext().getString(com.cooltechworks.creditcarddesign.R.string.error_card_expired));
                                return;
                            }
                        }

                }
                else {
                    month = text;
                }

                int previousLength = view.getText().length();
                int cursorPosition = view.getSelectionEnd();

                text = CreditCardUtils.handleExpiration(month,year);

                view.removeTextChangedListener(this);
                view.setText(text);
                view.setSelection(text.length());
                view.addTextChangedListener(this);

                int modifiedLength = text.length();

                if(modifiedLength <= previousLength && cursorPosition < modifiedLength) {
                    view.setSelection(cursorPosition);
                }

            }
        });
       // view.setOnFocusChangeListener(new DateListener(new CalendarListener(view)));
    }

    private void initSpinnerAdapter() {
        Spinner spinner = getBinding().creditCardIncludeLayout.spinnerCardType;
        UiConfigurator.initSpinnerAdapterWithResourceData(spinner, R.array.card_types);
    }

    private void initTooltip() {
        View showTooltip = getBinding().showTooltip;
        tooltip = TooltipFactory.create(showTooltip, R.string.beneficiary_or_card);
    }

    private void configureSpinners() {
        UiConfigurator.initSpinnerAdapterWithResourceData(getBinding().spinnerDefaultCountry, R.array.countries);
    }


}

package com.transfer.pay.listeners.calendar;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.transfer.pay.utils.DateUtils;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class CalendarListener implements DatePickerDialog.OnDateSetListener {

    private View view;

    public CalendarListener(View view) {
        this.view = view;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String dateOfBirth = DateUtils.getDateOfBirth(year, month + 1, dayOfMonth);
        ((TextView) view).setText(dateOfBirth);
    }
}

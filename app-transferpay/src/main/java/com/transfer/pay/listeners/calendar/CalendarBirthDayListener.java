package com.transfer.pay.listeners.calendar;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.transfer.pay.utils.DateUtils;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class CalendarBirthDayListener implements DatePickerDialog.OnDateSetListener {

    private View view;

    public CalendarBirthDayListener(View view) {
        this.view = view;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        if (DateUtils.compareCurrentAndSelectedDate(year, month, dayOfMonth)) {
            String dateOfBirth = DateUtils.getDateOfBirth(year, month + 1, dayOfMonth);
            ((TextView) view).setText(dateOfBirth);
        } else {
            Toast.makeText(view.getContext(), "Please, pick correct date", Toast.LENGTH_SHORT).show();
        }
    }
}

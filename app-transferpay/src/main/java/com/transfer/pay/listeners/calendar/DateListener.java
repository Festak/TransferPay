package com.transfer.pay.listeners.calendar;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class DateListener implements View.OnFocusChangeListener {

    private int currentYear;
    private int currentMonth;
    private int currentDayOfMonth;
    private DatePickerDialog.OnDateSetListener listener;

    public DateListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    @Override
    public void onFocusChange(final View view, boolean hasFocus) {
        if (hasFocus) {
            String date = String.valueOf(((EditText) view).getText());
            setCalendarDay(date);

            new DatePickerDialog(
                    view.getContext(),
                    listener,
                    currentYear,
                    currentMonth,
                    currentDayOfMonth
            ).show();
        }
        view.clearFocus();
    }

    private void setCalendarDay(String date) {
        if (date == null || date.equals("")) {
            setCurrentDay();
        } else {
            setLastEditedDay(date);
        }
    }

    private void setCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = calendar.get(Calendar.MONTH);
        currentDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    }

    private void setLastEditedDay(String date) {
        String[] dateParts = date.split("-");
        currentMonth = Integer.parseInt(dateParts[0]) - 1;
        currentDayOfMonth = Integer.parseInt(dateParts[1]);
        currentYear = Integer.parseInt(dateParts[2]);
    }

}

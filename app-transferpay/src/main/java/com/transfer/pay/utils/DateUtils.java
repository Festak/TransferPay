package com.transfer.pay.utils;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Created by e.fetskovich on 5/20/17.
 */

public class DateUtils {

    private DateUtils() {
        // do nothing
    }

    public static String millisToDate(long millis) {
        return DateFormat.format("MM-dd-yyyy", new Date(millis)).toString();
    }

    public static long getTimeInMillis(String date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            try {
                Date mDate = sdf.parse(date);
                return mDate.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static boolean compareCurrentAndSelectedDate(int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);

        long time = calendar.getTimeInMillis();
        long currentTime = new Date().getTime();

        return time < currentTime;
    }

    public static String getDateOfBirth(int year, int month, int dayOfMonth) {
        String yearStr = String.valueOf(year);
        String monthStr = (month >= 10) ? String.valueOf(month) : "0" + month;
        String dayOfMonthStr = (dayOfMonth >= 10) ? String.valueOf(dayOfMonth) : "0" + dayOfMonth;
        return monthStr + "-" + dayOfMonthStr + "-" + yearStr;
    }



}

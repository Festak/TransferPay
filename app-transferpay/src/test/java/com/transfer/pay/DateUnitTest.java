package com.transfer.pay;

import com.transfer.pay.utils.DateUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author e.fetskovich on 1/31/18.
 */

public class DateUnitTest {

    @Test
    public void dateComparing() {
        boolean prevDate = DateUtils.compareCurrentAndSelectedDate(1996, 12, 14);
        assertEquals(prevDate, true);

        boolean nextDate = DateUtils.compareCurrentAndSelectedDate(2996, 12, 14);
        assertEquals(nextDate, false);
    }

    @Test
    public void dateInNiceFormat(){
        int month = 11;
        int year = 2009;
        int day = 13;

        String normalFormat = String.valueOf(month).concat("-").concat(String.valueOf(day)).concat("-").concat(String.valueOf(year));

        assertEquals(normalFormat, DateUtils.getDateOfBirth(year, month, day));

    }

}

package com.transfer.pay.ui.binding;

import android.databinding.InverseMethod;
import android.widget.TextView;

/**
 * Created by e.fetskovich on 6/20/17.
 */

public class Converter {

    @InverseMethod("toDouble")
    public static String toString(TextView view,
                                  Double value) {
        try {
            String text = view.getText().toString();
            double parsed = Double.parseDouble(text);
            if (parsed == value) {
                return text;
            }
        } catch (Exception e) {
            // Old number was broken
        }
        return String.valueOf(value);
    }

    public static Double toDouble(TextView view,
                                  String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return 0.0;
        }
    }
}

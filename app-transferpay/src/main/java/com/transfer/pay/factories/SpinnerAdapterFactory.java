package com.transfer.pay.factories;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.transfer.pay.R;
import com.transfer.pay.adapters.BaseSpinnerEnumAdapter;
import com.transfer.pay.adapters.StateSpinnerAdapter;
import com.transfer.pay.iban.CountryCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class SpinnerAdapterFactory {
    private Context context;

    public SpinnerAdapterFactory(Context context) {
        this.context = context;
    }

    public ArrayAdapter createArrayAdapter(List<?> values) {
        ArrayAdapter<?> arrayAdapter = new ArrayAdapter<>(context, R.layout.spinner_item, values);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        return arrayAdapter;
    }

    public BaseSpinnerEnumAdapter createStateSpinnerAdapter() {

        List<String> stringValues = new LinkedList<>();
        Object[] enumValues = CountryCode.values();
        for (int i = 0; i < enumValues.length; i++) {
            String value = ((CountryCode) enumValues[i]).getName();
            stringValues.add(value);
        }

        BaseSpinnerEnumAdapter adapter = new StateSpinnerAdapter(context, R.layout.spinner_item, stringValues, enumValues);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        return adapter;
    }

}

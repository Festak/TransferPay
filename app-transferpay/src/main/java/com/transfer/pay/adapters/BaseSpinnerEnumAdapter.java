package com.transfer.pay.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.transfer.pay.R;

import java.util.List;


public class BaseSpinnerEnumAdapter extends ArrayAdapter {

    protected Object[] enumValues;
    private List<String> strings;

    public BaseSpinnerEnumAdapter(Context context, int resource, List<String> stringValues, Object[] enumValues) {
        super(context, resource, stringValues);
        this.enumValues = enumValues;
        this.strings = stringValues;
    }


    // Need in this method for reInit spinner styles when user Using Multitask Mode
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        return v;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createViewByPosition(parent, position);
    }

    public Object getEnumValue(int position) {
        return enumValues[position];
    }

    public String getStringValue(int position) {
        return strings.get(position);
    }

    public int getEnumPosition(Object object) {
        for (int i = 0; i < enumValues.length; i++) {
            if (enumValues[i] == object) {
                return i;
            }
        }
        return 0;
    }

    protected void makeTextViewStyle(TextView textView, String text) {
        textView.setText(text);
        textView.setTextSize(20);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.colorDark));
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    protected View getDropDownView(ViewGroup parent, int position) {
        return super.getDropDownView(position, null, parent);
    }


    private View createViewByPosition(ViewGroup parent, int position) {
        View view;
        view = getDropDownView(parent, position);
        return view;
    }


}

package com.transfer.pay.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.transfer.pay.R;
import com.transfer.pay.iban.CountryCode;
import com.transfer.pay.utils.SizeUtils;

import java.util.List;


/**
 * Created by e.fetskovich on 6/28/17.
 */

public class StateSpinnerAdapter extends BaseSpinnerEnumAdapter {

    private static final int SPINNER_ITEM_PADDING_TOP_BOTTOM_DP = 16;
    private static final int SPINNER_ITEM_PADDING_LEFT = 8;
    private static final int SPINNER_ITEM_SIZE_SP = 16;

    public StateSpinnerAdapter(Context context, int resource, List<String> stringValues, Object[] enumValues) {
        super(context, resource, stringValues, enumValues);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        setShortValue((TextView) view, position);
        return view;
    }

    @Override
    protected View getDropDownView(ViewGroup parent, int position) {
        View textView = new TextView(parent.getContext());
        setShortAndFullValue((TextView) textView, position);
        return textView;
    }

    private void setShortAndFullValue(TextView textView, int position) {
        String stringValue = getStringValue(position);
        CountryCode code = (CountryCode) getEnumValue(position);
        String dropDownText = code.getAlpha3() + " - " + stringValue;
        customizeTextView(textView, dropDownText);
    }

    private void customizeTextView(TextView textView, String text) {
        textView.setText(text);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.colorDark));
        textView.setTextSize(SPINNER_ITEM_SIZE_SP);

        int paddingTop = (int) SizeUtils.convertDpToPixel(SPINNER_ITEM_PADDING_TOP_BOTTOM_DP);
        int paddingLeft = (int) SizeUtils.convertDpToPixel(SPINNER_ITEM_PADDING_LEFT);
        textView.setPadding(paddingLeft, paddingTop, 0, paddingTop);
    }

    private void setShortValue(TextView textView, int position) {
        CountryCode code = (CountryCode) getEnumValue(position);
        textView.setText(code.getAlpha3());
    }
}

package com.transfer.pay.listeners.spinner;

import android.databinding.InverseBindingListener;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class BindedItemSelectedListener implements AdapterView.OnItemSelectedListener {

    private InverseBindingListener inverseBindingListener;

    public BindedItemSelectedListener(InverseBindingListener inverseBindingListener) {
        this.inverseBindingListener = inverseBindingListener;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        inverseBindingListener.onChange();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

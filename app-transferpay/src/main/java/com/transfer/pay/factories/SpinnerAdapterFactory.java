package com.transfer.pay.factories;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.transfer.pay.R;
import java.util.List;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class SpinnerAdapterFactory {
    private Context context;

    public SpinnerAdapterFactory(Context context){
        this.context = context;
    }

    public ArrayAdapter createArrayAdapter(List<?> values) {
        ArrayAdapter<?> arrayAdapter = new ArrayAdapter<>(context, R.layout.spinner_item, values);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        return arrayAdapter;
    }

}

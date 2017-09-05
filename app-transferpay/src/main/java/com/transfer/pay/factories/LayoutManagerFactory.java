package com.transfer.pay.factories;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by e.fetskovich on 6/21/17.
 */

public class LayoutManagerFactory {

    private LayoutManagerFactory() {
        // do nothing
    }

    public static RecyclerView.LayoutManager createGridLayoutManager(Context context, int columnNumber) {
        return new GridLayoutManager(context, columnNumber);
    }

    public static RecyclerView.LayoutManager createLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

}

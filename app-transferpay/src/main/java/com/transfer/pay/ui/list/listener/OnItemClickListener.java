package com.transfer.pay.ui.list.listener;

import android.view.View;

/**
 * Created by e.fetskovich on 6/7/17.
 */

public class OnItemClickListener implements View.OnClickListener {

    private OnClickedItemListener listener;
    private int position;

    public OnItemClickListener(OnClickedItemListener listener, int position) {
        this.listener = listener;
        this.position = position;
    }

    @Override
    public void onClick(View view) {
        listener.onClickedItem(position);
    }
}

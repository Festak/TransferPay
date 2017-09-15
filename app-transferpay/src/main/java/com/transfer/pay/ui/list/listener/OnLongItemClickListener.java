package com.transfer.pay.ui.list.listener;

import android.view.View;

/**
 * @author e.fetskovich on 9/14/17.
 */

public class OnLongItemClickListener implements View.OnClickListener {

    private OnClickedItemListener listener;
    private int position;

    public OnLongItemClickListener(OnClickedItemListener listener, int position) {
        this.listener = listener;
        this.position = position;
    }

    @Override
    public void onClick(View v) {
        listener.onClickedItem(position);
    }
}

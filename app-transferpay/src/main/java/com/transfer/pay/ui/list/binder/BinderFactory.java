package com.transfer.pay.ui.list.binder;

import com.transfer.pay.ui.list.ListItemType;

/**
 * Created by i.statkevich on 6/2/17.
 */

public interface BinderFactory {
    ViewHolderBinder create(ListItemType type);
}

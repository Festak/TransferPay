package com.transfer.pay.ui.list.binder;

import com.transfer.pay.ui.list.ListItemType;

public interface BinderFactory {
    ViewHolderBinder create(ListItemType type);
}

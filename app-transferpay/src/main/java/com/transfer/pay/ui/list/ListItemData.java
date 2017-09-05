package com.transfer.pay.ui.list;

import com.google.gson.annotations.JsonAdapter;
import com.transfer.pay.utils.gson.converters.ListItemDataSerializer;

/**
 * Created by i.statkevich on 6/2/17.
 */

@JsonAdapter(ListItemDataSerializer.class)
public class ListItemData {

    private Object data;
    private ListItemType type;

    public ListItemData() {
        // do nothing
    }

    public ListItemData(ListItemType type, Object data) {
        this.type = type;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ListItemType getType() {
        return type;
    }

    public void setType(ListItemType type) {
        this.type = type;
    }
}

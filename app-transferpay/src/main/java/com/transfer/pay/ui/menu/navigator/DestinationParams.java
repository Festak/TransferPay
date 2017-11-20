package com.transfer.pay.ui.menu.navigator;

public class DestinationParams {
    private DestinationType type;
    private Object params;

    public DestinationParams(DestinationType destinationType, Object params) {
        this.type = destinationType;
        this.params = params;
    }

    public DestinationType getType() {
        return type;
    }

    public Object getParams() {
        return params;
    }
}

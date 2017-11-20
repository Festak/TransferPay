package com.transfer.pay.ui.list;

public enum ListItemType {
    UNDEFINED(0),
    BENEFICIARY_CREDIT_CARD(10),
    BENEFICIARY_BANK_ACCOUNT(20),
    CREDIT_CARD(30);

    private int code;

    ListItemType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ListItemType createByCode(int code) {
        for (ListItemType type : ListItemType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }

        return UNDEFINED;
    }
}

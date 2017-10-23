package com.transfer.pay.constants;

/**
 * Created by e.fetskovich on 6/12/17.
 */

public class Constants {
    public static boolean PRODUCTION = false;
    public static final int PICK_IMAGE_ID = 234;

    public static final int TOOLTIP_TOUCH_AREA_PX = 30;
    public static final String ADDITIONAL_INFO_URL = "https://www.bsuir.by/";

    private Constants() {
        // do nothing
    }

    public static class ButtonsState {
        public static final int HIDE_ALL = 10;
        public static final int HIDE_BACK_BUTTON = 25;

        public static final int SHOW_BUTTONS_CONFIRM_LAYOUT = 20;
        public static final int SHOW_BUTTONS_AGREEMENT_LAYOUT = 40;
    }

}

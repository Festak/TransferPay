package com.transfer.pay.utils;

import java.util.Date;

/**
 * Created by e.fetskovich on 6/20/17.
 */

public class FileNameGenerator {

    public static String generateImageFileName(String prefix) {
        return prefix + "" + new Date().getTime() + ".png";
    }

}

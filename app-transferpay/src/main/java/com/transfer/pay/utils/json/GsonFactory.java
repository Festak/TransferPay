package com.transfer.pay.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonFactory {
    public static Gson create() {
        Gson gson = new GsonBuilder()
                .create();

        return gson;
    }
}

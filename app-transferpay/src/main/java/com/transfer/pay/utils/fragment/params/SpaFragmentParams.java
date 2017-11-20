package com.transfer.pay.utils.fragment.params;

import android.os.Bundle;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentParams;

public class SpaFragmentParams extends FragmentParams {
    private String title;

    public SpaFragmentParams(int id, Bundle arguments, String title) {
        super(id, arguments);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

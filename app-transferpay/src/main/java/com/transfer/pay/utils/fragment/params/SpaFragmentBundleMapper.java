package com.transfer.pay.utils.fragment.params;

import android.os.Bundle;

import com.transfer.pay.constants.FragmentBundleFields;

public class SpaFragmentBundleMapper {
    private SpaFragmentBundleMapper() {
        // do nothing
    }

    public static SpaFragmentParams map(Bundle bundle) {
        return new SpaFragmentParams(
                bundle.getInt(FragmentBundleFields.FRAGMENT_ID),
                bundle.getBundle(FragmentBundleFields.FRAGMENT_ARGUMENTS),
                bundle.getString(FragmentBundleFields.FRAGMENT_TITLE)
        );
    }
}

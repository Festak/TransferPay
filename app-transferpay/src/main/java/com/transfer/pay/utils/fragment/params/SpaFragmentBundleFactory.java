package com.transfer.pay.utils.fragment.params;

import android.os.Bundle;

import com.transfer.pay.constants.FragmentBundleFields;

public class SpaFragmentBundleFactory {
    private SpaFragmentBundleFactory() {
        //do nothing
    }

    public static Bundle createBundle(int fragmentId, Bundle fragmentArguments) {
        return createBundle(fragmentId, fragmentArguments, null);
    }

    public static Bundle createBundle(int fragmentId, Bundle fragmentArguments, String title) {
        Bundle bundle = new Bundle();
        bundle.putInt(FragmentBundleFields.FRAGMENT_ID, fragmentId);
        bundle.putBundle(FragmentBundleFields.FRAGMENT_ARGUMENTS, fragmentArguments);
        bundle.putString(FragmentBundleFields.FRAGMENT_TITLE, title);

        return bundle;
    }
}

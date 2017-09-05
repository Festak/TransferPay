package com.transfer.pay.ui.fragments;

import android.support.v4.app.Fragment;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentFactory;
import com.transfer.pay.ui.fragments.registration.stepfive.RegistrationStepFiveFragment;
import com.transfer.pay.ui.fragments.registration.stepfour.RegistrationStepFourFragment;
import com.transfer.pay.ui.fragments.registration.stepone.RegistrationStepOneFragment;
import com.transfer.pay.ui.fragments.registration.stepseven.RegistrationStepSevenFragment;
import com.transfer.pay.ui.fragments.registration.stepsix.RegistrationStepSixFragment;
import com.transfer.pay.ui.fragments.registration.stepthree.RegistrationStepThreeFragment;
import com.transfer.pay.ui.fragments.registration.steptwo.RegistrationStepTwoFragment;
import com.transfer.pay.ui.fragments.registration.twofactorauth.TwoFactorAuthFragment;

import java.util.HashMap;

/**
 * Created by e.fetskovich on 6/5/17.
 */

public class RegistrationFragmentFactory implements FragmentFactory {

    public static final int REGISTRATION_STEP_ONE = 10;
    public static final int REGISTRATION_STEP_TWO = 20;
    public static final int REGISTRATION_STEP_THREE = 30;
    public static final int REGISTRATION_STEP_FOUR = 40;
    public static final int REGISTRATION_STEP_FIVE = 50;
    public static final int REGISTRATION_STEP_SIX = 60;
    public static final int REGISTRATION_STEP_SEVEN = 70;
    public static final int TWO_FACTOR_AUTH = 65;

    private HashMap<Integer, Class<? extends Fragment>> fragmentsList;

    public RegistrationFragmentFactory() {
        this.fragmentsList = createFragmentsList();
    }

    @Override
    public Class<? extends Fragment> getFragmentClass(int i) {
        return fragmentsList.get(i);
    }

    @Override
    public int getDefaultFragmentId() {
        return REGISTRATION_STEP_ONE;
    }

    private static HashMap<Integer, Class<? extends Fragment>> createFragmentsList() {
        HashMap<Integer, Class<? extends Fragment>> fragmentsList = new HashMap<>();
        fragmentsList.put(REGISTRATION_STEP_ONE, RegistrationStepOneFragment.class);
        fragmentsList.put(REGISTRATION_STEP_TWO, RegistrationStepTwoFragment.class);
        fragmentsList.put(REGISTRATION_STEP_THREE, RegistrationStepThreeFragment.class);
        fragmentsList.put(REGISTRATION_STEP_FOUR, RegistrationStepFourFragment.class);
        fragmentsList.put(REGISTRATION_STEP_FIVE, RegistrationStepFiveFragment.class);
        fragmentsList.put(REGISTRATION_STEP_SIX, RegistrationStepSixFragment.class);
        fragmentsList.put(REGISTRATION_STEP_SEVEN, RegistrationStepSevenFragment.class);
        fragmentsList.put(TWO_FACTOR_AUTH, TwoFactorAuthFragment.class);
        return fragmentsList;
    }

}

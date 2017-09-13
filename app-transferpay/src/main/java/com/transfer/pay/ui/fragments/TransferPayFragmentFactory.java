package com.transfer.pay.ui.fragments;

import android.support.v4.app.Fragment;

import com.istatkevich.cmvp.core.fragmentswitcher.FragmentFactory;
import com.transfer.pay.ui.fragments.addcard.AddCardFragment;
import com.transfer.pay.ui.fragments.beneficiaries.BeneficiariesFragment;
import com.transfer.pay.ui.fragments.changepassword.ChangePasswordFragment;
import com.transfer.pay.ui.fragments.logo.LogoFragment;
import com.transfer.pay.ui.fragments.myprofile.MyProfileFragment;
import com.transfer.pay.ui.fragments.newbeneficiary.NewBeneficiaryFragment;
import com.transfer.pay.ui.fragments.paymentoptions.PaymentOptionsFragment;
import com.transfer.pay.ui.fragments.settings.SettingsFragment;
import com.transfer.pay.ui.fragments.settingstab.SettingsTabFragment;
import com.transfer.pay.ui.fragments.terms.TermsFragment;
import com.transfer.pay.ui.fragments.transactionhistory.TransactionHistoryFragment;
import com.transfer.pay.ui.fragments.transactionoverview.TransactionOverviewFragment;

import java.util.HashMap;

/**
 * Created by i.statkevich on 5/25/17.
 */

public class TransferPayFragmentFactory implements FragmentFactory {
    public static final int ID_BENEFICIARIES = 10;
    public static final int ID_NEW_BENEFICIARY = 13;
    public static final int ID_TRANSACTION_HISTORY = 20;
    public static final int ID_TRANSACTION_OVERVIEW = 23;
    public static final int ID_WALLET = 30;
    public static final int ID_MY_PROFILE = 40;
    public static final int ID_TERMS = 50;
    public static final int ID_SETTINGS = 60;
    public static final int ID_PAYMENT_OPTIONS = 70;
    public static final int ID_ADD_CARD = 80;
    public static final int ID_SETTINGS_TAB = 100;
    public static final int ID_LOGO = 110;
    public static final int ID_CHANGEPASS = 120;

    private HashMap<Integer, Class<? extends Fragment>> fragmentsList;

    public TransferPayFragmentFactory() {
        fragmentsList = createFragmentsList();
    }

    @Override
    public Class<? extends Fragment> getFragmentClass(int id) {
        return fragmentsList.get(id);
    }

    @Override
    public int getDefaultFragmentId() {
        return ID_BENEFICIARIES;
    }

    private static HashMap<Integer, Class<? extends Fragment>> createFragmentsList() {
        HashMap<Integer, Class<? extends Fragment>> fragmentsList = new HashMap<>();
        fragmentsList.put(ID_BENEFICIARIES, BeneficiariesFragment.class);
        fragmentsList.put(ID_TRANSACTION_HISTORY, TransactionHistoryFragment.class);
        fragmentsList.put(ID_MY_PROFILE, MyProfileFragment.class);
        fragmentsList.put(ID_TERMS, TermsFragment.class);
        fragmentsList.put(ID_SETTINGS, SettingsFragment.class);
        fragmentsList.put(ID_NEW_BENEFICIARY, NewBeneficiaryFragment.class);
        fragmentsList.put(ID_TRANSACTION_OVERVIEW, TransactionOverviewFragment.class);
        fragmentsList.put(ID_PAYMENT_OPTIONS, PaymentOptionsFragment.class);
        fragmentsList.put(ID_ADD_CARD, AddCardFragment.class);
        fragmentsList.put(ID_SETTINGS_TAB, SettingsTabFragment.class);
        fragmentsList.put(ID_LOGO, LogoFragment.class);
        fragmentsList.put(ID_CHANGEPASS, ChangePasswordFragment.class);
        return fragmentsList;
    }

}

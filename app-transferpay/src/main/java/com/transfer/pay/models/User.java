package com.transfer.pay.models;

import android.databinding.ObservableField;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class User {
    public final ObservableField<String> country = new ObservableField<>();
    public final ObservableField<String> email = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();
    public final ObservableField<String> login = new ObservableField<>();
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableField<String> nationality = new ObservableField<>();

    public final ObservableField<String> dateOfBirth = new ObservableField<>();
    public final ObservableField<String> sex = new ObservableField<>();
    public final ObservableField<String> addressLineOne = new ObservableField<>();
    public final ObservableField<String> addressLineTwo = new ObservableField<>();
    public final ObservableField<String> city = new ObservableField<>();
    public final ObservableField<String> zipOrPostalCode = new ObservableField<>();
    public final ObservableField<String> state = new ObservableField<>();
    public final ObservableField<String> mobileNumber = new ObservableField<>();

    public final ObservableField<String> identificationType = new ObservableField<>();
    public final ObservableField<String> idExpiryDate = new ObservableField<>();
    public final ObservableField<String> idOfScan = new ObservableField<>();
    public final ObservableField<String> idOfDetails = new ObservableField<>();

    public final ObservableField<String> applicationPin = new ObservableField<>();

    public final ObservableField<String> currentLogo = new ObservableField<>();

    public final ObservableField<Transaction> transaction = new ObservableField<>();


}

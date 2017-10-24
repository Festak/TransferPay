package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.transfer.pay.BR;

/**
 * Created by e.fetskovich on 6/6/17.
 */

public class User extends BaseObservable{
    private String country;
    private String email;
    private String password;
    private String login;
    private String firstName;
    private String lastName;
    private String nationality;
    private String dateOfBirth;
    private String sex;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String zipOrPostalCode;
    private String state;
    private String mobileNumber;
    private String identificationType;
    private String idExpiryDate;
    private String idOfScan;
    private String idOfDetails;
    private String applicationPin;
    private String currentLogo;
    private Transaction transaction;

    @Bindable
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        notifyPropertyChanged(BR.country);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        notifyPropertyChanged(BR.login);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
        notifyPropertyChanged(BR.nationality);
    }

    @Bindable
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        notifyPropertyChanged(BR.dateOfBirth);
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }

    @Bindable
    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
        notifyPropertyChanged(BR.addressLineOne);
    }

    @Bindable
    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
        notifyPropertyChanged(BR.addressLineTwo);
    }

    @Bindable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    @Bindable
    public String getZipOrPostalCode() {
        return zipOrPostalCode;
    }

    public void setZipOrPostalCode(String zipOrPostalCode) {
        this.zipOrPostalCode = zipOrPostalCode;
        notifyPropertyChanged(BR.zipOrPostalCode);
    }

    @Bindable
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyPropertyChanged(BR.state);
    }

    @Bindable
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        notifyPropertyChanged(BR.mobileNumber);
    }

    @Bindable
    public String getIdOfScan() {
        return idOfScan;
    }

    public void setIdOfScan(String idOfScan) {
        this.idOfScan = idOfScan;
        notifyPropertyChanged(BR.idOfScan);
    }

    @Bindable
    public String getIdOfDetails() {
        return idOfDetails;
    }

    public void setIdOfDetails(String idOfDetails) {
        this.idOfDetails = idOfDetails;
        notifyPropertyChanged(BR.idOfDetails);
    }

    @Bindable
    public String getApplicationPin() {
        return applicationPin;
    }

    public void setApplicationPin(String applicationPin) {
        this.applicationPin = applicationPin;
        notifyPropertyChanged(BR.applicationPin);
    }

    @Bindable
    public String getCurrentLogo() {
        return currentLogo;
    }

    public void setCurrentLogo(String currentLogo) {
        this.currentLogo = currentLogo;
        notifyPropertyChanged(BR.currentLogo);
    }

    @Bindable
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
        notifyPropertyChanged(BR.transaction);
    }
}

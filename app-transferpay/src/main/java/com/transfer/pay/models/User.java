package com.transfer.pay.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.transfer.pay.BR;

/**
 * Created by e.fetskovich on 6/6/17.
 */

@DatabaseTable(tableName = "user")
public class User extends BaseObservable {

    public static final String userIdField = "user_id";
    @DatabaseField(generatedId = true, columnName = userIdField)
    private int userId;

    public static final String countryField = "country";
    @DatabaseField(columnName = countryField, dataType = DataType.STRING)
    private String country;

    public static final String emailField = "email";
    @DatabaseField(columnName = emailField, dataType = DataType.STRING)
    private String email;

    public static final String passwordField = "password";
    @DatabaseField(columnName = passwordField, dataType = DataType.STRING)
    private String password;

    public static final String loginField = "login";
    @DatabaseField(columnName = loginField, dataType = DataType.STRING)
    private String login;

    public static final String firstNameField = "first_name";
    @DatabaseField(columnName = firstNameField, dataType = DataType.STRING)
    private String firstName;

    public static final String lastNameField = "last_name";
    @DatabaseField(columnName = lastNameField, dataType = DataType.STRING)
    private String lastName;

    public static final String nationalityField = "nationality";
    @DatabaseField(columnName = nationalityField, dataType = DataType.STRING)
    private String nationality;

    public static final String dateOfBirthField = "dateOfBirth";
    @DatabaseField(columnName = dateOfBirthField, dataType = DataType.STRING)
    private String dateOfBirth;

    public static final String sexField = "sex";
    @DatabaseField(columnName = sexField, dataType = DataType.STRING)
    private String sex;

    public static final String addressOneField = "address_one";
    @DatabaseField(columnName = addressOneField, dataType = DataType.STRING)
    private String addressLineOne;

    public static final String addressTwoField = "address_two";
    @DatabaseField(columnName = addressTwoField, dataType = DataType.STRING)
    private String addressLineTwo;

    public static final String cityField = "city";
    @DatabaseField(columnName = cityField, dataType = DataType.STRING)
    private String city;

    public static final String zipOrPostalField = "zip_postal_code";
    @DatabaseField(columnName = zipOrPostalField, dataType = DataType.STRING)
    private String zipOrPostalCode;

    public static final String stateField = "state";
    @DatabaseField(columnName = stateField, dataType = DataType.STRING)
    private String state;

    public static final String mobileNumberField = "mobile_number";
    @DatabaseField(columnName = mobileNumberField, dataType = DataType.STRING)
    private String mobileNumber;

    public static final String idOfScanField = "id_scan";
    @DatabaseField(columnName = idOfScanField, dataType = DataType.STRING)
    private String idOfScan;

    public static final String appPinField = "application_pin";
    @DatabaseField(columnName = appPinField, dataType = DataType.STRING)
    private String applicationPin;

    public static final String currentLogoField = "current_logo";
    @DatabaseField(columnName = currentLogoField, dataType = DataType.STRING)
    private String currentLogo;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<CreditCardModel> creditCards;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<CreditCardAccountModel> creditCardsAccount;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<BankAccountModel> bankAccountModels;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Transaction> transactions;

    @Bindable
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
        notifyPropertyChanged(BR.userId);
    }

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
    public ForeignCollection<CreditCardModel> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(ForeignCollection<CreditCardModel> creditCards) {
        this.creditCards = creditCards;
        notifyPropertyChanged(BR.creditCards);
    }

    @Bindable
    public ForeignCollection<CreditCardAccountModel> getCreditCardsAccount() {
        return creditCardsAccount;
    }

    public void setCreditCardsAccount(ForeignCollection<CreditCardAccountModel> creditCardsAccount) {
        this.creditCardsAccount = creditCardsAccount;
        notifyPropertyChanged(BR.creditCardsAccount);
    }

    @Bindable
    public ForeignCollection<BankAccountModel> getBankAccountModels() {
        return bankAccountModels;
    }

    public void setBankAccountModels(ForeignCollection<BankAccountModel> bankAccountModels) {
        this.bankAccountModels = bankAccountModels;
        notifyPropertyChanged(BR.bankAccountModels);
    }

    @Bindable
    public ForeignCollection<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ForeignCollection<Transaction> transactions) {
        this.transactions = transactions;
        notifyPropertyChanged(BR.transactions);
    }

}

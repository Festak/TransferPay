package com.transfer.pay;

import com.transfer.pay.constants.Fields;
import com.transfer.pay.data.DataStorage;
import com.transfer.pay.models.BankAccountModel;
import com.transfer.pay.models.CreditCardAccountModel;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.models.Role;
import com.transfer.pay.models.Transaction;
import com.transfer.pay.models.User;
import com.transfer.pay.ormlite.ORMLiteFactcory;

import java.sql.SQLException;

/**
 * Created by e.fetskovich on 6/8/17.
 */

public class UserManager {
    private static UserManager instance;
    private User user;
    private DataStorage dataStorage;

    private UserManager() {
        dataStorage = DataStorage.getInstance();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }

        return instance;
    }

    public User updateUser() {
        String login = user.getLogin();
        setUser(getUserByName(login));
        return user;
    }

    public User removeCreditCard(CreditCardModel creditCardModel) {
        user.getCreditCards().remove(creditCardModel);
        try {
            ORMLiteFactcory.getHelper().getCreditCardDao().delete(creditCardModel);
            ORMLiteFactcory.getHelper().getUserDao().refresh(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateUser();
    }

    public CreditCardModel getCreditCardById(int id) {
        CreditCardModel model = null;
        for (CreditCardModel creditCardModel : user.getCreditCards()) {
            if (creditCardModel.getCreditCardId() == id) {
                model = creditCardModel;
            }
        }
        return model;
    }

    public User getUserByName(String login) {
        User user = null;
        try {
            user = ORMLiteFactcory.getHelper().getUserDao().getUser(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Role getRoleByName(String name) {
        Role role = null;
        try {
            role = ORMLiteFactcory.getHelper().getRolesDao().getRole(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public void insertBankAccount(BankAccountModel bankAccountModel) {
        bankAccountModel.setUser(user);
        try {
            ORMLiteFactcory.getHelper().getBankAccountModelDao().create(bankAccountModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCreditCardAccount(CreditCardAccountModel creditCardModel) {
        creditCardModel.setUser(user);
        try {
            ORMLiteFactcory.getHelper().getCreditCardAccountDao().create(creditCardModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTransaction(Transaction transaction) {
        transaction.setUser(user);
        try {
            ORMLiteFactcory.getHelper().getTransactionDao().create(transaction);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCreditCard(CreditCardModel creditCardModel) {
        creditCardModel.setUser(user);
        try {
            ORMLiteFactcory.getHelper().getCreditCardDao().create(creditCardModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void reInitUser() {
        user = new User();
        dataStorage.removeKey(Fields.Preferences.USER);
    }

    public String getCurrentLogo() {
        return user.getCurrentLogo();
    }

    public void changeUserPassword(String password) {
        user.setPassword(password);
        try {
            ORMLiteFactcory.getHelper().getUserDao().update(user);
            updateUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

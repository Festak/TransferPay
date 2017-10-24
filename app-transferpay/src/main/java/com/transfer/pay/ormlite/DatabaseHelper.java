package com.transfer.pay.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.transfer.pay.models.BankAccountModel;
import com.transfer.pay.models.CreditCardAccountModel;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.models.Transaction;
import com.transfer.pay.models.User;
import com.transfer.pay.ormlite.Dao.BankAccountModelDao;
import com.transfer.pay.ormlite.Dao.CreditCardAccountDao;
import com.transfer.pay.ormlite.Dao.CreditCardDao;
import com.transfer.pay.ormlite.Dao.TransactionDao;
import com.transfer.pay.ormlite.Dao.UserDao;

import java.sql.SQLException;

/**
 * @author e.fetskovich on 10/23/17.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "transferPay.db";

    private static final int DATABASE_VERSION = 7;

    private UserDao userDao = null;
    private CreditCardDao creditCardDao = null;
    private BankAccountModelDao bankAccountModelDao;
    private CreditCardAccountDao creditCardAccountDao;
    private TransactionDao transactionDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, CreditCardModel.class);
            TableUtils.createTable(connectionSource, BankAccountModel.class);
            TableUtils.createTable(connectionSource, CreditCardAccountModel.class);
            TableUtils.createTable(connectionSource, Transaction.class);
        } catch (SQLException e) {
            Log.e(TAG, "error creating DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer,
                          int newVer) {
        try {
            TableUtils.dropTable(connectionSource, CreditCardModel.class, true);
            TableUtils.dropTable(connectionSource, BankAccountModel.class, true);
            TableUtils.dropTable(connectionSource, CreditCardAccountModel.class, true);
            TableUtils.dropTable(connectionSource, Transaction.class, true);
            TableUtils.dropTable(connectionSource, User.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(TAG, "error upgrading db " + DATABASE_NAME + "from ver " + oldVer);
            throw new RuntimeException(e);
        }
    }

    public UserDao getUserDao() {
        if (userDao == null) {
            try {
                userDao = new UserDao(getConnectionSource(), User.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userDao;
    }

    public CreditCardDao getCreditCardDao() {
        if (creditCardDao == null) {
            try {
                creditCardDao = new CreditCardDao(getConnectionSource(), CreditCardModel.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return creditCardDao;
    }

    public BankAccountModelDao getBankAccountModelDao() {
        if (bankAccountModelDao == null) {
            try {
                bankAccountModelDao = new BankAccountModelDao(getConnectionSource(), BankAccountModel.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bankAccountModelDao;
    }

    public CreditCardAccountDao getCreditCardAccountDao() {
        if (creditCardAccountDao == null) {
            try {
                creditCardAccountDao = new CreditCardAccountDao(getConnectionSource(), CreditCardAccountModel.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return creditCardAccountDao;
    }

    public TransactionDao getTransactionDao() {
        if (transactionDao == null) {
            try {
                transactionDao = new TransactionDao(getConnectionSource(), Transaction.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return transactionDao;
    }

    @Override
    public void close() {
        super.close();
        userDao = null;
        creditCardDao = null;
        creditCardAccountDao = null;
        bankAccountModelDao = null;
        transactionDao = null;
    }
}

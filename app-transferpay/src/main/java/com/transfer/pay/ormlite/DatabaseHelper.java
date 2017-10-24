package com.transfer.pay.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.transfer.pay.models.CreditCardModel;
import com.transfer.pay.models.User;
import com.transfer.pay.ormlite.Dao.CreditCardDao;
import com.transfer.pay.ormlite.Dao.UserDao;

import java.sql.SQLException;

/**
 * @author e.fetskovich on 10/23/17.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "transferPay.db";

    private static final int DATABASE_VERSION = 2;

    private UserDao userDao = null;
    private CreditCardDao creditCardDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, CreditCardModel.class);
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

    @Override
    public void close() {
        super.close();
        userDao = null;
        creditCardDao = null;
    }
}
